package Commands;


public class PWD implements ICommand{

    @Override
    public Boolean isValidArgs(String[] args) {
        return true;
    }

    @Override
    public void runCommand() {
        System.out.println("pwd");
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        return;
    }
}
