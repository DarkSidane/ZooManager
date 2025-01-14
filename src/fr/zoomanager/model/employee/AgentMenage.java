package fr.zoomanager.model.employee;

import fr.zoomanager.model.enclos.Enclos;
import java.util.ArrayList;
import java.util.List;

public class AgentMenage extends Employee {
    private List<Enclos> assignedEnclos;

    public AgentMenage(String name, double salary) {
        super(name, salary);
        this.assignedEnclos = new ArrayList<>();
    }

    public void assignEnclos(Enclos enclos) {
        assignedEnclos.add(enclos);
    }

    public void cleanEnclos(Enclos enclos) {
        if (assignedEnclos.contains(enclos)) {
            enclos.clean();
            System.out.println(name + " nettoie l'enclos " + enclos.getName());
        }
    }

    @Override
    public void work() {
        System.out.println(name + " fait sa ronde d'inspection");
        for (Enclos enclos : assignedEnclos) {
            checkEnclos(enclos);
        }
    }

    private void checkEnclos(Enclos enclos) {
        if (enclos.needsCleaning()) {
            cleanEnclos(enclos);
        }
    }
}
