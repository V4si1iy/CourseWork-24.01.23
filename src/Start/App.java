package Start;

import java.util.Scanner;

import Commands.*;
import utillity.*;


/**
 * Main application class. Creates all instances and runs the program.
 */
public class App {
    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";

    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {

            WorkerAsker workerAsker = new WorkerAsker(userScanner);
            CollectionManager collectionManager = new CollectionManager();
            CommandManager commandManager = new CommandManager(collectionManager, workerAsker);
            Console console = new Console(commandManager, userScanner, workerAsker);

            console.interactiveMode();
        }
    }
}
