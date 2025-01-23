package fr.zoomanager.model.animal;

/**
 * Classe abstraite représentant un animal dans le zoo.
 * Cette classe sert de base pour tous les types d'animaux, définissant des attributs communs
 * comme le nom, la santé, la faim et l'espèce, ainsi que des méthodes pour nourrir, soigner
 * et mettre à jour l'état de l'animal.
 */
public abstract class Animal {
    /** Nom de l'animal */
    protected String name;
    
    /** Niveau de santé de l'animal (en pourcentage) */
    protected double health;
    
    /** Niveau de faim de l'animal (en pourcentage) */
    protected double hunger;
    
    /** Espèce de l'animal */
    protected Species species;

    /**
     * Constructeur d'un animal.
     * 
     * @param name Le nom de l'animal
     * @param species L'espèce de l'animal
     */
    public Animal(String name, Species species) {
        this.name = name;
        this.health = 100.0;
        this.hunger = 0.0;
        this.species = species;
    }

    /**
     * Nourrit l'animal, réduisant son niveau de faim.
     * La faim ne peut pas descendre en dessous de 0.
     */
    public void feed() {
        this.hunger = Math.max(0, this.hunger - 50);
    }

    /**
     * Soigne l'animal, augmentant son niveau de santé.
     * La santé ne peut pas dépasser 100.
     */
    public void heal() {
        this.health = Math.min(100, this.health + 20);
    }

    /**
     * Retourne le nom de l'animal.
     * 
     * @return Le nom de l'animal
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le niveau de santé de l'animal.
     * 
     * @return Le niveau de santé (en pourcentage)
     */
    public double getHealth() {
        return health;
    }

    /**
     * Retourne le niveau de faim de l'animal.
     * 
     * @return Le niveau de faim (en pourcentage)
     */
    public double getHunger() {
        return hunger;
    }

    /**
     * Retourne l'espèce de l'animal.
     * 
     * @return L'espèce de l'animal
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Méthode abstraite pour émettre un son.
     * Chaque sous-classe doit implémenter cette méthode pour définir le son spécifique de l'animal.
     * 
     * @return Le son émis par l'animal
     */
    public abstract String makeSound();

    /**
     * Retourne l'état actuel de l'animal sous forme de chaîne de caractères.
     * Inclut le nom, la santé et la faim de l'animal.
     * 
     * @return L'état formaté de l'animal
     */
    public String getStatus() {
        return String.format("%s - Santé: %.1f%%, Faim: %.1f%%", 
            this.name, this.health, this.hunger);
    }

    /**
     * Met à jour l'état de l'animal.
     * Augmente la faim et, si la faim est trop élevée, réduit la santé.
     */
    public void updateState() {
        this.hunger = Math.min(100, this.hunger + 5);
        if (this.hunger > 80) {
            this.health = Math.max(0, this.health - 5);
        }
    }
}
