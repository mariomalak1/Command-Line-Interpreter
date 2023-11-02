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
<<<<<<< HEAD
        File directory = new File(System.getProperty("user.dir"));
=======
        File directory = new File(str);
>>>>>>> e942fc4cb408d94b53de06fb46d33b8ac8ea849f
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
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)){
            str = args[0];
        }
        else{
            throw new CommandsException("InValid Args");
        }

    }
}
