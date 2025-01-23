package fr.zoomanager.model.animal;

/**
 * Classe représentant un lion dans le zoo.
 * Le lion est un mammifère caractérisé par son statut d'alpha et la taille de son groupe (pride).
 * Il hérite de la classe {@link Mammifere} et implémente des comportements spécifiques comme rugir,
 * chasser et se reproduire.
 */
public class Lion extends Mammifere {
    /** Taille du groupe (pride) auquel appartient le lion. */
    private int prideSize;
    
    /** Indique si ce lion est l'alpha du groupe. */
    private boolean isAlpha;

    /**
     * Constructeur d'un lion.
     * 
     * @param name Le nom du lion.
     * @param prideSize La taille du groupe (pride) auquel appartient le lion.
     * @param isAlpha Indique si le lion est l'alpha du groupe.
     */
    public Lion(String name, int prideSize, boolean isAlpha) {
        super(name, Species.LION, true, 110);
        this.prideSize = prideSize;
        this.isAlpha = isAlpha;
    }

    /**
     * Fait rugir le lion.
     * 
     * @return Le son du rugissement du lion.
     */
    @Override
    public String makeSound() {
        return "ROAAAR!";
    }

    /**
     * Simule une chasse.
     * Réduit significativement la faim du lion après une chasse réussie.
     */
    public void hunt() {
        this.hunger = Math.max(0, this.hunger - 70);
    }

    /**
     * Tente une reproduction.
     * Un nouveau lionceau peut naître uniquement si le lion est en bonne santé
     * et s'il est l'alpha du groupe.
     */
    @Override
    public void reproduce() {
        if (this.health > 80 && this.isAlpha) {
            System.out.println("Un nouveau lionceau est né !");
        }
    }

    /**
     * Retourne l'état complet du lion.
     * Inclut les informations de base (nom, santé, faim) ainsi que le statut d'alpha
     * et la taille du groupe.
     * 
     * @return L'état formaté du lion.
     */
    @Override
    public String getStatus() {
        return super.getStatus() + String.format(", Alpha: %s, Taille du groupe: %d", 
            this.isAlpha ? "Oui" : "Non", this.prideSize);
    }
}
