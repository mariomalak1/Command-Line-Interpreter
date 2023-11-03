package Commands;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class PWD implements ICommand{

    @Override
    public Boolean isValidArgs(String[] args) {
        return ( ! (args.length > 0));
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if(! isValidArgs(args)){
            throw new CommandsException("pwd Command doesn't take any argument");
        }
    }

    public static Path CurrentAbsolutePath(){
        Path currRelativePath = Paths.get(System.getProperty("user.dir"));
        return currRelativePath.toAbsolutePath();
    }

    @Override
    public void runCommand() {
        System.out.println(CurrentAbsolutePath());
    }
}
