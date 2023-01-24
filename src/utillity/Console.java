package utillity;

import java.util.NoSuchElementException;
import java.util.Scanner;

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
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                if (!commandManager.help(userCommand[1])) return 1;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 1;
                break;
            case "add":
                if (!commandManager.add(userCommand[1])) return 1;
                break;
            case "update":
                if (!commandManager.update(userCommand[1])) return 1;
                break;
            case "remove_by_id":
                if (!commandManager.removeById(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 1;
                break;
            case "sum_of_salary":
                if (!commandManager.sumOfSalary(userCommand[1])) return 1;
                break;
            case "min_salary":
                if (!commandManager.minSalary(userCommand[1])) return 1;
                break;
            case "max_salary":
                if (!commandManager.maxSalary(userCommand[1])) return 1;
                break;
            case "average_salary":
                if (!commandManager.averageSalary(userCommand[1])) return 1;
                break;
            case "initials":
                if (!commandManager.initials(userCommand[1])) return 1;
                break;
            case "sort":
                if (!commandManager.sort(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
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
     * @param toOut Error to print
     */
    public static void printdouble(Object toOut) {
        System.out.printf("%.2f\n", toOut);
    }

    @Override
    public String toString() {
        return "Console (класс для обработки ввода команд)";
    }
}