package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CP implements ICommand{
    private String Source = "";
    private String Destination = "";

    @Override
    public Boolean isValidArgs(String[] args) {
        return (args.length == 2);
    }

    @Override
    public void PutArgs(String[] args) throws CommandsException {
        try{
            if (isValidArgs(args)){
                if ( PathFileChecker(args[0]) != null && PathFileCheckerNotExist(args[1]) != null){
                    Source = args[0];
                    Destination = args[1];
                }else{
                    throw new CommandsException("Not valid path.");
                }
            }else{
                throw new CommandsException("Invalid number of arguments.");
            }
        }
        catch (CommandsException e){
            System.out.println(e.getMessage());
        }
        // if the first is path or relative file
        // if the second is the same
        // put the first in source and the second in destination
    }

    public void run(){
        try {
            Files.copy(PathFileChecker(Source), PathFileChecker(Destination));
            System.out.println();
        }
        catch (IOException e) {
            System.err.println("Failed to copy file: " + e.getMessage());
        }
    }

    private Path PathFileChecker(String str){
        Path path = Paths.get(str);

        if (Files.exists(path)){
            return path;
        }
        return null;
    }

    private Path PathFileCheckerNotExist(String str){
        return Paths.get(str);
    }

    @Override
    public void runCommand() {
        run();
    }
}
