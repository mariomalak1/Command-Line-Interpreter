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
<<<<<<< HEAD
        touch("touch"),
        rm("rm"),
        history("history");
=======
        history("history"),
        cp("cp"),
        wc("wc"),
        mkdir("mkdir");
>>>>>>> eb53aa4099f9d994a61ad5cdda65aeaddb1b0db7

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
