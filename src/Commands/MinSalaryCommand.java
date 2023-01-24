package Commands;

import data.Worker;
import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'min_salary'. Prints the min of salary of all workers.
 */
public class MinSalaryCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public MinSalaryCommand(CollectionManager collectionManager) {
        super("min_salary", "вывести минимальное значение поля salary для всех элементов коллекции");
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
            Worker minSalary = collectionManager.minSalary();
            if (collectionManager.getCollection().isEmpty()) throw new CollectionEmptyException();
            Console.println("Рабочий с минимальной зарпалтой: " + minSalary);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}