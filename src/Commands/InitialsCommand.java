package Commands;

import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'initials'. Prints the initials of all workers.
 */
public class InitialsCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public InitialsCommand(CollectionManager collectionManager) {
        super("initials", "вывести инициалы рабочих всех элементов коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElementsException();
            String info = collectionManager.InitialsToString();
            if (collectionManager.getCollection().isEmpty()) throw new CollectionEmptyException();
            Console.println(info);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}