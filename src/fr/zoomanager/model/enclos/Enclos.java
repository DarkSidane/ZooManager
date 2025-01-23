package fr.zoomanager.model.enclos;

import fr.zoomanager.model.animal.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un enclos dans le zoo.
 * Un enclos contient un certain nombre d'animaux et possède un niveau de propreté.
 * Il est caractérisé par un nom, une capacité maximale et une liste d'animaux.
 * 
 * @see Animal
 */
public class Enclos {
    /** Nom de l'enclos */
    private String name;
    
    /** Capacité maximale de l'enclos (nombre d'animaux) */
    private int capacity;
    
    /** Liste des animaux présents dans l'enclos */
    private List<Animal> animals;
    
    /** Niveau de propreté de l'enclos (en pourcentage) */
    private double cleanliness;

    /**
     * Constructeur d'un enclos.
     * 
     * @param name Le nom de l'enclos
     * @param capacity La capacité maximale de l'enclos
     * @throws IllegalArgumentException si la capacité est négative
     */
    public Enclos(String name, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("La capacité ne peut pas être négative");
        }
        this.name = name;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
        this.cleanliness = 100.0;
    }

    /**
     * Ajoute un animal à l'enclos si la capacité maximale n'est pas atteinte.
     * 
     * @param animal L'animal à ajouter
     */
    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        }
    }

    /**
     * Retire un animal de l'enclos.
     * 
     * @param animal L'animal à retirer
     */
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    /**
     * Nettoie l'enclos, ramenant son niveau de propreté à 100%.
     */
    public void clean() {
        this.cleanliness = 100.0;
    }

    /**
     * Vérifie si l'enclos a besoin d'être nettoyé.
     * 
     * @return true si le niveau de propreté est inférieur à 50%, sinon false
     */
    public boolean needsCleaning() {
        return cleanliness < 50.0;
    }

    /**
     * Met à jour l'état de l'enclos.
     * Réduit la propreté en fonction du nombre d'animaux et met à jour l'état de chaque animal.
     */
    public void updateState() {
        cleanliness = Math.max(0, cleanliness - (2 * animals.size()));
        for (Animal animal : animals) {
            animal.updateState();
        }
    }

    /**
     * Retourne le nom de l'enclos.
     * 
     * @return Le nom de l'enclos
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la liste des animaux présents dans l'enclos.
     * 
     * @return Une copie de la liste des animaux
     */
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    /**
     * Retourne le niveau de propreté de l'enclos.
     * 
     * @return Le niveau de propreté (en pourcentage)
     */
    public double getCleanliness() {
        return cleanliness;
    }

    /**
     * Retourne l'état actuel de l'enclos sous forme de chaîne de caractères.
     * Inclut le nom, le niveau de propreté et le nombre d'animaux présents.
     * 
     * @return L'état formaté de l'enclos
     */
    public String getStatus() {
        return String.format("Enclos %s - Propreté: %.1f%%, Animaux: %d/%d", 
            name, cleanliness, animals.size(), capacity);
    }
}
