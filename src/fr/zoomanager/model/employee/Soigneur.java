package fr.zoomanager.model.employee;

import fr.zoomanager.model.animal.Animal;
import fr.zoomanager.model.animal.Species;
import java.util.ArrayList;
import java.util.List;

public class Soigneur extends Employee {
    private List<Species> specialties;

    public Soigneur(String name, double salary) {
        super(name, salary);
        this.specialties = new ArrayList<>();
    }

    public void addSpecialty(Species species) {
        specialties.add(species);
    }

    // Ajout de la méthode getSpecialties
    public List<Species> getSpecialties() {
        return new ArrayList<>(specialties);  // Retourne une copie défensive
    }

    public void healAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.heal();
            System.out.println(name + " soigne " + animal.getName());
        }
    }

    public void feedAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.feed();
            System.out.println(name + " nourrit " + animal.getName());
        }
    }

    @Override
    public void work() {
        System.out.println(name + " effectue sa tournée de soins");
    }
}
