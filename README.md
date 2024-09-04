# LzmaCoder

LzmaCoder is a Java application that provides functionality to encode and decode files using the LZMA compression algorithm. It leverages the `xz` library for compressing and decompressing files efficiently.

## Features

- Encode files to LZMA format (compression).
- Decode LZMA files back to original format (decompression).
- Simple command-line interface for easy usage.

## Prerequisites

- Java 8 or higher
- Gradle (for building the project)

## Usage

To use LzmaCoder, you need to run the JAR file from the command line. The syntax is as follows:

```bash
java -jar lzma.jar <encode/decode> <inputFile> <outputFile>
```

## Parameters
- `encode`: Specify this mode to compress a file.
- `decode`: Specify this mode to decompress a file.
- `<inputFile>`: The path to the input file (to be compressed or decompressed).
- `<outputFile>`: The path where the output file will be saved.

## Examples
To encode a file:
```bash
java -jar lzma.jar encode input.txt output.lzma
```
To decode a file:
```bash
java -jar lzma.jar decode output.lzma decoded.txt
```

## Error Handling
If the parameters are not provided correctly, the application will display a usage message and exit. Ensure that you provide encode or decode, along with the input and output file paths.

## Building the Project
To build the project, ensure you have Gradle installed and run:
```bash
./gradlew shadowJar
```
This will generate a fat JAR file named lzma.jar in the build/libs directory.

## Licensing
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.

## Acknowledgments
This project uses Tukaani's XZ library for compression and decompression. For more information on the licensing of the XZ library, please visit [Tukaani XZ Licensing](https://tukaani.org/xz/#_licensing).