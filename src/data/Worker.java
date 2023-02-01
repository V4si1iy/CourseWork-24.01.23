package data;


/**
 * Main character. Is stored in the collection.
 */
public class Worker {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Long salary;
    private Status status;
    private departments department;

    public Worker(Long id, String name, String surname, String patronymic, Long salary, Status status, departments department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
        this.status = status;
        this.department = department;
    }

    /**
     * @return ID of the worker.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Name of the worker.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Surname of the worker.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return Patronymic of the worker.
     */
    public String getPatronymic() {
        return patronymic;
    }


    /**
     * @return Amount of salary.
     */
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary= salary;
    }


    /**
     * @return Status of the worker.
     */
    public Status getStatus() {
        return status;
    }


    /**
     * @return Department of the worker.
     */
    public departments getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        String info = "";
        info += "Рабочий №" + id;
        info += "\n Имя: " + name;
        info += "\n Фамилия: " + surname;
        info += "\n Отчество: " + patronymic;
        info += "\n Зарплата: " + salary;
        info += "\n Статус: " + status;
        info += "\n Отдел: " + department;
        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + patronymic.hashCode() + salary.hashCode() + status.hashCode() + department.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Worker) {
            Worker workObj = (Worker) obj;
            return name.equals(workObj.getName()) && surname.equals(workObj.getSurname()) && patronymic.equals(workObj.getPatronymic()) &&
                    (salary == workObj.getSalary()) && status.equals(workObj.getStatus()) && department.equals(workObj.getDepartment());
        }
        return false;
    }
}
