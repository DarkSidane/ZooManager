package fr.zoomanager.model.user;

public enum Role {
    DIRECTEUR("Directeur"),
    SOIGNEUR("Soigneur"),
    AGENT_MENAGE("Agent de ménage");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
