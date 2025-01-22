package fr.zoomanager.model.animal;

/**
 * Classe représentant un pélican dans le zoo.
 * Le pélican est un oiseau caractérisé par la taille de son bec et la capacité de sa poche.
 * Il peut pêcher pour se nourrir, ce qui réduit son niveau de faim.
 */
public class Pelican extends Oiseau {
    /** Taille du bec en mètres. */
    private double beakSize;
    
    /** Capacité de la poche en litres. */
    private double pouchCapacity;

    /**
     * Constructeur d'un pélican.
     * 
     * @param name Le nom du pélican.
     * @param wingspan L'envergure des ailes en mètres.
     * @param beakSize La taille du bec en mètres.
     * @param pouchCapacity La capacité de la poche en litres.
     */
    public Pelican(String name, double wingspan, double beakSize, double pouchCapacity) {
        super(name, Species.PELICAN, wingspan, true);
        this.beakSize = beakSize;
        this.pouchCapacity = pouchCapacity;
    }

    /**
     * Retourne le son émis par le pélican.
     * 
     * @return Le son du croassement du pélican.
     */
    @Override
    public String makeSound() {
        return "Croac croac!";
    }

    /**
     * Fait pêcher le pélican.
     * Réduit son niveau de faim grâce aux poissons attrapés.
     * Affiche un message indiquant que le pélican a attrapé des poissons.
     */
    public void fish() {
        this.hunger = Math.max(0, this.hunger - 40);
        System.out.println(this.name + " attrape des poissons!");
    }
}
