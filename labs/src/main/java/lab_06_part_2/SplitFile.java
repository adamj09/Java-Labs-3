package lab_06_part_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Adam Johnston 2332003
 * 
 *         Commandline program used to split a file into multiple smaller files.
 */
public class SplitFile {
    public static void main(String[] args) {
        // Check if required number of args was provided.
        if (args.length < 3) {
            printValidUsageInfo();
            System.exit(1);
        }

        // Parse args and check for validity.
        String srcPath = args[0];

        Integer numPieces = 0;
        try {
            numPieces = Integer.parseInt(args[1]);
            if (numPieces < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            printValidUsageInfo();
            System.exit(3);
        }

        boolean keepFileExtension = false;
        if (args[2].equalsIgnoreCase("Y")) {
            keepFileExtension = true;
        } else if (!args[2].equalsIgnoreCase("N")) {
            printValidUsageInfo();
            System.exit(4);
        }

        // Split file.
        splitFile(srcPath, numPieces, keepFileExtension);
    }

    /**
     * Splits a file into multiple smaller files using binary I/O.
     * 
     * @param filepath          absolute path to the source file.
     * @param numberOfPieces    number of smaller files to split the source file
     *                          into.
     * @param keepFileExtension determines whether to keep the source file's
     *                          extension when saving the smaller files. If set to
     *                          false, the newly created smaller files will have no
     *                          extension.
     */
    public static void splitFile(String filepath, int numberOfPieces, boolean keepFileExtension) {
        File srcFile = new File(filepath);

        String extension = "";
        if (keepFileExtension) {
            // Get extension to append to split files.
            int index = filepath.lastIndexOf('.');
            if (index > 0) {
                extension = "." + filepath.substring(index + 1);
            }
        }

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(srcFile))) {
            // Number of bytes each smaller file should contain.
            int bytesPerFile = (int) ((srcFile.length() % numberOfPieces == 0 ? srcFile.length()
                    : ((srcFile.length() / numberOfPieces) + numberOfPieces)));

            // Create a new directory to store the split files.
            File dstDir = new File(srcFile.getParent() + "/dst");
            if (!dstDir.exists()) {
                dstDir.mkdir();
            }

            // For each smaller file, read the number of bytes (specified by bytesPerFile)
            // from the larger file, then write those bytes to the smaller file.
            for (int i = 0; i < numberOfPieces; i++) {
                byte[] bytes = new byte[bytesPerFile];
                int bytesRead = inputStream.read(bytes, 0, bytesPerFile);
                inputStream.mark(0);

                File dstFile = new File(dstDir.getPath() + "/dst" + i + extension);

                // If the destination file already exists, abort.
                if (dstFile.exists()) {
                    System.err.println("Destination file " + dstFile.getAbsolutePath() + " already exists!");
                    return;
                }

                dstFile.createNewFile();

                try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(dstFile))) {
                    outputStream.write(bytes);
                    System.out.println("\t" + bytesRead + " bytes written to " + dstFile.getAbsolutePath());
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Cannot find source file: " + filepath);
            System.exit(2);
        } catch (IOException ex) {
            System.err.println("IOException occurred.");
            System.exit(3);
        }
    }

    /**
     * Prints the list of commandline arguments required to use this program.
     */
    private static void printValidUsageInfo() {
        System.err.println(
                "Valid usage:\nArgument 1: path to source file.\nArgument 2: number of pieces to split file into (a positive integer value).\nArgument 3: keep file extension? (Y/N)");
    }
}
