import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.LZMAOutputStream;
import org.tukaani.xz.LZMA2Options;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LzmaCoder {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar lzma.jar <encode/decode> <inputFile> <outputFile>");
            System.exit(1);
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            if ("encode".equalsIgnoreCase(mode)) {
                encode(inputFile, outputFile);
                System.out.println("Encoding completed successfully.");
            } else if ("decode".equalsIgnoreCase(mode)) {
                decode(inputFile, outputFile);
                System.out.println("Decoding completed successfully.");
            } else {
                System.out.println("Invalid mode. Use 'encode' or 'decode'.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error during " + mode + ": " + e.getMessage());
            System.exit(2);
        }
    }

    private static void encode(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             LZMAOutputStream lzmaOutputStream = new LZMAOutputStream(fos, new LZMA2Options(), -1)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                lzmaOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void decode(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             LZMAInputStream lzmaInputStream = new LZMAInputStream(fis);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = lzmaInputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}