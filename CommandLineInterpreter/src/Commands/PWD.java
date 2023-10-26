package Commands;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PWD implements ICommand{

    @Override
    public Boolean isValidArgs(String[] args) {
        return ( ! (args.length > 0));
    }

    @Override
    public void runCommand() {
        Path currRelativePath = Paths.get("");
        String currAbsolutePathString = currRelativePath.toAbsolutePath().toString();
        System.out.println(currAbsolutePathString);
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if(! isValidArgs(args)){
            throw new Exception("InValid Args");
        }
    }
}
