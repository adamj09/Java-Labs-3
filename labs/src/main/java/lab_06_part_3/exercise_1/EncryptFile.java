package lab_06_part_3.exercise_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncryptFile {
    public static void main(String[] args) {
        // Make sure the right number of arguments is provided.
        if (args.length != 2) {
            System.err.println(
                    "Valid Usage:\n Argument 1: Filepath of encryption source.\n Argument 2: Filepath of encryption destination.");
            System.exit(1);
        }

        String srcPath = args[0],
                dstPath = args[1];

        File srcFile = new File(srcPath);

        // Make sure source file can be found.
        if (!srcFile.exists()) {
            System.err.println("Source file " + srcPath + " could not be found!");
            System.exit(1);
        }

        File dstFile = new File(dstPath);

        // Make sure the destination file does not already exist (to prevent overwriting
        // existing file).
        if (dstFile.exists()) {
            System.err.println("Destination file " + dstPath + " already exists!");
            System.exit(1);
        }

        // Make sure the destination file is in an existing directory.
        if (!dstFile.getParentFile().exists()) {
            System.err.println("Destination directory " + dstFile.getParent() + " could not be found!");
            System.exit(1);
        }

        encryptFile(srcFile, dstFile);
    }

    /**
     * Encrypts a file by adding 10 to each byte.
     * 
     * @param srcFile File whose data will be encrypted.
     * @param dstFile File to which encrypted data will be saved.
     */
    public static void encryptFile(File srcFile, File dstFile) {
        byte[] bytes = new byte[(int) srcFile.length()];

        // Read, encrypt, and write file.
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(srcFile));
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(dstFile))) {

            inputStream.readFully(bytes);

            // Encrypt file (add 10 to each byte).
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] += 10;
            }

            // Write encrypted file to destination.
            outputStream.write(bytes);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            return;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return;
        }
    }
}
