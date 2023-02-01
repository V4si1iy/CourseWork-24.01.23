package Commands;
import data.*;
import exceptions.CollectionEmptyException;
import exceptions.WorkerNotFoundException;
import exceptions.WrongAmountOfElementsException;
import utillity.CollectionManager;
import utillity.Console;
import utillity.WorkerAsker;

/**
 * Command 'update'. Updates the information about selected worker.
 */
public class UpdateCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;

    public UpdateCommand(CollectionManager collectionManager, WorkerAsker workerAsker) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
        this.collectionManager = collectionManager;
        this.workerAsker = workerAsker;
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

            Long id = Long.parseLong(argument);
            Worker oldWorker = collectionManager.getById(id);
            if (oldWorker == null) throw new WorkerNotFoundException();
            String name = oldWorker.getName();
            String surname = oldWorker.getSurname();
            String patronymic = oldWorker.getPatronymic();
            Long salary = oldWorker.getSalary();
            Status status = oldWorker.getStatus();
            departments department = oldWorker.getDepartment();


            collectionManager.removeFromCollection(oldWorker);

            if (workerAsker.askQuestion("Хотите изменить имя работника?")) name = workerAsker.askName();
            if (workerAsker.askQuestion("Хотите изменить Фамилию работника?")) surname = workerAsker.askSurname();
            if (workerAsker.askQuestion("Хотите изменить Отчество работника?")) patronymic = workerAsker.askPatronymic();
            if (workerAsker.askQuestion("Хотите изменить здоровье работника?")) salary = workerAsker.askSalary();
            if (workerAsker.askQuestion("Хотите изменить статус работника?")) status = workerAsker.askStatus();
            if (workerAsker.askQuestion("Хотите изменить отдел работника?")) department = workerAsker.askDepartment();


            collectionManager.addToCollection(new Worker(
                    id,
                    name,
                    surname,
                    patronymic,
                    salary,
                    status,
                    department

            ));
            Console.println("Работник успешно изменен!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (WorkerNotFoundException exception) {
            Console.printerror("Рабочего с таким ID в коллекции нет!");
        }
        return false;
    }
}
