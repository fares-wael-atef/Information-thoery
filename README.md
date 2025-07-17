DPCM Compression Implementation in Java
Overview
This project implements Differential Pulse Code Modulation (DPCM) for compressing grayscale images and text in Java. DPCM predicts the next pixel or character value and encodes the difference (residual) to achieve compression. The program supports three predictor types (Order-1, Order-2, and Adaptive) and applies quantization levels (8, 16, and 32) to analyze compression efficiency and reconstruction quality. Performance metrics such as Mean Squared Error (MSE) and compression ratio are calculated and saved.
Features

Input Processing:
Supports compression of grayscale images and text files.
Reads input from user-specified files.


Predictors:
Order-1: Predicts based on the previous pixel/character.
Order-2: Uses the two previous pixels/characters for prediction.
Adaptive: Dynamically adjusts prediction based on input patterns.


Quantization:
Applies quantization levels of 8, 16, and 32 to residuals for varying compression levels.


Metrics:
Calculates Mean Squared Error (MSE) to measure reconstruction quality.
Computes compression ratio (original size / encoded size).


Output:
Saves reconstructed images or text files.
Generates a report with performance metrics (MSE, compression ratio, original size, encoded size).



Code Structure

Main Function:
Provides a user interface to select between image or text input.


Process Input:
Reads the input file (image or text).
Applies DPCM encoding and decoding using specified predictors and quantization levels.
Computes performance metrics.


Predictors:
Implements Order-1, Order-2, and Adaptive predictors for estimating the next pixel/character.


Quantization:
Quantizes residuals using 8, 16, or 32 levels to control compression.


Output Handling:
Saves reconstructed images/text and metrics (MSE, compression ratio) to output files.



Installation

Clone the repository:git clone https://github.com/your-username/dpcm-compression.git


Navigate to the project directory:cd dpcm-compression


Ensure you have a Java Development Kit (JDK) installed (e.g., JDK 8 or later).
Compile the Java program:javac DPCM.java



Usage

Run program:java DPCM


Follow the console-based prompts to:
Choose input type (image or text).
Specify the input grayscale image or text file path.
Select predictor type (Order-1, Order-2, or Adaptive).
Choose quantization level (8, 16, or 32).


The program processes the input and generates:
Reconstructed image or text file.
Report file containing MSE, compression ratio, original size, and encoded size.



Output Files

Reconstructed Image/Text:
Reconstructed grayscale image (e.g., reconstructed.png) or text file (e.g., reconstructed.txt).


Report File:
Contains performance metrics:
Mean Squared Error (MSE).
Compression ratio (original size / encoded size).
Original size (in bytes).
Encoded size (in bytes).





Test Cases

Test Case 1: Image Compression:
Input: Grayscale image (details not specified; provide a sample image, e.g., input.png).
Configuration: Order-2 predictor, quantization level 16.
Results:
MSE: 12.83
Compression Ratio: 2.46
Original Size: 12,288 bytes
Encoded Size: 5,000 bytes


Output: Reconstructed image and report file with metrics.


Test Case 2: Image Compression:
Input: Grayscale image (details not specified; provide a sample image, e.g., input.png).
Configuration: Adaptive predictor, quantization level 8.
Results:
MSE: 23.41
Compression Ratio: 3.91
Original Size: 12,288 bytes
Encoded Size: 3,142 bytes


Output: Reconstructed image and report file with metrics.


Note: The document lacks detailed input image descriptions. For accurate testing, provide specific grayscale images or text files and expected outputs.

Notes

Ensure input grayscale images (e.g., input.png) or text files are in the correct format and accessible.
The choice of predictor and quantization level impacts compression ratio and reconstruction quality (e.g., lower quantization levels increase compression but may increase MSE).
For large images, ensure sufficient memory for processing.
The report file provides insights into compression performance via MSE and compression ratio.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Author

Fares Atef (Student ID: 202201260)
