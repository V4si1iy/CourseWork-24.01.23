package utillity;


import java.util.*;

import data.Worker;

/**
 * Operates the collection itself.
 */
public class CollectionManager {
    private ArrayList<Worker> workersCollection = new ArrayList();


    public CollectionManager() {

    }

    /**
     * @return The collection itself.
     */
    public ArrayList<Worker> getCollection() {
        return workersCollection;
    }

    /**
     * @param id ID of the worker.
     * @return A worker by his ID or null if worker isn't found.
     */
    public Worker getById(Long id) {
        for (Worker work : workersCollection) {
            if (work.getId().equals(id)) return work;
        }
        return null;
    }

    /**
     * @return Size of the collection.
     */
    public int collectionSize() {
        return workersCollection.size();
    }

    /**
     * @param workToFind A worker who's value will be found.
     * @return A worker by his value or null if worker isn't found.
     */
    public Worker getByValue(Worker workToFind) {
        for (Worker work : workersCollection) {
            if (work.equals(workToFind)) return work;
        }
        return null;
    }

    /**
     * @return Sum of all workers' salary or 0 if collection is empty.
     */
    public double getSumOfSalary() {
        double sumOfSalary = 0;
        for (Worker work : workersCollection) {
            sumOfSalary += work.getSalary();
        }
        return sumOfSalary;
    }

    /**
     * @return Average of all workers' salary or 0 if collection is empty.
     */
    public double getAverageSalary() {
        double averageOfSalary = 0.0;
        averageOfSalary = getSumOfSalary() / workersCollection.size();
        return averageOfSalary;
    }


    /**
     * Adds a new worker to collection.
     *
     * @param work A worker to add.
     */
    public void addToCollection(Worker work) {
        workersCollection.add(work);
    }

    /**
     * Removes worker to collection.
     *
     * @param work A worker to remove.
     */
    public void removeFromCollection(Worker work) {
        workersCollection.remove(work);
    }


    /**
     * Clears the collection.
     */
    public void clearCollection() {
        workersCollection.clear();
    }

    /**
     * Generates next ID. It will be (the bigger one + 1).
     *
     * @return Next ID.
     */
    public Long generateNextId() {

        if (workersCollection.isEmpty()) return 1L;
        return workersCollection.get(workersCollection.size() - 1).getId() + 1;
    }

    /**
     * Sort the collection .
     */
    public void sortCollection() {
        Collections.sort(workersCollection, Comparator.comparing(Worker::getDepartment));
    }

    /**
     * Max salary of the collection .
     *
     * @return Worker with max salary
     */
    public Worker maxSalary() {
        double maxSalary = workersCollection.get(0).getSalary();
        Worker info = workersCollection.get(0);
        for (Worker work : workersCollection) {
            if (work.getSalary() > maxSalary) {
                maxSalary = work.getSalary();
                info = work;
            }
        }
        return info;
    }

    /**
     * Min salary of the collection .
     *
     * @return Worker with min salary
     */
    public Worker minSalary() {
        double minSalary = workersCollection.get(0).getSalary();
        Worker info = workersCollection.get(0);
        for (Worker work : workersCollection) {
            if (work.getSalary() < minSalary) {
                minSalary = work.getSalary();
                info = work;
            }
        }
        return info;
    }


    /**
     * Get the first letters of workers
     *
     * @return Workers'F.I.O
     */
    public String InitialsToString() {
        if (workersCollection.isEmpty()) return "Коллекция пуста!";
        String info = "";
        for (Worker work : workersCollection) {
            char secondOfName = work.getSurname().charAt(work.getSurname().indexOf(' ') + 1);
            char thirdOfName = work.getPatronymic().charAt(work.getPatronymic().indexOf(' ', work.getPatronymic().indexOf(' ') + 1) + 1);
            char firstOfName = work.getName().charAt(0);
            info += firstOfName;
            info += '.';
            info += secondOfName;
            info += '.';
            info += thirdOfName;
            info += '.';
            if (work != workersCollection.get(workersCollection.size() - 1)) info += "\n\n";
        }
        return info;
    }

    @Override
    public String toString() {
        if (workersCollection.isEmpty()) return "Коллекция пуста!";

        String info = "";
        for (Worker work : workersCollection) {
            info += work;
            if (work != workersCollection.get(workersCollection.size() - 1)) info += "\n\n";
        }
        return info;
    }
}

