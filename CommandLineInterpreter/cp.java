import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class cp {
    public static void main(String[] args) {
        cp copyFile = new cp();
        copyFile.run();
    }

    public void run() {
        // Get the user input
        Parser parser = new Parser();
        String userInput = getUserInput();

        // Parse the user input
        boolean parsedSuccessfully = parser.parse(userInput);

        if (parsedSuccessfully) {
            // Get the arguments from the parser
            String[] arguments = parser.getArgs();
            if (arguments.length != 2) {
                System.err.println("Usage: cp <source> <destination>");
                System.exit(1);
            }

            Path source = Paths.get(arguments[0]);
            Path destination = Paths.get(arguments[1]);

            try {
                Files.copy(source, destination);
                System.out.println("File copied successfully.");
            } catch (IOException e) {
                System.err.println("Failed to copy file: " + e.getMessage());
            }
        }
    }
}