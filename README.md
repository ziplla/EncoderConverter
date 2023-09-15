# EncoderConverter
This project is a simple Java 20 program for encoding and decoding files into various encodings, including "Windows-1251," "IBM866," "UTF-16," "UTF-32," "UTF-8," and "US-ASCII." In this README file, you will find instructions for installation, configuration, and usage of the program.

### Installation and Running
To get started with this project, follow these steps:
#### 1. Clone the repository
'git clone https://github.com/1zpa1/EncoderConverter.git'
#### 2. Navigate to the project directory
'cd EncoderConverter'
#### 3. Upload the required files
Copy the files you want to encode and decode into the root directory of the project. Ensure that you have the following files:

*example.txt* - a text file that will be used to demonstrate working with textual data.
*example.jpg* - an image that will be used to demonstrate working with binary data.
#### 4. Open the project in your development environment
Open the project in your Java development environment (e.g., IntelliJ IDEA or Eclipse).
#### 5. Configure files in the code
Open the *EncoderConverter.java* file in your development environment and specify the filenames you want to encode and decode in lines 8 and 52:
'''
String fileName = "example.txt"; // Specify the filename for encoding and decoding textual data
...
encodeToBase64("example.jpg"); // Specify the filename for encoding and decoding binary data
'''
#### 6. Run the program
Run the program from your development environment. It will encode and decode the selected files into the specified encodings.
#### Usage
The program works with files, encoding and decoding them into various encodings. You can configure the program to work with different types of files and encodings by modifying the parameters in the code.
#### Contributions
If you have suggestions for improving this project or have found a bug, please create an Issue on GitHub or propose your changes through a Pull Request.
#### License
This project is distributed under the MIT License. Details can be found in the LICENSE file.
