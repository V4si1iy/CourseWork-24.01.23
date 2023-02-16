package Commands;

import data.Worker;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;
import utillity.WorkerAsker;

/**
 * Command 'add'. Adds a new element to collection.
 */
public class AddCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public AddCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.workerAsker = workerAsker;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            collectionManager.addToCollection(new Worker(
                    collectionManager.generateNextId(),
                    workerAsker.askName(),
                    workerAsker.askSurname(),
                    workerAsker.askPatronymic(),
                    workerAsker.askSalary(),
                    workerAsker.askStatus(),
                    workerAsker.askDepartment()

            ));
            Console.println("Работник успешно добавлен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}