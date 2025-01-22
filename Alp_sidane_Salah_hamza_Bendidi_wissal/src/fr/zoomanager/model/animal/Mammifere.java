package fr.zoomanager.model.animal;

/**
 * Classe abstraite représentant un mammifère dans le zoo.
 * Cette classe étend la classe {@link Animal} en ajoutant des caractéristiques spécifiques aux mammifères,
 * telles que leur comportement nocturne et leur période de gestation.
 */
public abstract class Mammifere extends Animal {
    /** Indique si le mammifère est nocturne. */
    protected boolean isNocturnal;
    
    /** Durée de la période de gestation en jours. */
    protected int gestationPeriod;

    /**
     * Constructeur d'un mammifère.
     * 
     * @param name Le nom du mammifère.
     * @param species L'espèce du mammifère.
     * @param isNocturnal Indique si le mammifère est nocturne.
     * @param gestationPeriod La durée de la période de gestation en jours.
     */
    public Mammifere(String name, Species species, boolean isNocturnal, int gestationPeriod) {
        super(name, species);
        this.isNocturnal = isNocturnal;
        this.gestationPeriod = gestationPeriod;
    }

    /**
     * Méthode abstraite pour la reproduction.
     * Chaque sous-classe de mammifère doit implémenter cette méthode pour définir
     * le comportement spécifique de reproduction de l'espèce.
     */
    public abstract void reproduce();
}
