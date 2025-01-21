package fr.zoomanager.model.animal;

public class FlamantRose extends Oiseau {
    private String plumageColor;
    private int balanceTime;

    public FlamantRose(String name, double wingspan, String plumageColor) {
        super(name, Species.FLAMANT_ROSE, wingspan, true);
        this.plumageColor = plumageColor;
        this.balanceTime = 0;
    }

    @Override
    public String makeSound() {
        return "Honk honk!";
    }

    public void standOneLeg() {
        this.balanceTime++;
        System.out.println(this.name + " se tient sur une patte depuis " + balanceTime + " minutes!");
    }

    public void filter() {
        this.hunger = Math.max(0, this.hunger - 30);
        System.out.println(this.name + " filtre l'eau pour se nourrir!");
    }
}
