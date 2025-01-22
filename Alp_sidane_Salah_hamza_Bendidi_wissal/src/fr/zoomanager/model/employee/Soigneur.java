package fr.zoomanager.model.employee;

import fr.zoomanager.model.animal.Animal;
import fr.zoomanager.model.animal.Species;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un soigneur du zoo.
 * Le soigneur est responsable du soin et du nourrissage des animaux selon ses spécialités.
 * Il peut se spécialiser dans certaines espèces et effectue des tournées de soins quotidiennes.
 * 
 * @see Employee
 * @see Animal
 * @see Species
 */
public class Soigneur extends Employee {
    /** Liste des espèces dans lesquelles le soigneur est spécialisé */
    private List<Species> specialties;

    /**
     * Constructeur d'un soigneur.
     * 
     * @param name Nom du soigneur
     * @param salary Salaire du soigneur
     * @throws IllegalArgumentException si le salaire est négatif
     */
    public Soigneur(String name, double salary) {
        super(name, salary);
        this.specialties = new ArrayList<>();
    }

    /**
     * Ajoute une spécialité au soigneur.
     * Si l'espèce est déjà dans la liste des spécialités, elle ne sera pas ajoutée à nouveau.
     * 
     * @param species L'espèce dans laquelle le soigneur se spécialise
     */
    public void addSpecialty(Species species) {
        if (!specialties.contains(species)) {
            specialties.add(species);
        }
    }

    /**
     * Retourne la liste des spécialités du soigneur.
     * 
     * @return Une copie de la liste des spécialités
     */
    public List<Species> getSpecialties() {
        return new ArrayList<>(specialties);  // Copie défensive
    }

    /**
     * Soigne un animal si le soigneur est qualifié pour cette espèce.
     * 
     * @param animal L'animal à soigner
     */
    public void healAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.heal();
            System.out.println(this.getName() + " soigne " + animal.getName());
        }
    }

    /**
     * Nourrit un animal si le soigneur est qualifié pour cette espèce.
     * 
     * @param animal L'animal à nourrir
     */
    public void feedAnimal(Animal animal) {
        if (specialties.contains(animal.getSpecies())) {
            animal.feed();
            System.out.println(this.getName() + " nourrit " + animal.getName());
        }
    }

    /**
     * Effectue la tournée de soins quotidienne.
     * Le soigneur vérifie l'état des animaux et effectue les soins nécessaires.
     */
    @Override
    public void work() {
        System.out.println(this.getName() + " effectue sa tournée de soins");
    }
}
