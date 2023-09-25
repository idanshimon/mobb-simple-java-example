package com.mycompany.app;
import java.io.*;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        System.out.println(MESSAGE);

        // Vulnerable code starts here
        if (args.length > 0) {
            try {
                // Execute the command provided as an argument
                Process process = Runtime.getRuntime().exec(args[0]);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Vulnerable code ends here
    }

    public String getMessage() {
        return MESSAGE;
    }
}
