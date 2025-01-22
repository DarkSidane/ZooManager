package fr.zoomanager.model.animal;

/**
 * Classe représentant un flamant rose dans le zoo.
 * Le flamant rose est un oiseau caractérisé par sa couleur de plumage et sa capacité à se tenir sur une patte.
 * Cette classe étend la classe abstraite {@link Oiseau} et implémente des comportements spécifiques au flamant rose.
 */
public class FlamantRose extends Oiseau {
    /** Couleur du plumage du flamant rose. */
    private String plumageColor;
    
    /** Temps passé sur une patte en minutes. */
    private int balanceTime;

    /**
     * Constructeur du flamant rose.
     * 
     * @param name Le nom du flamant rose.
     * @param wingspan L'envergure des ailes du flamant rose en mètres.
     * @param plumageColor La couleur du plumage du flamant rose.
     */
    public FlamantRose(String name, double wingspan, String plumageColor) {
        super(name, Species.FLAMANT_ROSE, wingspan, true);
        this.plumageColor = plumageColor;
        this.balanceTime = 0;
    }

    /**
     * Retourne le son émis par le flamant rose.
     * 
     * @return Le son "Honk honk!" représentant le cri du flamant rose.
     */
    @Override
    public String makeSound() {
        return "Honk honk!";
    }

    /**
     * Fait se tenir le flamant rose sur une patte.
     * Incrémente le temps passé dans cette position et affiche un message.
     */
    public void standOneLeg() {
        this.balanceTime++;
        System.out.println(this.name + " se tient sur une patte depuis " + balanceTime + " minutes!");
    }

    /**
     * Fait filtrer l'eau pour se nourrir.
     * Réduit la faim du flamant rose et affiche un message.
     */
    public void filter() {
        this.hunger = Math.max(0, this.hunger - 30);
        System.out.println(this.name + " filtre l'eau pour se nourrir!");
    }
}
