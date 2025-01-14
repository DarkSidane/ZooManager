package fr.zoomanager.model.animal;

public class Lion extends Mammifere {
    private int prideSize;
    private boolean isAlpha;

    public Lion(String name, int prideSize, boolean isAlpha) {
        super(name, Species.LION, true, 110);
        this.prideSize = prideSize;
        this.isAlpha = isAlpha;
    }

    @Override
    public String makeSound() {
        return "ROAAAR!";
    }

    public void hunt() {
        this.hunger = Math.max(0, this.hunger - 70);
    }

    @Override
    public void reproduce() {
        if (this.health > 80 && this.isAlpha) {
            System.out.println("Un nouveau lionceau est né !");
        }
    }

    @Override
    public String getStatus() {
        return super.getStatus() + String.format(", Alpha: %s, Taille du groupe: %d", 
            this.isAlpha ? "Oui" : "Non", this.prideSize);
    }
}
