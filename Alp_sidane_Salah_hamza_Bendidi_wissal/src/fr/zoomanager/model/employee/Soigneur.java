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

    public List<Species> getSpecialties() {
        return new ArrayList<>(specialties);
    }

    public void healAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.heal();
            System.out.println(this.getName() + " soigne " + animal.getName());
        }
    }

    public void feedAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.feed();
            System.out.println(this.getName() + " nourrit " + animal.getName());
        }
    }

    @Override
    public void work() {
        System.out.println(this.getName() + " effectue sa tournée de soins");
    }
}
