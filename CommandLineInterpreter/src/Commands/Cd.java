package Commands;

public class Cd implements ICommand {
    String str;

    @Override
    public Boolean isValidArgs(String[] args){
        return args.length <= 1;
    }

    @Override
    public void PutArgs(String[] args) throws CommandsException{
        if (isValidArgs(args)){
            if(args.length==0){
                str="";
            }
            else {
                str = args[0];
            }
        }
        else{
            throw new CommandsException("InValid Args");
        }

    }

    public static String ChangeDir(String str){
        if (str.length() == 0){
            System.setProperty("user.dir",System.getProperty("user.home"));
            return System.getProperty("user.dir");
        }
        else if (str.endsWith("..")) {
            String currentPath = System.getProperty("user.dir");
            for(int i = currentPath.length() - 1; i > 0; i--){
                if(currentPath.charAt(i) == '\\'){
                    currentPath = currentPath.substring(0,i);
                    System.setProperty("user.dir",currentPath);
                    return System.getProperty("user.dir");
                }
            }

        } else{
            System.setProperty("user.dir",str);
            return System.getProperty("user.dir");
        }
        return null;
    }

    @Override
    public void runCommand()  {
        ChangeDir(this.str);
    }
}

