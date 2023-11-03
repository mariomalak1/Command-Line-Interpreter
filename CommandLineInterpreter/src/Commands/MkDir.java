package Commands;

import java.io.File;

public class MkDir implements ICommand{
    String str;
    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public void runCommand() {
        MakeDirInCurrentPath(str);
    }

    public static void MakeDirInCurrentPath(String path){
        File directory = new File(path);
        try {
            if (directory.mkdir()) {
                System.out.println();
            } else {
                System.err.println("Directory cannot be created");
            }
        } catch (SecurityException e) {
            System.out.println("Encountered a security exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Encountered an exception: " + e.getMessage());
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
