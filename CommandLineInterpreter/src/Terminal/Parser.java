package Terminal;

import Commands.Commands;

public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args
    //where "input" is the string command entered by the user
    public boolean parse(String input){
        String[] inputParts = input.split(" ");
        this.commandName = inputParts[0];

        // check on command name that is first of the all
        if (CommandNameParseCheck() == null){
            return false;
        }else{
            args = new String[inputParts.length - 1];
            putArgs(inputParts, args, inputParts.length);
            return true;
        }
    }

    private void putArgs(String [] input, String [] args, int end){
        for(int i = 1, j = 0; i < end; i++, j++){
            args[j] = input[i];
        }
    }

    private String CommandNameParseCheck(){
        for (Commands.commandsEnum command: Commands.commandsEnum.getAllCommands()) {
            if (commandName.equals(command.getCommandName())){
                return command.getCommandName();
            }
        }
        return null;
    }

    public String getCommandName(){return commandName;}

    public String[] getArgs(){return this.args;}

}