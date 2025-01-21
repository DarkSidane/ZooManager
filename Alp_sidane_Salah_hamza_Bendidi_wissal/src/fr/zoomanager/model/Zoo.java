package fr.zoomanager.model;

import fr.zoomanager.model.animal.Animal;
import fr.zoomanager.model.employee.Employee;
import fr.zoomanager.model.enclos.Enclos;
import fr.zoomanager.model.financial.Budget;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Enclos> enclos;
    private List<Employee> employees;
    private Budget budget;
    private String name;

    public Zoo() {
        this.enclos = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.budget = new Budget();
        this.name = "Mon Zoo";
    }

    public void addEnclos(Enclos enclos) {
        this.enclos.add(enclos);
    }

    public void removeEnclos(Enclos enclos) {
        this.enclos.remove(enclos);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public List<Enclos> getEnclos() {
        return new ArrayList<>(enclos);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public Budget getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateState() {
        for (Enclos enclos : this.enclos) {
            enclos.updateState();
        }
    }
}
