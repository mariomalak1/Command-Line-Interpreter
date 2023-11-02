package Commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public final class CP_R implements ICommand{
    Path Source;
    Path Destination;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 3;
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
            try {
                Files.createDirectories(destination);
            } catch (IOException e) {
                System.err.println("Error: While creating Dir : " + destination.getFileName().toString());
            }
        }
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
            Files.copy(file, destination.resolve(file.getFileName().toString()));
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

        for (int i = 1; i < args.length; i++) {
            if (!isDir(args[i])) {
                if (i == 2){
                    try {
                        Files.createDirectories(Paths.get(args[i]));
                    } catch (IOException e) {
                        System.err.println("Error: While creating Dir : " + Paths.get(args[i]).getFileName().toString());
                    }
                }
            }
        }

        Source = Paths.get(args[1]);
        Destination = Paths.get(args[2]);
    }
}
