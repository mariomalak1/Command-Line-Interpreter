package Terminal;

import java.util.Scanner;
import Commands.*;


public class Terminal {
    Parser parser;

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

        else{
            System.out.println("\u001B[31m" + "There's no command named \"" + this.parser.getCommandName() + "\"");
        }

    }

    public static void main(String[] args){
        Terminal terminal = new Terminal();
        while (true){
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            terminal.parser = new Parser();

            if (terminal.parser.parse(input)){
                terminal.chooseCommandAction();
            }else{
                System.out.println("\u001B[31m" + "There's no command named \"" + input + "\"");
            }
        }
    }
}
