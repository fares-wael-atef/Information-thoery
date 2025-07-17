LZ77 Compression Algorithm
Overview
This project implements the LZ77 compression algorithm, a lossless data compression technique that uses a sliding window to find repeated patterns in text. The program supports both compression and decompression functionalities and provides a user-friendly interface to interact with the compression process.
Features

Compression:
Reads input text from a specified file.
Utilizes a sliding window approach to identify repeated patterns.
Generates LZ77 tags (position, length, next character) for efficient compression.
Saves compressed data to an output file.
Calculates and stores the compression ratio and other details in a Calculations.txt file.


Decompression:
Reads compressed tags from a file.
Reconstructs the original text from the tags.
Saves the decompressed output back to a specified file.


User Interaction:
Provides a menu-driven interface with options to:
Compress a file
Decompress a file
Exit the program





Installation

Clone the repository:git clone https://github.com/your-username/lz77-compression.git


Navigate to the project directory:cd lz77-compression


Ensure you have the necessary dependencies installed (e.g., a compatible programming language environment like Python, C++, or another language used for the implementation).
If using Python, install dependencies (if any) via:pip install -r requirements.txt


For other languages, ensure the compiler/interpreter is set up (e.g., g++ for C++).



Usage

Run the program:python lz77.py  # Replace with the appropriate command for your language


Follow the on-screen menu:Enter your choice:
1: Compress
2: Decompress
3: Exit


For compression:
Select option 1.
Provide the path to the input text file.
The compressed output will be saved to a specified file, and compression details (e.g., compression ratio) will be written to Calculations.txt.


For decompression:
Select option 2.
Provide the path to the compressed file.
The decompressed text will be saved to a specified output file.


To exit, select option 3.

Calculations

The program generates a Calculations.txt file during compression, which includes details such as the compression ratio and other relevant metrics.
Ensure you check this file for insights into the compression performance.

Notes

Ensure input files are accessible and in the correct format before running the program.
The implementation assumes standard text file input for compression and valid LZ77 tags for decompression.
For large files, ensure sufficient memory for the sliding window approach.

License
This project is licensed under the MIT License - see the LICENSE file for details.
