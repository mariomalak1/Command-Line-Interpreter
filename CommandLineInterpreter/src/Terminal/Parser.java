package Terminal;

import Commands.Commands;

public class Parser {
    String commandName;
    String[] args;

    //This method will divide the input into commandName and args
    //where "input" is the string command entered by the user
    public boolean parse(String input){
        String[] inputParts = input.split(" ",2);
        this.commandName = inputParts[0];
        if(inputParts.length>1) {


            if (inputParts[1].charAt(0) == '.' || inputParts[1].charAt(1) == ':') {

            } else {
                inputParts = input.split(" ");

            }
        }
        for(int i =0; i<inputParts.length;i++){
            System.out.println(inputParts[i]);
        }
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
