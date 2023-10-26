package Commands;

public class Echo implements ICommand {
    public String str;

    @Override
    public Boolean isValidArgs(String[] args) {
        return args.length >= 1;
    }

    @Override
    public void runCommand() {
         System.out.println("\u001B[0m" + this.str);
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        str = "";
        if (isValidArgs(args)){
            for (int i = 0; i < args.length - 1; i++) {
                str += args[i] + " ";
            }
            str += args[args.length - 1];
        }
        else{
            throw new Exception("InValid Args");
        }
    }
}
