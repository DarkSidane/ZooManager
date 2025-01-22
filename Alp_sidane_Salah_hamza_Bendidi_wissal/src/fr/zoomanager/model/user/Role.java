package fr.zoomanager.model.user;

/**
 * Énumération représentant les différents rôles des utilisateurs dans le zoo.
 * Chaque rôle possède un nom d'affichage personnalisé pour une meilleure lisibilité.
 * 
 * @see User
 */
public enum Role {
    /** Rôle du directeur du zoo. */
    DIRECTEUR("Directeur"),
    
    /** Rôle du soigneur, responsable des animaux. */
    SOIGNEUR("Soigneur"),
    
    /** Rôle de l'agent de ménage, responsable de l'entretien des enclos. */
    AGENT_MENAGE("Agent de ménage");

    /** Nom d'affichage du rôle. */
    private final String displayName;

    /**
     * Constructeur de l'énumération.
     * 
     * @param displayName Le nom d'affichage du rôle.
     */
    Role(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Retourne le nom d'affichage du rôle.
     * 
     * @return Le nom formaté du rôle.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
