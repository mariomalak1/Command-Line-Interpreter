package Commands;

import java.util.Collections;
import java.util.List;

public class LS_R implements ICommand{
    @Override
    public Boolean isValidArgs(String[] args) {
        return (args.length == 0);
    }

    @Override
    public void runCommand() {
        String path = PWD.CurrentAbsolutePath().toString();
        List<String> listOfFiles = LS.ListOfFiles(path);
        // reverse order of listing
        Collections.reverse(listOfFiles);
        LS.printListDirs(listOfFiles);
    }


    @Override
    public void PutArgs(String[] args) throws Exception {

    }
}