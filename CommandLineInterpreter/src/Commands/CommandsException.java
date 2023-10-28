package Commands;

public class CommandsException extends Exception {
    private final String ErrorName;

    public CommandsException(String errorName) {
        this.ErrorName = errorName;
    }

    @Override
    public String getMessage() {
        return "\u001B[31m" + ErrorName + "\u001B[0m";
    }

    @Override
    public void printStackTrace() {
        System.out.println("\u001B[31m" + ErrorName + "\u001B[0m");
    }
}
