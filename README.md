Huffman Coding Implementation in Java
Overview
This project implements the Huffman Coding algorithm, a lossless data compression technique that assigns variable-length codes to characters based on their frequencies. More frequent characters receive shorter codes, optimizing the overall size of the encoded data. The Java program supports encoding and decoding text, calculating entropy, and managing code tables, with a console-based user interface for interaction.
Features

Encoding:
Reads text from input.txt.
Computes character frequencies and entropy.
Builds a Huffman tree using a priority queue.
Generates variable-length Huffman codes for characters.
Encodes text into a binary string and saves it to encoded.bin.
Stores Huffman code mappings in code_table.txt and entropy/frequency details in calculations.txt.


Decoding:
Reads code mappings from code_table.txt and compressed data from encoded.bin.
Rebuilds the Huffman tree and decodes the binary string back to the original text.
Saves the decoded text to output.txt.


User Interface:
Provides a console-based menu with options to:
Encode text
Decode text
Exit the program





Class Structure

HuffmanNode:
Represents a node in the Huffman tree with:
character: The character being represented.
frequency: The frequency of the character.
left, right: Child node pointers.


Implements Comparable<HuffmanNode> for sorting by frequency in a priority queue.


HuffmanCoding:
Main class containing core methods:
calculateEntropy: Computes the entropy of the text based on character frequencies.
buildHuffmanTree: Constructs the Huffman tree using a priority queue.
generateHuffmanCodes: Recursively assigns binary codes to characters.
encodeText: Encodes input text using Huffman codes.
decodeHuffman: Decodes binary string back to text.
rebuildHuffmanTree: Reconstructs the Huffman tree from the code table.
writeCodeTable: Saves Huffman codes to a file.
readCodeTable: Loads code mappings from a file.





Installation

Clone the repository:git clone https://github.com/your-username/huffman-coding.git


Navigate to the project directory:cd huffman-coding


Ensure you have a Java Development Kit (JDK) installed (e.g., JDK 8 or later).
Compile the Java program:javac HuffmanCoding.java



Usage

Run the program:java HuffmanCoding


Follow the console-based menu:Choose an option:
1. Encode
2. Decode
3. Exit


For encoding:
Select option 1.
Ensure input.txt exists in the project directory with the text to encode.
The program generates:
encoded.bin: Compressed binary output.
code_table.txt: Huffman code mappings.
calculations.txt: Entropy and frequency data.




For decoding:
Select option 2.
Ensure encoded.bin and code_table.txt exist in the project directory.
The decoded text will be saved to output.txt.


To exit, select option 3.

File Management

input.txt: Contains the original text to be encoded.
encoded.bin: Stores the compressed binary output.
code_table.txt: Stores the Huffman code mappings for decoding.
output.txt: Stores the decoded text.
calculations.txt: Contains entropy calculations and character frequency data.

Test Cases

Example Test Case:
Input (input.txt): "hello world this is huffman coding example!"
Output:
Decoded text in output.txt: "hello world this is huffman coding example!"
Decoded text length: 43 characters
Files generated: encoded.bin, code_table.txt, calculations.txt




Note: The provided document lacks detailed test case steps. For additional test cases, provide specific input files and expected outputs to verify the program's behavior.

Notes

Ensure input.txt is in the correct format and accessible before encoding.
The program assumes valid Huffman codes and binary data for decoding.
For large files, ensure sufficient memory for the priority queue and tree operations.
The calculations.txt file provides insights into compression efficiency via entropy and frequency data.

License
This project is licensed under the MIT License - see the LICENSE file for details.
Author

Fares Wael (Student ID: 202201260)
