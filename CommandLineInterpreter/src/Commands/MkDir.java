package Commands;

import java.io.File;

public class MkDir implements ICommand{
    String [] DirNames;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length >= 1;
    }

    @Override
    public void runCommand() {
        MakeDirsInCurrentPath(this.DirNames);
    }

    public static void MakeDirsInCurrentPath(String [] dirNames){
        for (String filename : dirNames){
            MakeDirInCurrentPath(filename);
        }
    }

    public static void MakeDirInCurrentPath(String path){
        File directory = new File(path);
        try {
            if (! directory.mkdir()) {
                System.err.println("Directory cannot be created");
            }
        } catch (SecurityException e) {
            System.err.println("Encountered a security exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Encountered an exception: " + e.getMessage());
        }
    }

    private static boolean CanMakeDir(String dirName){
        File file = new File(dirName);
        return (! file.exists());
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)){
            DirNames = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                if (CanMakeDir(args[i])){
                    DirNames[i] = args[i];
                }
            }
            DirNames = args;
        }
        else{
            throw new CommandsException("InValid Args");
        }
    }
}
