package fr.zoomanager.model;

import fr.zoomanager.model.animal.Animal;
import fr.zoomanager.model.employee.Employee;
import fr.zoomanager.model.enclos.Enclos;
import fr.zoomanager.model.financial.Budget;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale représentant le zoo et gérant tous ses composants.
 * Cette classe centralise la gestion des enclos, des employés et du budget.
 */
public class Zoo {
    /** Liste des enclos du zoo. */
    private List<Enclos> enclos;
    
    /** Liste des employés travaillant au zoo. */
    private List<Employee> employees;
    
    /** Budget du zoo pour la gestion financière. */
    private Budget budget;
    
    /** Nom du zoo. */
    private String name;

    /**
     * Constructeur initialisant un nouveau zoo.
     * Crée des listes vides pour les enclos et employés, initialise le budget,
     * et définit un nom par défaut pour le zoo.
     */
    public Zoo() {
        this.enclos = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.budget = new Budget();
        this.name = "Mon Zoo";
    }

    /**
     * Ajoute un nouvel enclos au zoo.
     * 
     * @param enclos L'enclos à ajouter
     */
    public void addEnclos(Enclos enclos) {
        this.enclos.add(enclos);
    }

    /**
     * Retire un enclos du zoo.
     * 
     * @param enclos L'enclos à retirer
     */
    public void removeEnclos(Enclos enclos) {
        this.enclos.remove(enclos);
    }

    /**
     * Ajoute un nouvel employé au zoo.
     * 
     * @param employee L'employé à ajouter
     */
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    /**
     * Retire un employé du zoo.
     * 
     * @param employee L'employé à retirer
     */
    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    /**
     * Retourne une copie de la liste des enclos.
     * 
     * @return Une nouvelle liste contenant tous les enclos
     */
    public List<Enclos> getEnclos() {
        return new ArrayList<>(enclos);
    }

    /**
     * Retourne une copie de la liste des employés.
     * 
     * @return Une nouvelle liste contenant tous les employés
     */
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    /**
     * Retourne le budget du zoo.
     * 
     * @return Le budget du zoo
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * Retourne le nom du zoo.
     * 
     * @return Le nom du zoo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom du zoo.
     * 
     * @param name Le nouveau nom du zoo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Met à jour l'état de tous les enclos du zoo.
     * Cette méthode est appelée périodiquement pour simuler le passage du temps
     * et mettre à jour l'état des animaux et des enclos.
     */
    public void updateState() {
        for (Enclos enclos : this.enclos) {
            enclos.updateState();
        }
    }
}
