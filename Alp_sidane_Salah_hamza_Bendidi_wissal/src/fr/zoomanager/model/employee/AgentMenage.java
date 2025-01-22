package fr.zoomanager.model.employee;

import fr.zoomanager.model.enclos.Enclos;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un agent de ménage du zoo.
 * L'agent de ménage est responsable du nettoyage et de l'entretien des enclos qui lui sont assignés.
 * Il effectue des rondes d'inspection pour vérifier l'état des enclos et les nettoie si nécessaire.
 * 
 * @see Employee
 * @see Enclos
 */
public class AgentMenage extends Employee {
    /** Liste des enclos dont l'agent est responsable */
    private List<Enclos> assignedEnclos;

    /**
     * Constructeur d'un agent de ménage.
     * 
     * @param name Nom de l'agent
     * @param salary Salaire de l'agent
     * @throws IllegalArgumentException si le salaire est négatif
     */
    public AgentMenage(String name, double salary) {
        super(name, salary);
        this.assignedEnclos = new ArrayList<>();
    }

    /**
     * Assigne un nouvel enclos à l'agent.
     * Si l'enclos est déjà assigné, il ne sera pas ajouté à nouveau.
     * 
     * @param enclos L'enclos à assigner
     */
    public void assignEnclos(Enclos enclos) {
        if (!assignedEnclos.contains(enclos)) {
            assignedEnclos.add(enclos);
        }
    }

    /**
     * Nettoie un enclos si celui-ci est assigné à l'agent.
     * 
     * @param enclos L'enclos à nettoyer
     */
    public void cleanEnclos(Enclos enclos) {
        if (assignedEnclos.contains(enclos)) {
            enclos.clean();
            System.out.println(name + " nettoie l'enclos " + enclos.getName());
        }
    }

    /**
     * Effectue la ronde d'inspection quotidienne.
     * Vérifie l'état de chaque enclos assigné et les nettoie si nécessaire.
     */
    @Override
    public void work() {
        System.out.println(name + " fait sa ronde d'inspection");
        for (Enclos enclos : assignedEnclos) {
            checkEnclos(enclos);
        }
    }

    /**
     * Vérifie l'état d'un enclos et le nettoie si nécessaire.
     * 
     * @param enclos L'enclos à vérifier
     */
    private void checkEnclos(Enclos enclos) {
        if (enclos.needsCleaning()) {
            cleanEnclos(enclos);
        }
    }

    /**
     * Retourne la liste des enclos assignés à l'agent.
     * 
     * @return Une copie de la liste des enclos assignés
     */
    public List<Enclos> getAssignedEnclos() {
        return new ArrayList<>(assignedEnclos);
    }
}
