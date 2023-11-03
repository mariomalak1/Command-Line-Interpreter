package Commands;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cd implements ICommand {
    String str;

    @Override
    public Boolean isValidArgs(String[] args){
        return args.length <= 1;
    }

    @Override
    public void PutArgs(String[] args) throws CommandsException{
        if (isValidArgs(args)){
            if (args.length == 0){
                str = "";
            }
            else{

                if (args[0].equalsIgnoreCase("..")) {
                    str = "..";
                    return;
                }

                Path path = isDirExits(args[0]);

                if (path == null) {
                    path = Paths.get(args[0]);
                    path = PWD.CurrentAbsolutePath().resolve(path);
                    throw new CommandsException("Cannot find path " + path +  "\nbecause it does not exist as a directory.");
                }

                else {
                    str = path.toString();
                }

            }
        }
        else{
            throw new CommandsException("InValid Args");
        }
    }

    public static Path ChangeDirectory(String str) throws CommandsException{
        if (str.equalsIgnoreCase("")){
            return PWD.CurrentAbsolutePath();
        }
        else if (str.equalsIgnoreCase("..")) {
            Path path = getPreviousPath();
            System.setProperty("user.dir", path.toString());
            System.getProperty("user.dir");
            return path;
        }
        else {
            // check that the entered path is valid path
            Path path = isDirExits(str);

            if (path == null) {
                path = Paths.get(str);
                path = PWD.CurrentAbsolutePath().resolve(path);
                throw new CommandsException("Cannot find path " + path +  "\nbecause it does not exist as a directory.");
            }
            // change dir to the specific dir
            System.setProperty("user.dir", path.toString());
            System.getProperty("user.dir");
            return path;
        }
    }


    private static Path isDirExits(String str){
        Path path = Paths.get(str);
        if (path.toFile().exists()){
            if (path.toFile().isDirectory()){
                path = path.toFile().toPath().toAbsolutePath();
                return path;
            }
        }
        else{
            Path newPath = PWD.CurrentAbsolutePath().resolve(path);
            if (newPath.toFile().exists()){
                if(newPath.toFile().isDirectory()){
                    return newPath.toAbsolutePath();
                }
            }
        }
        return null;
    }

    private static Path getPreviousPath(){
        return PWD.CurrentAbsolutePath().toFile().getParentFile().toPath().toAbsolutePath();
    }

    @Override
    public void runCommand() {
        try {
            System.out.println(ChangeDirectory(this.str));
        } catch (CommandsException e) {
            System.out.println(e.getMessage());
        }
    }
}

