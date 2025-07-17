LZ78 Compression Algorithm
Overview
This project implements the LZ78 compression algorithm, a dictionary-based lossless data compression technique. The program, written in Java, reads an input file, compresses its contents using LZ78 encoding, and writes the compressed data to an output file. It also provides a decompression function to reconstruct the original data. The program features a menu-driven interface for user interaction.
Features

Compression:
Reads text from an input file (input.txt).
Builds a dictionary of substrings and generates LZ78 tags (index, next character).
Writes compressed tags to output_of_compression_tags.txt.
Saves compressed binary data to output.bin.
Calculates compression metrics (e.g., compression ratio) and stores them in calculations.txt.


Decompression:
Reads compressed data from output.bin.
Reconstructs the original text using a dictionary.
Saves the decompressed output to decompressed.txt.


User Interaction:
Provides a menu-driven interface with options to:
Compress a file
Decompress a file
Exit the program





Code Structure
The program is organized into the following components:

LZ78Tag Class:
Defines the structure of LZ78 tags, each containing:
index: References a previously stored dictionary entry.
nextChar: The next unique character.


Includes a toString() method for tag representation (e.g., <index, nextChar>).


Compression Method:
Reads input text and initializes a dictionary (HashMap).
Iterates through the text, building substrings and assigning dictionary indexes.
Generates LZ78 tags and writes them to a text file.
Saves binary compressed data and calculates metrics.


Decompression Method:
Reads binary compressed data and extracts tags.
Rebuilds the original text using a dictionary.
Writes the result to decompressed.txt.


Main Method:
Implements a menu-driven interface for user interaction.



Installation

Clone the repository:git clone https://github.com/your-username/lz78-compression.git


Navigate to the project directory:cd lz78-compression


Ensure you have a Java Development Kit (JDK) installed (e.g., JDK 8 or later).
Compile the Java program:javac LZ78.java



Usage

Run the program:java LZ78


Follow the on-screen menu:Enter your choice:
1: Compress
2: Decompress
3: Exit


For compression:
Select option 1.
Ensure input.txt exists in the project directory with the text to compress.
The program generates:
output_of_compression_tags.txt: Contains LZ78 tags.
output.bin: Contains binary compressed data.
calculations.txt: Contains metrics like compression ratio.




For decompression:
Select option 2.
Ensure output.bin exists in the project directory.
The decompressed text will be saved to decompressed.txt.


To exit, select option 3.

Calculations
The program generates a calculations.txt file during compression, which includes:

Original Size: Size of the input file in bits (e.g., 72 bits).
Max Index Value: Maximum dictionary index and its bit requirement (e.g., 3 -> 2 bits).
Tag Size: Total bits per tag (e.g., 2 bits for index + 8 bits for character = 16 bits).
Number of Tags: Total tags generated (e.g., 6).
Compressed Size: Size of the compressed data in bits (e.g., 60 bits).
Compression Ratio: Ratio of compressed size to original size (e.g., 0.83).

Test Cases

Test Case 1: (Details incomplete in the provided document.)
Input: (To be specified; provide a sample input.txt for testing).
Expected Output: Compressed tags in output_of_compression_tags.txt, binary data in output.bin, and metrics in calculations.txt.


Test Case 2: (Details incomplete in the provided document.)
Input: (To be specified; provide a sample input.txt for testing).
Expected Output: Sequence of numbers or characters (e.g., "102, 103, 104, ...") indicating dictionary entries or tags.



Note: For accurate test case results, please provide specific input files and expected outputs to verify the program's behavior.
Notes

Ensure input files (input.txt) are in the correct format and accessible.
The program assumes text input for compression and valid LZ78 tags for decompression.
For large files, ensure sufficient memory for dictionary storage.
The calculations.txt file provides insights into compression efficiency.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Author

Fares Wael (Student ID: 202201260)
