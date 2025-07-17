Vector Quantization Image Compression in Java
Overview
This project implements Vector Quantization (VQ) for image compression in Java. VQ reduces image size by representing blocks of pixels with a smaller codebook of representative vectors, using the Linde-Buzo-Gray (LBG) algorithm and K-means clustering. The program processes an input RGB image, converts it to grayscale, compresses it, and reconstructs a compressed version, while generating a report with metrics like Mean Square Error (MSE) and compression ratio.
Features

Image Processing:
Converts RGB images to grayscale to simplify data.
Adjusts image dimensions to be divisible by the specified block size.
Divides the image into non-overlapping square blocks.
Generates a codebook using the LBG algorithm and K-means clustering.
Replaces each block with the nearest codebook vector for compression.
Reconstructs the compressed image from the codebook.


Metrics and Reporting:
Calculates Mean Square Error (MSE) between the original and reconstructed images.
Generates a report summarizing MSE, compression ratio, and other results.


User Input:
Accepts the path to an RGB image, block size (e.g., 4x4 pixels), and codebook size (number of representative vectors, K).



Libraries Used

javax.imageio.ImageIO: For reading and writing images.
java.awt.* and java.awt.image.BufferedImage: For image handling.
java.io.*: For file reading and writing.
java.util.*: For handling lists, arrays, and user input.
Note: javax.swing.* is included but unused (potentially for future GUI implementation).

Processing Steps

Convert to Grayscale (convertToGrayscale):
Converts the input RGB image to grayscale to reduce complexity.


Adjust Image Size:
Resizes the image (without interpolation) to ensure dimensions are divisible by the block size.


Block Division (createBlocks):
Divides the grayscale image into non-overlapping square blocks (e.g., 4x4 pixels).


Codebook Generation (generateCodebook):
Implements the LBG algorithm, starting with the average of all blocks.
Splits codewords by small perturbations and refines them using K-means clustering until convergence.


Find Nearest Vector (findNearestVector):
Calculates the Euclidean distance between a block and each codebook vector, returning the index of the closest vector.


Euclidean Distance (euclideanDistance):
Computes the standard Euclidean distance between two vectors.


Image Reconstruction (reconstructImage):
Reconstructs the compressed image using the codebook vectors.


Calculate MSE (calculateMSE):
Computes the Mean Square Error between the original grayscale and reconstructed images.


Generate Report (generateReport):
Creates a human-readable report summarizing MSE, compression ratio, and other metrics.



Installation

Clone the repository:git clone https://github.com/your-username/vq-image-compression.git


Navigate to the project directory:cd vq-image-compression


Ensure you have a Java Development Kit (JDK) installed (e.g., JDK 8 or later).
Compile the Java program:javac VectorQuantization.java



Usage

Run the program:java VectorQuantization


Provide the required inputs when prompted:
Path to the input RGB image (e.g., input.png).
Block size (e.g., 4 for 4x4 pixel blocks).
Codebook size (e.g., 256 for 256 representative vectors).


The program processes the image and generates output files:
grayscale.png: Grayscale version of the input image.
adjusted_grayscale.png: Adjusted image if resizing was needed (optional).
reconstructed.png: Compressed and reconstructed image.
report.txt: Summary report with MSE, compression ratio, and other metrics.



Output Files

grayscale.png: Grayscale version of the original image.
adjusted_grayscale.png: Adjusted image if resizing was required to match block size.
reconstructed.png: Final compressed and reconstructed image.
report.txt: Summary report including MSE, compression ratio, and other results.

Test Cases

Input 1:
Input: RGB image (details not specified; provide a sample input.png).
Output: grayscale.png, reconstructed.png, report.txt (and optionally adjusted_grayscale.png).


Input 2:
Input: Another RGB image (details not specified; provide a sample input.png).
Output: Similar to Input 1, with corresponding files.


Calculation Results and Report:
Includes MSE, compression ratio, and other metrics in report.txt.


Note: The provided document lacks detailed test case inputs and outputs. For accurate testing, provide specific input images and expected results to verify the program's behavior.

Notes

Ensure the input image (input.png) is in a supported format (e.g., PNG, JPEG) and accessible.
The block size and codebook size significantly affect compression quality and performance.
For large images, ensure sufficient memory for block processing and K-means clustering.
The report.txt file provides insights into compression efficiency via MSE and compression ratio.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Author

Fares Wael (Student ID: 202201260)
