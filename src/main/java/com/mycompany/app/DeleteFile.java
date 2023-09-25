import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {
        // Create a scanner to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a file path
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        // Check if the path starts with "/safe_dir/"
        if (path.startsWith("/safe_dir/")) {
            // Create a File object
            File file = new File(path);

            // Check if the file exists and is a file (not a directory)
            if (file.exists() && file.isFile()) {
                // Delete the file
                if (file.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File does not exist or is a directory.");
            }
        } else {
            System.out.println("The path does not start with '/safe_dir/'.");
        }

        // Close the scanner
        scanner.close();
    }
}