package fr.zoomanager.model.animal;

/**
 * Classe représentant un zèbre dans le zoo.
 * Le zèbre est un mammifère caractérisé par son motif de rayures et la taille de son troupeau.
 * Il peut galoper, émettre un son spécifique et se reproduire sous certaines conditions.
 */
public class Zebre extends Mammifere {
    /** Motif des rayures du zèbre. */
    private String stripePattern;
    
    /** Taille du troupeau auquel appartient le zèbre. */
    private int herdSize;

    /**
     * Constructeur d'un zèbre.
     * 
     * @param name Le nom du zèbre.
     * @param stripePattern Le motif des rayures du zèbre.
     * @param herdSize La taille du troupeau auquel appartient le zèbre.
     */
    public Zebre(String name, String stripePattern, int herdSize) {
        super(name, Species.ZEBRE, false, 365);
        this.stripePattern = stripePattern;
        this.herdSize = herdSize;
    }

    /**
     * Retourne le son émis par le zèbre.
     * 
     * @return Le son du hennissement du zèbre.
     */
    @Override
    public String makeSound() {
        return "Hennissement!";
    }

    /**
     * Fait galoper le zèbre.
     * Augmente la faim du zèbre après l'effort.
     */
    public void gallop() {
        this.hunger += 10;
        System.out.println(this.name + " galope majestueusement!");
    }

    /**
     * Tente de faire se reproduire le zèbre.
     * La reproduction réussit uniquement si le zèbre est en bonne santé (santé > 70)
     * et si la taille du troupeau est suffisante (troupeau > 5).
     */
    @Override
    public void reproduce() {
        if (this.health > 70 && this.herdSize > 5) {
            System.out.println("Un nouveau zèbre est né !");
        }
    }
}
