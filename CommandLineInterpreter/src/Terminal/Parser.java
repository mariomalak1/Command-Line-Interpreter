package Terminal;

import java.util.Arrays;

public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args
    //where "input" is the string command entered by the user
    public boolean parse(String input){
        String[] inputParts = input.split(" ");
        this.commandName = inputParts[0];

        for (Terminal.commands command: Terminal.commands.getAllCommands()) {
            if (commandName.equals(command.getCommandName())){
                args = new String[1];
                args[0] = "mario malak alabd";
                return true;
            }
        }
        return false;
    }

    public String getCommandName(){return commandName;}

    public String[] getArgs(){return new String[0];}

}
