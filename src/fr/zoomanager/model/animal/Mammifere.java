package fr.zoomanager.model.animal;

public abstract class Mammifere extends Animal {
    protected boolean isNocturnal;
    protected int gestationPeriod;

    public Mammifere(String name, Species species, boolean isNocturnal, int gestationPeriod) {
        super(name, species);
        this.isNocturnal = isNocturnal;
        this.gestationPeriod = gestationPeriod;
    }

    public abstract void reproduce();
}
