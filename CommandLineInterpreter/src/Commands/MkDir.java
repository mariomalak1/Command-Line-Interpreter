package Commands;

import java.io.File;

public class MkDir implements ICommand{
    String [] str ;
    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length >= 1;
    }

    @Override
    public void runCommand() {
<<<<<<< HEAD
        File [] directory = new File[str.length];
        if(str.length>1){

            for(int i =0;i<str.length;i++){
                 directory[i] = new File(str[i]).getAbsoluteFile();
=======
        MakeDirInCurrentPath(str);
    }

    public static void MakeDirInCurrentPath(String path){
        File directory = new File(path);
        try {
            if (directory.mkdir()) {
                System.out.println();
            } else {
                System.err.println("Directory cannot be created");
>>>>>>> 19d17e217fa149d69b7a88d2c581d158b4e72464
            }
        }
        else{
             directory[0] = new File(str[0]).getAbsoluteFile();
        }
        for(int i=0; i<str.length;i++){
            try {
                if (directory[i].mkdir()) {
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

    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        str =new String[args.length];
        if (isValidArgs(args)){
            if(args.length >= 1){
                for(int i =0;i<args.length;i++){
                    str[i] = args[i];
                }

            }


        }
        else{
            throw new CommandsException("InValid Args");
        }
    }
}
