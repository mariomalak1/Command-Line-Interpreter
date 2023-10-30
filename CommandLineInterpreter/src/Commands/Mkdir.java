package Commands;

import java.io.File;

public class Mkdir implements ICommand {
//    public static void main(String[] args) {
//        mkdir mkdir = new mkdir();
//        mkdir.run();
//    }
    String str;
    @Override
public Boolean isValidArgs(String[] args){
    return args.length == 1;
}
    @Override
    public void runCommand() {
        // Get the user input
        // Parse the user input

                String directoryPath = str;
                // Create a File object using the directory path
                File directory = new File(directoryPath);
                try {
                    if (directory.mkdir()) {
                        System.out.println("Directory is created");
                    } else {
                        System.out.println("Directory cannot be created");
                    }
                } catch (SecurityException e) {
                    System.out.println("Encountered a security exception: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Encountered an exception: " + e.getMessage());
                }
            }

        @Override
    public void  PutArgs(String[] args) throws Exception {
            if (isValidArgs(args)){
                str = args[0];
            }
            else{
                throw new Exception("InValid Args");
            }
        // Code to get user input from console or any other source
        // and return it as a string
        // For example:

    }
}
//
//class Parser {
//    String commandName;
//    String[] args;
//
//    public boolean parse(String input) {
//        // Split the input into commandName and args based on whitespace
//        String[] parts = input.split("\\s+");
//        if (parts.length > 0) {
//            commandName = parts[0];
//            args = new String[parts.length - 1];
//            System.arraycopy(parts, 1, args, 0, parts.length - 1);
//            return true;
//        }
//        return false;
//    }
//
//    public String getCommandName() {
//        return commandName;
//    }
//
//    public String[] getArgs() {
//        return args;
//    }
