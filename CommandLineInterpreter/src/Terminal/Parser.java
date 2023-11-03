package Terminal;

import Commands.Commands;

import java.util.Locale;

public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args
    //where "input" is the string command entered by the user
    public boolean parse(String input){
        String[] inputParts = input.split(" ");
        this.commandName = inputParts[0].toLowerCase(Locale.ROOT);

        // check on command name that is first of the all
        if (CommandNameParseCheck() == null){
            return false;
        }else{
            if ((this.commandName.equals(Commands.commandsEnum.cp.getCommandName())) || (this.commandName.equals(Commands.commandsEnum.ls.getCommandName())) ){
                if (inputParts.length > 1){
                    if (inputParts[1].equalsIgnoreCase("-r")){
                        commandName += "-r";
                        args = new String[inputParts.length - 2];
                        putArgs(inputParts, args, inputParts.length, 2);
                        return true;
                    }
                }
            }
            args = new String[inputParts.length - 1];
            putArgs(inputParts, args, inputParts.length, 1);
            return true;
        }
    }

    private void putArgs(String [] input, String [] args, int end, int start){
        for(int i = start, j = 0; i < end; i++, j++){
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