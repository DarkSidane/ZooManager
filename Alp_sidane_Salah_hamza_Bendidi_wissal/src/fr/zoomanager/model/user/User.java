package fr.zoomanager.model.user;

import fr.zoomanager.model.employee.Employee;

public class User {
    private Employee employee;
    private Role role;

    public User(Employee employee, Role role) {
        this.employee = employee;
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("Connecté en tant que %s (Role: %s)", 
            employee.getName(), role.toString());
    }
}
