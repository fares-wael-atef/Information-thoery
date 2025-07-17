import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DPCMImplementation {
    private static final int[] QUANTIZATION_LEVELS = {8, 16, 32};
    private static final String[] PREDICTOR_TYPES = {"Order-1", "Order-2", "Adaptive"};
    private static final String OUTPUT_DIR = "dpcm_output";
    private int[][] imageData;
    private int[] textData;
    private int width, height;
    private int length;
    private boolean isImage;
    private String inputSource;
    private String inputText; // Store the raw text for size calculation

    public static void main(String[] args) {
        DPCMImplementation dpcm = new DPCMImplementation();
        dpcm.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DPCM Implementation");
        System.out.println("Choose input type:");
        System.out.println("1. Image");
        System.out.println("2. Text");
        System.out.print("Enter choice (1 or 2): ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        try {
            switch (choice) {
                case 1:
                    isImage = true;
                    System.out.print("Enter image file path: ");
                    inputSource = scanner.nextLine();
                    if (!new File(inputSource).exists()) {
                        System.out.println("Image file does not exist. Exiting.");
                        return;
                    }
                    processInput();
                    break;
                case 2:
                    isImage = false;
                    System.out.print("Enter text (or file path): ");
                    inputSource = scanner.nextLine();
                    processInput();
                    break;
                default:
                    System.out.println("Invalid choice. Exiting.");
                    return;
            }
        } catch (IOException e) {
            System.out.println("Error processing input: " + e.getMessage());
        }
    }

    private void processInput() throws IOException {
        Files.createDirectories(Paths.get(OUTPUT_DIR));

        StringBuilder report = new StringBuilder("DPCM Assignment Report\n\n");
        StringBuilder calculations = new StringBuilder("Calculations\n\n");
        calculations.append("Predictor\tQuantization Levels\tMSE\tCompression Ratio\tOriginal Size (bytes)\tEncoded Size (bytes)\n");
        calculations.append("------------------------------------------------------------------------------------------------\n");

        long originalSize;
        if (isImage) {
            imageData = readGrayscaleImage(inputSource);
            width = imageData.length;
            height = imageData[0].length;
            originalSize = new File(inputSource).length();
            report.append("Input Image\n");
            report.append(String.format("- Path: %s\n", inputSource));
            report.append(String.format("- Dimensions: %d x %d pixels\n", width, height));
            report.append(String.format("- Original Size: %d bytes\n\n", originalSize));
        } else {
            textData = readTextInput(inputSource);
            length = textData.length;
            originalSize = inputText.getBytes("UTF-8").length;
            report.append("Input Text\n");
            report.append(String.format("- Source: %s\n", isFile(inputSource) ? inputSource : "Direct input"));
            report.append(String.format("- Length: %d characters\n", length));
            report.append(String.format("- Original Size: %d bytes\n\n", originalSize));
        }

        for (String predictorType : PREDICTOR_TYPES) {
            report.append(String.format("Predictor: %s\n", predictorType));
            for (int levels : QUANTIZATION_LEVELS) {
                String encodedFile = String.format("%s/encoded_%s_%d.dat", OUTPUT_DIR, predictorType, levels);
                String outputFile = isImage ? String.format("%s/output_%s_%d.png", OUTPUT_DIR, predictorType, levels) : String.format("%s/output_%s_%d.txt", OUTPUT_DIR, predictorType, levels);
                long encodedSize;
                double mse;

                if (isImage) {
                    int[][] residuals = encodeImage(predictorType, levels);
                    saveResiduals(residuals, encodedFile);
                    int[][] reconstructed = decodeImage(predictorType, residuals);
                    saveImage(reconstructed, outputFile); // Save reconstructed image for all configurations
                    mse = calculateImageMSE(imageData, reconstructed);
                    encodedSize = new File(encodedFile).length();
                } else {
                    int[] residuals = encodeText(predictorType, levels);
                    saveTextResiduals(residuals, encodedFile);
                    int[] reconstructed = decodeText(predictorType, residuals);
                    saveText(reconstructed, outputFile); // Save reconstructed text for all configurations
                    mse = calculateTextMSE(textData, reconstructed);
                    encodedSize = new File(encodedFile).length();
                }

                double compressionRatio = (double) originalSize / encodedSize;

                calculations.append(String.format("%s\t%d\t%.2f\t%.2f\t%d\t%d\n",
                        predictorType, levels, mse, compressionRatio, originalSize, encodedSize));

                report.append(String.format("Quantization Levels: %d\n", levels));
                report.append(String.format("- MSE: %.2f\n", mse));
                report.append(String.format("- Compression Ratio: %.2f\n", compressionRatio));
                report.append(String.format("- Original Size: %d bytes\n", originalSize));
                report.append(String.format("- Encoded Size: %d bytes\n", encodedSize));
                report.append(String.format("- Encoded File: %s\n", encodedFile));
                report.append(String.format("- Output File: %s\n\n", outputFile));
            }
        }

        report.append("Implemented Code\n");
        report.append("---------------\n");
        try (BufferedReader reader = new BufferedReader(new FileReader("DPCMImplementation.java"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                report.append(line).append("\n");
            }
        }
        report.append("---------------\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/calculations.txt"))) {
            writer.write(calculations.toString());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_DIR + "/report.txt"))) {
            writer.write(report.toString());
        }
    }

    private int[][] readGrayscaleImage(String path) throws IOException {
        BufferedImage img = ImageIO.read(new File(path));
        width = img.getWidth();
        height = img.getHeight();
        int[][] pixels = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = img.getRGB(i, j);
                int gray = (rgb >> 16) & 0xFF;
                pixels[i][j] = gray;
            }
        }
        return pixels;
    }

    private int[] readTextInput(String input) throws IOException {
        if (isFile(input)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                inputText = sb.toString();
            }
        } else {
            inputText = input;
        }
        int[] asciiValues = new int[inputText.length()];
        for (int i = 0; i < inputText.length(); i++) {
            int ascii = inputText.charAt(i);
            asciiValues[i] = (ascii >= 32 && ascii <= 126) ? ascii : 32;
        }
        return asciiValues;
    }

    private boolean isFile(String input) {
        return new File(input).exists();
    }

    private int[][] encodeImage(String predictorType, int quantizationLevels) {
        int[][] residuals = new int[width][height];
        int[][] tempImage = new int[width][height];
        int maxError = 255;
        int quantizationStep = (2 * maxError) / quantizationLevels;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int predicted = predictImagePixel(i, j, predictorType, tempImage);
                int error = imageData[i][j] - predicted;
                int quantizedError = Math.round((float) error / quantizationStep) * quantizationStep;
                residuals[i][j] = quantizedError;
                tempImage[i][j] = Math.max(0, Math.min(255, predicted + quantizedError));
            }
        }
        return residuals;
    }

    private int[] encodeText(String predictorType, int quantizationLevels) {
        int[] residuals = new int[length];
        int[] tempText = new int[length];
        int maxError = 100;
        int quantizationStep = (2 * maxError) / quantizationLevels;

        for (int i = 0; i < length; i++) {
            int predicted = predictTextPixel(i, predictorType, tempText);
            int error = textData[i] - predicted;
            int quantizedError = Math.round((float) error / quantizationStep) * quantizationStep;
            residuals[i] = quantizedError;
            tempText[i] = Math.max(32, Math.min(126, predicted + quantizedError));
        }
        return residuals;
    }

    private int predictImagePixel(int i, int j, String predictorType, int[][] image) {
        if (i == 0 && j == 0) return 0;
        int A = (j > 0) ? image[i][j-1] : 0;
        int B = (i > 0 && j > 0) ? image[i-1][j-1] : 0;
        int C = (i > 0) ? image[i-1][j] : 0;

        switch (predictorType) {
            case "Order-1":
                return A;
            case "Order-2":
                return (j > 0 && i > 0) ? A + C - B : A;
            case "Adaptive":
                if (j == 0) return C;
                if (i == 0) return A;
                if (B <= Math.min(A, C)) return Math.max(A, C);
                if (B >= Math.max(A, C)) return Math.min(A, C);
                return A + C - B;
            default:
                return 0;
        }
    }

    private int predictTextPixel(int i, String predictorType, int[] text) {
        if (i == 0) return 32;
        int A = text[i-1];
        int B = (i > 1) ? text[i-2] : 32;

        switch (predictorType) {
            case "Order-1":
                return A;
            case "Order-2":
                return (i > 1) ? (A + B) / 2 : A;
            case "Adaptive":
                if (i == 1) return A;
                return Math.min(126, Math.max(32, (A + B) / 2));
            default:
                return 32;
        }
    }

    private int[][] decodeImage(String predictorType, int[][] residuals) {
        int[][] reconstructed = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int predicted = predictImagePixel(i, j, predictorType, reconstructed);
                int pixelValue = predicted + residuals[i][j];
                reconstructed[i][j] = Math.max(0, Math.min(255, pixelValue));
            }
        }
        return reconstructed;
    }

    private int[] decodeText(String predictorType, int[] residuals) {
        int[] reconstructed = new int[length];
        for (int i = 0; i < length; i++) {
            int predicted = predictTextPixel(i, predictorType, reconstructed);
            int value = predicted + residuals[i];
            reconstructed[i] = Math.max(32, Math.min(126, value));
        }
        return reconstructed;
    }

    private double calculateImageMSE(int[][] original, int[][] reconstructed) {
        double mse = 0.0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int diff = original[i][j] - reconstructed[i][j];
                mse += diff * diff;
            }
        }
        return mse / (width * height);
    }

    private double calculateTextMSE(int[] original, int[] reconstructed) {
        double mse = 0.0;
        for (int i = 0; i < length; i++) {
            int diff = original[i] - reconstructed[i];
            mse += diff * diff;
        }
        return mse / length;
    }

    private void saveResiduals(int[][] residuals, String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    dos.writeInt(residuals[i][j]);
                }
            }
        }
    }

    private void saveTextResiduals(int[] residuals, String path) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            for (int residual : residuals) {
                dos.writeInt(residual);
            }
        }
    }

    private void saveImage(int[][] pixels, String path) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int gray = pixels[i][j];
                int rgb = (gray << 16) | (gray << 8) | gray;
                image.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(image, "png", new File(path));
    }

    private void saveText(int[] asciiValues, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            for (int value : asciiValues) {
                writer.write((char) value);
            }
        }
    }
}