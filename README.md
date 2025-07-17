Image Classification and Processing in Java
Overview
This Java-based project performs image classification and processing on a dataset organized into categories (Animals, Faces, Nature) with train and test directories. It supports image loading, organization, processing (including RGB and YUV color space conversions), similarity calculations, dataset statistics generation, and compression of processed outputs into a ZIP file. The program leverages RGB and YUV color spaces to analyze image quality and compression efficiency, producing detailed reports with metrics like compression ratio and Peak Signal-to-Noise Ratio (PSNR).
Features

Dataset Processing:
Loads and organizes images from train and test directories, categorized as Animals, Faces, and Nature.
Generates dataset statistics (e.g., number of images per category).


Image Processing:
Supports RGB processing (resizing, optional grayscale conversion).
Converts images to YUV color space for compression analysis.


Similarity Analysis:
Calculates similarity scores for images in RGB and YUV color spaces.


Compression and Reporting:
Generates compression ratio reports for RGB and YUV processing.
Produces YUV processing reports and organizes outputs.
Compresses processed images into a ZIP file.


Metrics:
Measures processing time, output size, compression ratio, and PSNR for quality assessment.



Code Structure
The program is implemented in a single Java class, ImageClassification, with modular methods:

Main Method:
Orchestrates the workflow, calling methods for dataset processing, image processing, similarity calculations, and compression.


Dataset Processing:
processDataset: Loads and organizes images by category.
printStatistics: Outputs dataset statistics (e.g., number of images per category).


Image Processing:
processImage: Handles resizing and optional grayscale conversion for RGB images.
convertToYUV: Converts RGB pixels to YUV using the equations:
( Y = 0.299R + 0.587G + 0.114B )
( U = 0.492(B - Y) )
( V = 0.877(R - Y) )


saveYUVImage: Saves YUV-processed images.


Similarity Analysis:
calculateImageSimilarity: Computes similarity scores for RGB images.
calculateYUVSimilarity: Computes similarity scores for YUV images.


Reporting:
generateCompressionRatioReport: Creates a report with compression ratios and metrics.
batchProcessToYUV: Processes all images to YUV and generates a processing report.


File Management:
organizeImages: Organizes processed images into the output/organized directory.
compressOutputToZip: Compresses outputs into a ZIP file.



Installation

Clone the repository:git clone https://github.com/your-username/image-classification-processing.git


Navigate to the project directory:cd image-classification-processing


Ensure you have a Java Development Kit (JDK) installed (e.g., JDK 8 or later).
Compile the Java program:javac ImageClassification.java



Usage

Prepare a dataset with the following structure:dataset/
├── train/
│   ├── Animals/
│   ├── Faces/
│   ├── Nature/
├── test/
│   ├── Animals/
│   ├── Faces/
│   ├── Nature/


Run the program:java ImageClassification


The program processes the dataset and generates:
Dataset statistics printed to the console.
Processed images (RGB and YUV) saved in output/organized.
Compression ratio report in output/reports/compression_ratio_report.txt.
YUV processing report in output/yuv-processing_report.txt.
A ZIP file containing all processed outputs.



Output Files

output/organized: Directory containing processed images (RGB and YUV).
output/reports/compression_ratio_report.txt: Report with compression ratios, processing times, output sizes, and PSNR for RGB and YUV processing.
output/yuv-processing_report.txt: Detailed report on YUV processing results.
output/compressed_output.zip: ZIP file containing all processed images and reports.

Sample Terminal Output
Below is a sample terminal output from the program:
Starting Image Classification and Processing...
Found 10 images in train/Animals
Found 10 images in train/Faces
Found 9 images in train/Nature
Found 5 images in test/Animals
Found 5 images in test/Faces
Found 5 images in test/Nature
--- Dataset Statistics ---
Animals: 15 images
Faces: 15 images
Nature: 14 images
Total images: 44
--- RGB vs YUV Comparison ---
Original image size: 9909 bytes
RGB Processing:
    - Processing time: 8 ms
    - Output size: 12045 bytes
    - Compression ratio: 0.82
YUV Processing:
    - Processing time: 14 ms
    - Output size: 7580 bytes
    - Compression ratio: 1.31
RGB Quality (PSNR): 39.70 dB
YUV Quality (PSNR): 12.64 dB
Conclusion: YUV provides better compression
RGB Similarity: 0.8461283681538626
YUV Similarity: 0.8465289233663107
Compression ratio report generated: output\reports\compression_ratio_report.txt
Images organized successfully in: output\organized
YUV processing report generated: output\yuv-processing_report.txt
Successfully batch processed all images to YUV
Successfully compressed output to zip file
Image classification and processing completed successfully!

Notes

Ensure the dataset is organized correctly with train and test directories containing categorized images (Animals, Faces, Nature).
Supported image formats include PNG and JPEG.
YUV processing typically achieves better compression ratios due to its separation of luminance and chrominance, as shown in the sample output (1.31 vs. 0.82 for RGB).
The program requires sufficient memory for processing large datasets.
The compression ratio and PSNR metrics provide insights into the trade-off between compression efficiency and image quality.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Author

Fares Wael (Student ID: 202201260)

References

Java AWT Documentation: https://docs.oracle.com/javase/8/docs/api/java/awt/package-summary.html
YUV Color Space: https://en.wikipedia.org/wiki/YUV
