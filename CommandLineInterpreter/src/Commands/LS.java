package Commands;
import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LS implements ICommand{


    @Override
    public Boolean isValidArgs(String[] args) {
        return (args.length == 0);
    }

    public static List<String> ListOfFiles(){
        List<String> list = new ArrayList<>();
        File currentDir = PWD.CurrentAbsolutePath().toFile();
        try {
            File[] files = currentDir.listFiles();

            for (File file : files) {

                if (file.isDirectory()) {
                    list.add("Directory:\t" + file.getCanonicalPath());
                }

                else {
                    list.add("File:\t" + file.getCanonicalPath());
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void runCommand() {
        List<String> listOfFiles = ListOfFiles();
        printListDirs(listOfFiles);
    }

    public static void printListDirs(List<String> listOfFiles){
        if (listOfFiles.isEmpty()){
            System.out.println("\u001B[0m");
        }else{
            for (String file: listOfFiles) {
                System.out.println("\u001B[0m" + file);
            }
        }
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (! isValidArgs(args)){
            throw new CommandsException("ls doesn't take arguments.");
        }
    }
}
