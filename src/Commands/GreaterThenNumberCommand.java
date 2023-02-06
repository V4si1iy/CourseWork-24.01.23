package Commands;

import data.Worker;
import exceptions.CollectionEmptyException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'greater_then_number'. Prints salary of all workers that great number.
 */
public class GreaterThenNumberCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public GreaterThenNumberCommand(CollectionManager collectionManager) {
        super("greater_then_number <salary>", "вывести всех рабочих значения, зарплат которых больше значения");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();
            Long salary = Long.parseLong(argument);
            String info = collectionManager.greaterSalary(salary);
            if(info == "") throw new WorkerNotFoundException();
            Console.println(info);
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        }catch (NumberFormatException exception) {
            Console.printerror("Salary должен быть представлен числом!");
        }catch (WorkerNotFoundException exception) {
                Console.printerror("Не найдены такие работники!");
        }catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}
