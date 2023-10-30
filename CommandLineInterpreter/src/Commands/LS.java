package Commands;
import java.io.*;
import java.io.File;
import java.util.Scanner;
public class LS implements ICommand{


    @Override
    public Boolean isValidArgs(String[] args) {
        return null;
    }

    @Override
    public void runCommand() {

        System.out.print("enter the path of the directory: ");
        Scanner in= new Scanner(System.in);
        String path = in.nextLine();
        File currentDir = new File(path);
        try {
            File[] files = currentDir.listFiles();

            for (File file : files) {

                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                }

                else {
                    System.out.println("	 file:" + file.getCanonicalPath());
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void PutArgs(String[] args) throws Exception {

    }
}
