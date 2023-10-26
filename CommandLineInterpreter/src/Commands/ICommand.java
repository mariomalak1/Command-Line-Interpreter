package Commands;

public interface ICommand {
    Boolean isValidArgs(String[] args);
    void runCommand();
    void PutArgs(String[] args) throws Exception;
}
