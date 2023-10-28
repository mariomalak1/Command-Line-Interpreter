package Terminal;

import java.util.Scanner;
import Commands.*;


public class Terminal {
    Parser parser;
    static History history;

    //This method will choose the suitable command method to be called
    public void chooseCommandAction(){
        ICommand command;

        if (this.parser.getCommandName().equals(Commands.commandsEnum.exit.getCommandName())){
            System.exit(0);
        }

        else if (this.parser.getCommandName().equals(Commands.commandsEnum.echo.getCommandName())) {
            command = new Echo();
            Commands.runCommandAction(command, this.parser);
        }

        else if (this.parser.getCommandName().equals(Commands.commandsEnum.pwd.getCommandName())) {
            command = new PWD();
            Commands.runCommandAction(command, this.parser);
        }

        else if (this.parser.getCommandName().equals(Commands.commandsEnum.rmdir.getCommandName())) {
            command = new RM_Dir();
            Commands.runCommandAction(command, this.parser);
        }
        else if (this.parser.getCommandName().equals(Commands.commandsEnum.history.getCommandName())) {
            Commands.runCommandAction(history, this.parser);
        }
        else if (this.parser.getCommandName().equals(Commands.commandsEnum.touch.getCommandName())) {
            command = new Touch();
            Commands.runCommandAction(command, this.parser);
        }
        else if (this.parser.getCommandName().equals(Commands.commandsEnum.cd.getCommandName())) {
            command = new Cd();
            Commands.runCommandAction(command, this.parser);
       }
        else if (this.parser.getCommandName().equals(Commands.commandsEnum.rm.getCommandName())) {
            command = new Rm();
            Commands.runCommandAction(command, this.parser);
        }

        else{
            System.out.println("\u001B[31m" + "There's no command named \"" + this.parser.getCommandName() + "\"");
        }

    }

    public static void main(String[] args){
        Terminal terminal = new Terminal();
        history = new History();
        while (true){
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            terminal.parser = new Parser();

            if (terminal.parser.parse(input)){
                history.addCommand(input);
                terminal.chooseCommandAction();
            }else{
                System.out.println("\u001B[31m" + "There's no command named \"" + input + "\"");
            }
        }
    }
}
