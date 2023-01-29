package Commands;
import data.*;

import exceptions.CollectionEmptyException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;

/**
 * Command 'indexing'. Indexing salary of all workers.
 */
public class IndexingCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public IndexingCommand(CollectionManager collectionManager) {
        super("indexing <Percent>", "обновить значения salary всех работников на введенный процент");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     *
     * @return Command exit status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionEmptyException();

            Long percent = Long.parseLong(argument);
            Worker workerInfo;
            for (Long i = 0L; collectionManager.collectionSize() > i; i++) {
                workerInfo = collectionManager.getById(i);
                workerInfo.setSalary(workerInfo.getSalary() + workerInfo.getSalary()*percent / 100);
            }

            Console.println("Работник успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("Процент должен быть представлен числом!");
        }
        return false;
    }
}
