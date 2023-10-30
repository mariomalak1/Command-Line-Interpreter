package Commands;
import Commands.ICommand;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


import java.io.File;

public class Wc implements ICommand {
    //    public static void main(String[] args) {
//        wp wordProcessor = new wp();
//        wordProcessor.run();
//    }
    String str;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 1;
    }

    public void runCommand()  {
        // Get the user input
        String userInput = str;

        // Parse the user input using the Parser


        // Get the arguments from the parser


        String filename = str;
        processFile(filename);
    }


    public void processFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                // Split the line into words and count them
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);
            System.out.println("File Name: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }


    @Override
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)) {
            str = args[0];
        } else {
            throw new Exception("InValid Args");
        }
    }
}




