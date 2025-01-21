package fr.zoomanager.model.animal;

public abstract class Animal {
    protected String name;
    protected double health;
    protected double hunger;
    protected Species species;

    public Animal(String name, Species species) {
        this.name = name;
        this.health = 100.0;
        this.hunger = 0.0;
        this.species = species;
    }

    public void feed() {
        this.hunger = Math.max(0, this.hunger - 50);
    }

    public void heal() {
        this.health = Math.min(100, this.health + 20);
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getHunger() {
        return hunger;
    }

    public Species getSpecies() {
        return species;
    }

    public abstract String makeSound();

    public String getStatus() {
        return String.format("%s - Santé: %.1f%%, Faim: %.1f%%", 
            this.name, this.health, this.hunger);
    }

    public void updateState() {
        this.hunger = Math.min(100, this.hunger + 5);
        if (this.hunger > 80) {
            this.health = Math.max(0, this.health - 5);
        }
    }
}
