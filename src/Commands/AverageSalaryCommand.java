package Commands;

import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'average_salary'. Prints the average of salary of all workers.
 */
public class AverageSalaryCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public AverageSalaryCommand(CollectionManager collectionManager) {
        super("average_salary", "вывести среднее значение поля salary для всех элементов коллекции");
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
            double average_salary = collectionManager.getAverageSalary();
            if (average_salary == 0) throw new CollectionEmptyException();
            Console.print("Среднее зарплат всех рабочих: ");
            Console.printdouble(average_salary);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}