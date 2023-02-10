package utillity;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Commands.Command;
import Start.App;

/**
 * Operates command input.
 */
public class Console {
    private CommandManager commandManager;
    private Scanner userScanner;
    private WorkerAsker workerAsker;

    public Console(CommandManager commandManager, Scanner userScanner, WorkerAsker workerAsker) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.workerAsker = workerAsker;
    }

    /**
     * Mode for catching commands from user input.
     */
    public void interactiveMode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
                Console.print(App.PS1);
                userCommand = (userScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandStatus = launchCommand(userCommand);
            } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            Console.printerror("Пользовательский ввод не обнаружен!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
        }
    }


    /**
     * Launchs the command.
     *
     * @param userCommand Command to launch.
     * @return Exit code.
     */
    private int launchCommand(String[] userCommand) {
        if(!commandManager.workingCommand(commandManager.getCollectionCommands().get(userCommand[0]) ,userCommand)){return 1;}
        if(userCommand[0].equals("exit")){return 2;}
        return 0;
    }

    /**
     * Prints toOut.toString() to Console
     *
     * @param toOut Object to print
     */
    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Prints toOut.toString() + \n to Console
     *
     * @param toOut Object to print
     */
    public static void println(Object toOut) {
        System.out.println(toOut);
    }

    /**
     * Prints error: toOut.toString() to Console
     *
     * @param toOut Error to print
     */
    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    /**
     * Prints formatted 2-element table to Console
     *
     * @param element1 Left element of the row.
     * @param element2 Right element of the row.
     */
    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    /**
     * Prints : toOut.toString() %.2f to Console
     *
     * @param toOut Double to print
     */
    public static void printdouble(Object toOut) {
        System.out.printf("%.2f\n", toOut);
    }

    @Override
    public String toString() {
        return "Console (класс для обработки ввода команд)";
    }
}