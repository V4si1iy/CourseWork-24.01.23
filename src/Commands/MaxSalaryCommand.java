package Commands;

import data.Worker;
import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'max_salary'. Prints the max of salary of all workers.
 */
public class MaxSalaryCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public MaxSalaryCommand(CollectionManager collectionManager) {
        super("max_salary", "вывести максимальное значение поля salary для всех элементов коллекции");
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
            Worker maxSalary = collectionManager.maxSalary();
            if (collectionManager.getCollection().isEmpty()) throw new CollectionEmptyException();
            Console.println("Рабочий с максимальной зарпалтой: " + maxSalary);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}