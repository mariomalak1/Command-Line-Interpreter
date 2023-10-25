package Commands;

import com.sun.jdi.connect.Connector;

public class Echo implements ICommand {
    public String str;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public void runCommand() {
         System.out.println(this.str);
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        if (isValidArgs(args)){
            str = args[0];
        }
        else{
            throw new Exception("InValid Args");
        }
    }
}
