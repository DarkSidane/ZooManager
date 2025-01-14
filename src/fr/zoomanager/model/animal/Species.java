package fr.zoomanager.model.animal;

public enum Species {
    LION("Lion"),
    ZEBRE("Zèbre"),
    PELICAN("Pélican"),
    FLAMANT_ROSE("Flamant Rose");

    private final String displayName;

    Species(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
