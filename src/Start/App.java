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
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new ShowCommand(collectionManager),
                    new AddCommand(collectionManager, workerAsker),
                    new UpdateCommand(collectionManager, workerAsker),
                    new RemoveByIdCommand(collectionManager),
                    new ExitCommand(),
                    new SumOfSalaryCommand(collectionManager),
                    new ClearCommand(collectionManager),
                    new SortCommand(collectionManager),
                    new MaxSalaryCommand(collectionManager),
                    new MinSalaryCommand(collectionManager),
                    new AverageSalaryCommand(collectionManager),
                    new InitialsCommand(collectionManager),
                    new IndexingCommand(collectionManager)
            );


            Console console = new Console(commandManager, userScanner, workerAsker);

            console.interactiveMode();
        }
    }
}
