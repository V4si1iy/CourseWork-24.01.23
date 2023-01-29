package utillity;

import java.util.ArrayList;
import java.util.List;

import Commands.Command;


/**
 * Operates the commands.
 */
public class CommandManager {
    private List<Command> commands = new ArrayList<>();
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


    public CommandManager(Command helpCommand, Command showCommand, Command addCommand, Command updateCommand,
                          Command removeByIdCommand, Command exitCommand, Command sumOfSalaryCommand, Command clearCommand,
                          Command sortCommand, Command maxSalaryCommand, Command minSalaryCommand, Command averageSalaryCommand,
                          Command initialsCommand, Command indexingCommand, Command greaterThenNumberCommand, Command lessThenNumberCommand

    ) {
        this.helpCommand = helpCommand;
        this.showCommand = showCommand;
        this.addCommand = addCommand;
        this.updateCommand = updateCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.exitCommand = exitCommand;
        this.sumOfSalaryCommand = sumOfSalaryCommand;
        this.clearCommand = clearCommand;
        this.sortCommand = sortCommand;
        this.maxSalaryCommand = maxSalaryCommand;
        this.minSalaryCommand = minSalaryCommand;
        this.averageSalaryCommand = averageSalaryCommand;
        this.initialsCommand = initialsCommand;
        this.indexingCommand = indexingCommand;
        this.greaterThenNumberCommand=greaterThenNumberCommand;
        this.lessThenNumberCommand = lessThenNumberCommand;

        commands.add(helpCommand);
        commands.add(showCommand);
        commands.add(addCommand);
        commands.add(updateCommand);
        commands.add(removeByIdCommand);
        commands.add(exitCommand);
        commands.add(sumOfSalaryCommand);
        commands.add(sortCommand);
        commands.add(maxSalaryCommand);
        commands.add(minSalaryCommand);
        commands.add(averageSalaryCommand);
        commands.add(initialsCommand);
        commands.add(indexingCommand);
        commands.add(greaterThenNumberCommand);
        commands.add(lessThenNumberCommand);
    }


    /**
     * @return List of manager's commands.
     */
    public List<Command> getCommands() {
        return commands;
    }


    /**
     * Prints that command is not found.
     *
     * @param command Command, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Prints info about the all commands.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.printtable(command.getName(), command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean add(String argument) {
        return addCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean update(String argument) {
        return updateCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeById(String argument) {
        return removeByIdCommand.execute(argument);
    }


    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean indexing(String argument) {
        return indexingCommand.execute(argument);
    }


    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean sumOfSalary(String argument) {
        return sumOfSalaryCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean sort(String argument) {
        return sortCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean maxSalary(String argument) {
        return sumOfSalaryCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean minSalary(String argument) {
        return sumOfSalaryCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean averageSalary(String argument) {
        return averageSalaryCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean initials(String argument) {
        return initialsCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean greaterThenNumber(String argument) {
        return greaterThenNumberCommand.execute(argument);
    }

    /**
     * Executes needed command.
     *
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean lessThenNumber(String argument) {
        return lessThenNumberCommand.execute(argument);
    }

    @Override
    public String toString() {
        return "CommandManager (вспомогательный класс для работы с командами)";
    }
}