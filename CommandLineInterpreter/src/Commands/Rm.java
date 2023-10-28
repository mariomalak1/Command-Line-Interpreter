package Commands;

import java.io.File;

public class Rm implements ICommand{

    String str;
    @Override
    public Boolean isValidArgs(String[] args){
        return args.length == 1;
    }



    @Override
    public void runCommand()  {
        File deleted = new File(str);
        if (deleted.exists()) {
            deleted.delete();
        }
    }

    @Override
    public void PutArgs(String[] args) throws Exception{
        if (isValidArgs(args)){
            str = args[0];
        }
        else{
            throw new Exception("InValid Args");
        }

    }


}
