package Commands;

import java.io.File;
import java.util.Scanner;

public class Rm implements ICommand{
    String str;

    @Override
    public Boolean isValidArgs(String[] args){
        return args.length == 1;
    }

    @Override
    public void runCommand()  {
        deleteFile(this.str);
    }

    @Override
    public void PutArgs(String[] args) throws Exception{
        if (isValidArgs(args)){
            str = args[0];
        }
        else{
            throw new CommandsException("InValid Args");
        }
    }

    public static boolean deleteFile(String str){
        File deleted = new File(str);
        if (deleted.exists()) {
            while (true){
                System.out.println(deleted + ", Are you sure (Y/N)");
                String response = new Scanner(System.in).nextLine();
                if (response.equalsIgnoreCase("y")){
                    return deleted.delete();
                }
                else if (response.equalsIgnoreCase("n")){
                    break;
                }
            }
        }
        return false;
    }

}
