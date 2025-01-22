package fr.zoomanager.model.employee;

/**
 * Classe abstraite représentant un employé du zoo.
 * Définit les caractéristiques de base communes à tous les employés, comme le nom et le salaire.
 * Chaque type d'employé doit implémenter la méthode `work()` pour définir ses tâches spécifiques.
 * 
 * @see Soigneur
 * @see AgentMenage
 */
public abstract class Employee {
    /** Nom de l'employé */
    protected String name;
    
    /** Salaire de l'employé en euros */
    protected double salary;

    /**
     * Constructeur d'un employé.
     * 
     * @param name Le nom de l'employé
     * @param salary Le salaire de l'employé
     * @throws IllegalArgumentException si le salaire est négatif
     */
    public Employee(String name, double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif");
        }
        this.name = name;
        this.salary = salary;
    }

    /**
     * Méthode abstraite représentant le travail de l'employé.
     * Chaque sous-classe doit implémenter cette méthode pour définir les tâches spécifiques de l'employé.
     */
    public abstract void work();

    /**
     * Retourne le salaire de l'employé.
     * 
     * @return Le salaire de l'employé en euros
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Retourne le nom de l'employé.
     * 
     * @return Le nom de l'employé
     */
    public String getName() {
        return name;
    }
}
