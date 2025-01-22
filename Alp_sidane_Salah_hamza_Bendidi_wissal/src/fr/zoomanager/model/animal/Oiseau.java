package fr.zoomanager.model.animal;

/**
 * Classe abstraite représentant un oiseau dans le zoo.
 * Les oiseaux sont caractérisés par leur envergure et leur capacité à voler.
 * Cette classe étend la classe {@link Animal} en ajoutant des attributs et des comportements spécifiques aux oiseaux.
 */
public abstract class Oiseau extends Animal {
    /** Envergure des ailes de l'oiseau en mètres. */
    protected double wingspan;
    
    /** Indique si l'oiseau est capable de voler. */
    protected boolean canFly;

    /**
     * Constructeur d'un oiseau.
     * 
     * @param name Le nom de l'oiseau.
     * @param species L'espèce de l'oiseau.
     * @param wingspan L'envergure des ailes en mètres.
     * @param canFly Indique si l'oiseau est capable de voler.
     */
    public Oiseau(String name, Species species, double wingspan, boolean canFly) {
        super(name, species);
        this.wingspan = wingspan;
        this.canFly = canFly;
    }

    /**
     * Fait voler l'oiseau s'il en est capable et a suffisamment de santé.
     * Le vol augmente légèrement la faim de l'oiseau.
     * Si l'oiseau ne peut pas voler ou n'a pas assez de santé, rien ne se passe.
     */
    public void fly() {
        if (canFly && health > 50) {
            System.out.println(name + " s'envole gracieusement !");
            this.hunger += 5;
        }
    }
}
