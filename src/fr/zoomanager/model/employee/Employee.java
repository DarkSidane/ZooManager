package fr.zoomanager.model.employee;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
