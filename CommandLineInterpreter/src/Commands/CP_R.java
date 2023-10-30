package Commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public final class CP_R implements ICommand{
    Path Source;
    Path Destination;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 2;
    }

    @Override
    public void runCommand(){
        try {
            copyAllFilesInDirInAnother(this.Source, this.Destination);
        }catch (CommandsException e){
            System.err.println("Error While copy files");
        }
    }

    public static void copyAllFilesInDirInAnother(Path source, Path destination) throws CommandsException {
        if (!isDir(source.toString())) {
            throw new CommandsException("It's not Directory");
        }
        if (!isDir(destination.toString())) {
            throw new CommandsException("It's not Directory");
        }

        File[] filesListSource = source.toFile().listFiles();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(source);
            copyFiles(directoryStream, destination);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error While Copy Directory");
        }
    }

    public static void copyFiles(DirectoryStream<Path> filesListSource, Path destination) throws IOException {
        for (Path file: filesListSource) {
            Files.copy(file, destination);
        }
    }

    public static boolean isDir(String str){
        Path path = Paths.get(str);
        return path.toFile().isDirectory();
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (! isValidArgs(args)){
            throw new CommandsException("Invalid Parameters");
        }

        for (String arg : args) {
            if (!isDir(arg)) {
                throw new CommandsException("It's not Directory");
            }
        }

        Source = Paths.get(args[0]);
        Destination = Paths.get(args[1]);
    }
}
