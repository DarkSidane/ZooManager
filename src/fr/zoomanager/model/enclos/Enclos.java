package fr.zoomanager.model.enclos;

import fr.zoomanager.model.animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Enclos {
    private String name;
    private int capacity;
    private List<Animal> animals;
    private double cleanliness;

    public Enclos(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
        this.cleanliness = 100.0;
    }

    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void clean() {
        this.cleanliness = 100.0;
    }

    public boolean needsCleaning() {
        return cleanliness < 50.0;
    }

    public void updateState() {
        cleanliness = Math.max(0, cleanliness - (2 * animals.size()));
        for (Animal animal : animals) {
            animal.updateState();
        }
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public String getStatus() {
        return String.format("Enclos %s - Propreté: %.1f%%, Animaux: %d/%d", 
            name, cleanliness, animals.size(), capacity);
    }
}
