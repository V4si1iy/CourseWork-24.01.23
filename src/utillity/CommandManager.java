package utillity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Commands.*;


/**
 * Operates the commands.
 */
public class CommandManager {

    private CollectionManager collectionManager;
    private WorkerAsker workerAsker;
    private HashMap<String, Command> commands = new HashMap<>();
    private Command helpCommand;
    private Command showCommand;
    private Command addCommand;
    private Command updateCommand;
    private Command removeByIdCommand;
    private Command clearCommand;
    private Command exitCommand;
    private Command sumOfSalaryCommand;
    private Command sortCommand;
    private Command maxSalaryCommand;
    private Command minSalaryCommand;
    private Command averageSalaryCommand;
    private Command initialsCommand;
    private Command indexingCommand;
    private Command greaterThenNumberCommand;
    private Command lessThenNumberCommand;

    public CommandManager(CollectionManager collectionManager, WorkerAsker workerAsker) {
        this.collectionManager = collectionManager;
        this.workerAsker = workerAsker;

        helpCommand = new HelpCommand();
        showCommand = new ShowCommand(collectionManager);
        addCommand = new AddCommand(collectionManager, workerAsker);
        updateCommand = new UpdateCommand(collectionManager, workerAsker);
        removeByIdCommand = new RemoveByIdCommand(collectionManager);
        clearCommand = new ClearCommand(collectionManager);
        exitCommand = new ExitCommand();
        sumOfSalaryCommand = new SumOfSalaryCommand(collectionManager);
        sortCommand = new SortCommand(collectionManager);
        maxSalaryCommand = new MaxSalaryCommand(collectionManager);
        minSalaryCommand = new MinSalaryCommand(collectionManager);
        averageSalaryCommand = new AverageSalaryCommand(collectionManager);
        initialsCommand = new InitialsCommand(collectionManager);
        indexingCommand = new IndexingCommand(collectionManager);
        greaterThenNumberCommand = new GreaterThenNumberCommand(collectionManager);
        lessThenNumberCommand = new LessThenNumberCommand(collectionManager);


        commands.put("help", helpCommand);
        commands.put("show", showCommand);
        commands.put("add", addCommand);
        commands.put("update", updateCommand);
        commands.put("remove_by_id", removeByIdCommand);
        commands.put("clear", clearCommand);
        commands.put("exit", exitCommand);
        commands.put("sum_of_salary", sumOfSalaryCommand);
        commands.put("sort", sortCommand);
        commands.put("max_salary", maxSalaryCommand);
        commands.put("min_salary", minSalaryCommand);
        commands.put("average_salary", averageSalaryCommand);
        commands.put("initials", initialsCommand);
        commands.put("indexing", indexingCommand);
        commands.put("greater_then_number", greaterThenNumberCommand);
        commands.put("less_then_number", lessThenNumberCommand);

    }

    /**
     * @return List of manager's commands.
     */
    public List<Command> getCommands() {
        ArrayList<Command> values = new ArrayList<>(commands.values());
        return values;
    }
    /**
     * @return Map of manager's commands.
     */
    public HashMap<String, Command> getCollectionCommands() {
        return commands;
    }


    public boolean workingCommand(Command command , String[] userCommand)
    {
        if(isCommandExists(userCommand[0], command)) {
            if(command.execute(userCommand[1]))
                return true;
            else
                return false;
        }
        return false;

    }
    /**
     * Prints that command is not found.
     *
     * @param command Command, which is not found.
     * @return Command exit status.
     */
    public boolean isCommandExists(String info, Command command) {
        if(commands.containsValue(command))
            return true;
        Console.println("Команда '" + info + "' не найдена. Наберите 'help' для справки.");
        return false ;
    }

    @Override
    public String toString() {
        return "CommandManager (вспомогательный класс для работы с командами)";
    }
}