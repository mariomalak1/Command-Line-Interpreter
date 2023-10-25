package Terminal;

import Commands.Echo;
import Commands.ICommand;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    enum commands{
        exit("exit"),
        cd("cd"),
        echo("echo"),
        pwd("pwd");

        private final String commandName;

        commands(String commandName){
            this.commandName = commandName;
        }

        public String getCommandName() {
            return commandName;
        }

        public static List<commands> getAllCommands(){
            return Arrays.asList(Terminal.commands.values());
        }
    }

    Parser parser;

    //This method will choose the suitable command method to be called
    public void chooseCommandAction(){
        ICommand command;
        if (this.parser.getCommandName().equals(commands.exit)){
            System.exit(0);
        }

        else if (this.parser.getCommandName().equals(commands.echo)) {
            command = new Echo();
            runCommandAction(command);
        }
    }

    void runCommandAction(ICommand command) {
        if (command.isValidArgs(parser.getArgs())){
            try {
                command.PutArgs(parser.getArgs());
            }
            catch (Exception e){
                e.printStackTrace();
            }
            command.runCommand();
        }
    }

    public static void main(String[] args){
        while (true){
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            Terminal terminal = new Terminal();
            terminal.parser = new Parser();
            if (terminal.parser.parse(input)){
                terminal.chooseCommandAction();
            }else{
                System.out.println("\u001B[31m" + "There's no command named \"" + input + "\"");
            }
        }
    }
}
