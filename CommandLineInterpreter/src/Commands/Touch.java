package Commands;

import java.io.File;
import java.io.IOException;

public  class Touch implements ICommand {
    String str;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public void runCommand() {
        try {
            File myFile = new File(str);
            myFile.createNewFile();
        } catch (IOException E) {
            System.err.println(E.getMessage());
        }
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)) {
            str = args[0];
        } else {
            throw new Exception("InValid Args");
        }
    }
}
