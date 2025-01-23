package fr.zoomanager.model.user;

import fr.zoomanager.model.employee.Employee;

/**
 * Classe représentant un utilisateur du système.
 * Un utilisateur est associé à un employé et à un rôle spécifique.
 * 
 * @see Employee
 * @see Role
 */
public class User {
    /** L'employé associé à l'utilisateur. */
    private Employee employee;
    
    /** Le rôle de l'utilisateur dans le système. */
    private Role role;

    /**
     * Constructeur d'un utilisateur.
     * 
     * @param employee L'employé associé à l'utilisateur.
     * @param role Le rôle de l'utilisateur.
     * @throws IllegalArgumentException si l'employé ou le rôle est null.
     */
    public User(Employee employee, Role role) {
        if (employee == null || role == null) {
            throw new IllegalArgumentException("L'employé et le rôle ne peuvent pas être null");
        }
        this.employee = employee;
        this.role = role;
    }

    /**
     * Retourne l'employé associé à l'utilisateur.
     * 
     * @return L'employé associé.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Retourne le rôle de l'utilisateur.
     * 
     * @return Le rôle de l'utilisateur.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Retourne une représentation textuelle de l'utilisateur.
     * Format : "Connecté en tant que [nom de l'employé] (Role: [rôle])".
     * 
     * @return La représentation textuelle de l'utilisateur.
     */
    @Override
    public String toString() {
        return String.format("Connecté en tant que %s (Role: %s)", 
            employee.getName(), role.toString());
    }
}
