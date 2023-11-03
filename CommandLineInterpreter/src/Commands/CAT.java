package Commands;

import java.io.*;

public  class CAT implements ICommand {
    String [] files;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 1 || args.length == 2;
    }

    @Override
    public void runCommand() {
        if (files.length == 2){
            try {
                System.out.println(TwoFiles(files[0], files[1]));
            } catch (CommandsException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            try {
                System.out.println(OneFile(files[0]));
            } catch (CommandsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String OneFile(String filename) throws CommandsException{
        try{
            int fread;
            FileInputStream file= new FileInputStream(filename);
            String fileContent = "";

            while((fread= file.read()) != -1) {
                fileContent += ((char)fread);
            }
            return fileContent;
        }
        catch(Exception e){
            throw new CommandsException("Error while printing the file.");
        }
    }

    public static String TwoFiles(String filename1, String filename2) throws CommandsException{
        try{
            int fread;
            FileInputStream file1= new FileInputStream(filename1);
            FileInputStream file2= new FileInputStream(filename2);

            String fileContent = "";

            while((fread = file1.read())!=-1) {
                fileContent += (char)fread;
            }
            while((fread= file2.read())!=-1) {
                fileContent += (char)fread;
            }
            return fileContent;
        }
        catch(Exception e){
            throw new CommandsException("Error while printing the file.");
        }
    }

    private static Boolean isValidFile(String fileName){
        File file = new File(fileName);
        return (file.exists()) && (file.isFile());
    }

    @Override
    public void PutArgs(String[] args) throws CommandsException {
        if (isValidArgs(args)){
            for (String file : args){
                if(!isValidFile(file)){
                    throw new CommandsException("It's not valid file.");
                }
                files = args;
            }
        }else{
            throw new CommandsException("Invalid Args");
        }
    }
}
