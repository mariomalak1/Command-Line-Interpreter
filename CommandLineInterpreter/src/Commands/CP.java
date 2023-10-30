package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CP implements ICommand{
    private String Source;
    private String Destination;

    @Override
    public Boolean isValidArgs(String[] args) {
        return (args.length == 2);
    }

    @Override
    public void PutArgs(String[] args) throws CommandsException {
        try{
            if (isValidArgs(args)){
                Source = "";
                Destination = "";
                if ( PathFileChecker(args[0]) != null){
                    Source = args[0];
                    if (IfDirPutFileName(args[1]) != null){
                        Destination = IfDirPutFileName(args[1]).toString();
                        return;
                    }
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
    }

    public static void copy(String source, String destination){
        try {
            Files.copy(StringConvertToPath(source), StringConvertToPath(destination), StandardCopyOption.REPLACE_EXISTING);
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

    private static Path StringConvertToPath(String str){
        return Paths.get(str);
    }

    private Path IfDirPutFileName(String str){
        Path destinationPath = StringConvertToPath(str);
        if(Files.isDirectory(destinationPath)){
            Path sourcePath = StringConvertToPath(Source);
            String fileName = sourcePath.getFileName().toString();
            return destinationPath.resolve(fileName);
        }
        return null;
    }

    @Override
    public void runCommand() {
        copy(this.Source, this.Destination);
    }
}
