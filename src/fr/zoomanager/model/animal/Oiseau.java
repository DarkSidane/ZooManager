package fr.zoomanager.model.animal;

public abstract class Oiseau extends Animal {
    protected double wingspan;
    protected boolean canFly;

    public Oiseau(String name, Species species, double wingspan, boolean canFly) {
        super(name, species);
        this.wingspan = wingspan;
        this.canFly = canFly;
    }

    public void fly() {
        if (canFly && health > 50) {
            System.out.println(name + " s'envole gracieusement !");
            this.hunger += 5;
        }
    }
}
