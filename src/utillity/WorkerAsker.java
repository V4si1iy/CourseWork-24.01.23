package utillity;

import java.util.NoSuchElementException;
import java.util.Scanner;

import data.*;


import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import Start.App;

/**
 * Asks a user a Worker's value.
 */
public class WorkerAsker{
    private final double MIN_SALARY= 0;
    private final double MIN_Percent = 1;

    private Scanner userScanner;

    public WorkerAsker(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * Sets a scanner to scan user input.
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }


    /**
     * Asks a user the worker's name.
     * @return worker's name.
     */

    public String askName(){
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * Asks a user the worker's surname.
     * @return worker's surname.
     */

    public String askSurname(){
        String name;
        while (true) {
            try {
                Console.println("Введите Фамилию:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Фамилия не распознана!");
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Фамилия не может быть пустой!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }
    /**
     * Asks a user the worker's patronymic.
     * @return worker's patronymic.
     */

    public String askPatronymic(){
        String name;
        while (true) {
            try {
                Console.println("Введите Отчество:");
                Console.print(App.PS2);
                name = userScanner.nextLine().trim();
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Отчество не распознано!");
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Отчество не может быть пустым!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }

    /**
     * Asks a user the worker's salary.
     * @return Worker's salary.
     */
    public Long askSalary() {
        String strSalary;
        Long salary;
        while (true) {
            try {
                Console.println("Введите зарплату:");
                Console.print(App.PS2);
                strSalary = userScanner.nextLine().trim();
                salary = Long.parseLong(strSalary);
                if (salary < MIN_SALARY) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Зарплата не распознана!");
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Зарплата должна быть больше нуля!");
            } catch (NumberFormatException exception) {
                Console.printerror("Зарплата должна быть представлена числом!");
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return salary;
    }

    /**
     * Asks a user the worker's department.
     * @return Worker's department.
     */
    public departments askDepartment()  {
        String strDepartment;
        departments department;
        while (true) {
            try {
                Console.println("Список оделов - " + departments.nameList());
                Console.println("Введите отдел:");
                Console.print(App.PS2);
                strDepartment = userScanner.nextLine().trim();
                department=departments.valueOf(strDepartment);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Отдел не распознан!");
            } catch (IllegalArgumentException exception) {
                Console.printerror("Отдела нет в списке!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return department;
    }

    /**
     * Asks a user the worker's status.
     * @return worker's status.
     */
    public Status askStatus() {
        String strStatus;
        Status stat;
        while (true) {
            try {
                Console.println("Список статусов - " + Status.nameList());
                Console.println("Введите статус :");
                Console.print(App.PS2);
                strStatus = userScanner.nextLine().trim();

                stat = Status.valueOf(strStatus);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Статус не распознано!");

            } catch (IllegalArgumentException exception) {
                Console.printerror("Статус нет в списке!");

            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return stat;
    }
    public boolean askQuestion(String question) {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = userScanner.nextLine().trim();
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }
    @Override
    public String toString() {
        return "WorkerAsker (вспомогательный класс для запросов пользователю)";
    }
}