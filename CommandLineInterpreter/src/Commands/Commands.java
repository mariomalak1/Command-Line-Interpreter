package Commands;

import Terminal.Parser;

import java.util.Arrays;
import java.util.List;

public class Commands {
    public static enum commandsEnum{
        exit("exit"),
        cd("cd"),
        echo("echo"),
        pwd("pwd"),
        rmdir("rmdir");

        private final String commandName;

        commandsEnum(String commandName){
            this.commandName = commandName;
        }

        public String getCommandName() {
            return commandName;
        }

        public static List<commandsEnum> getAllCommands(){
            return Arrays.asList(commandsEnum.values());
        }
    }

    public static void runCommandAction(ICommand command, Parser parser) {
        try {
            command.PutArgs(parser.getArgs());
            command.runCommand();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
