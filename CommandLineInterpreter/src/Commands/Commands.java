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
        rmdir("rmdir"),
        touch("touch"),
        rm("rm"),
        history("history"),
        cp("cp"),
        cp_r("cp-r"),
        wc("wc"),
        mkdir("mkdir"),
        ls("ls"),
        ls_r("ls-r");


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
            System.out.println(e.getMessage());
        }
    }
}
