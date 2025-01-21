package fr.zoomanager.model.animal;

public class Zebre extends Mammifere {
    private String stripePattern;
    private int herdSize;

    public Zebre(String name, String stripePattern, int herdSize) {
        super(name, Species.ZEBRE, false, 365);
        this.stripePattern = stripePattern;
        this.herdSize = herdSize;
    }

    @Override
    public String makeSound() {
        return "Hennissement!";
    }

    public void gallop() {
        this.hunger += 10;
        System.out.println(this.name + " galope majestueusement!");
    }

    @Override
    public void reproduce() {
        if (this.health > 70 && this.herdSize > 5) {
            System.out.println("Un nouveau zèbre est né !");
        }
    }
}
