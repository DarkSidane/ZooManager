package fr.zoomanager.model.animal;

/**
 * Énumération représentant les différentes espèces d'animaux disponibles dans le zoo.
 * Chaque espèce possède un nom d'affichage personnalisé pour une meilleure lisibilité.
 */
public enum Species {
    /** Représente un lion. */
    LION("Lion"),
    
    /** Représente un zèbre. */
    ZEBRE("Zèbre"),
    
    /** Représente un pélican. */
    PELICAN("Pélican"),
    
    /** Représente un flamant rose. */
    FLAMANT_ROSE("Flamant Rose");

    /** Nom d'affichage de l'espèce. */
    private final String displayName;

    /**
     * Constructeur de l'énumération.
     * 
     * @param displayName Le nom d'affichage de l'espèce.
     */
    Species(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Retourne le nom d'affichage de l'espèce.
     * 
     * @return Le nom formaté de l'espèce.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
