package Commands;

import java.io.IOException;
import java.nio.file.*;

public final class RM_Dir implements ICommand{
    String PathDir_or_asterisk;

    @Override
    public Boolean isValidArgs(String[] args) {
        if(args.length == 1){
            if (args[0].equals("*")) {
                return true;
            }
            else {
                return PathDirChecker(args[0]) != null;
            }
        }
        return false;
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if(isValidArgs(args)){
            if (args[0].equals("*") || isEmptyDir(args[0])){
                if (PathDirChecker(PathDir_or_asterisk).toAbsolutePath().equals(PWD.CurrentAbsolutePath())){
                    throw new Exception("The process cannot access the file because it is being used by another process.");
                }
                PathDir_or_asterisk = args[0];
            }
            else{
                throw new Exception("The directory is not empty.");
            }
        }else {
            throw new Exception("The system cannot find the file specified.");
        }
    }

    private boolean isEmptyDir(String str){
        try{
            Path path = Paths.get(str);

            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            return !directoryStream.iterator().hasNext();
        }
        catch (Exception e){
            return false;
        }
    }

    private Path PathDirChecker(String str){
        Path path = Paths.get(str);

        if (Files.exists(path)){
            if (Files.isDirectory(path)){
                return path;
            }
        }
        return null;
    }

    private void deleteDir(Path dir){
        try {
            if (isEmptyDir(dir.toAbsolutePath().toString())) {
                Files.delete(dir);
            }
            System.out.println("Directory and its contents have been deleted.");
        } catch (IOException e) {
            System.err.println("Failed to delete the directory: " + e.getMessage());
        }
    }

    public void deleteEmptyDir_s() throws IOException {
        if (PathDir_or_asterisk.equals("*")){
            Path currentPath = PWD.CurrentAbsolutePath();

            DirectoryStream<Path> directories = Files.newDirectoryStream(currentPath, Files::isDirectory);

            for (Path directory : directories) {
                // this function check that the dir is empty
                deleteDir(directory);
            }

        }

        else{
            deleteDir( PathDirChecker(PathDir_or_asterisk) );
        }
    }

    @Override
    public void runCommand() {
    }
}