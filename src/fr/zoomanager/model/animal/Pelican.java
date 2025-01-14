package fr.zoomanager.model.animal;

public class Pelican extends Oiseau {
    private double beakSize;
    private double pouchCapacity;

    public Pelican(String name, double wingspan, double beakSize, double pouchCapacity) {
        super(name, Species.PELICAN, wingspan, true);
        this.beakSize = beakSize;
        this.pouchCapacity = pouchCapacity;
    }

    @Override
    public String makeSound() {
        return "Croac croac!";
    }

    public void fish() {
        this.hunger = Math.max(0, this.hunger - 40);
        System.out.println(this.name + " attrape des poissons!");
    }
}
