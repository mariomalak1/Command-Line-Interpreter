package Commands;

public interface ICommand {
    Boolean isValidArgs(String[] args);
    void runCommand() throws CommandsException;

    void PutArgs(String[] args) throws Exception;
}
