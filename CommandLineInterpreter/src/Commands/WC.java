package Commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WC implements ICommand{
    String str;
    @Override
    public Boolean isValidArgs(String[] args) {

        return args.length == 1;
    }

    @Override
    public void runCommand() {
        try (BufferedReader reader = new BufferedReader(new FileReader(str))) {
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
            System.out.println("File Name: " + str);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }


    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)){
            str = args[0];
        }
        else{
            throw new CommandsException("InValid Args");
        }
    }
}
