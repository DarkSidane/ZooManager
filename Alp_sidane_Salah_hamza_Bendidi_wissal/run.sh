#!/bin/bash

# Création du dossier temporaire pour les fichiers avec JavaDoc
mkdir -p temp_src
cp -r src/* temp_src/

# Ajout des commentaires JavaDoc pour le package fr.zoomanager
cat > temp_src/fr/zoomanager/package-info.java << 'EOL'
/**
 * Package principal de l'application ZooManager.
 * Contient l'architecture MVC et la gestion complète d'un zoo.
 */
package fr.zoomanager;
EOL

# Ajout des commentaires JavaDoc pour Main.java
cat > temp_src/fr/zoomanager/Main.java << 'EOL'
package fr.zoomanager;

import fr.zoomanager.controller.ZooController;
import fr.zoomanager.model.Zoo;
import fr.zoomanager.view.ConsoleView;

/**
 * Classe principale de l'application ZooManager.
 * Initialise et lance l'application en créant les instances nécessaires
 * du modèle, de la vue et du contrôleur.
 */
public class Main {
    /**
     * Point d'entrée de l'application.
     * Crée une instance de Zoo, ConsoleView et ZooController, puis lance l'application.
     *
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        ConsoleView view = new ConsoleView();
        ZooController controller = new ZooController(zoo, view);
        controller.start();
    }
}
EOL

# Ajout des commentaires JavaDoc pour le modèle Animal
cat > temp_src/fr/zoomanager/model/animal/Animal.java << 'EOL'
package fr.zoomanager.model.animal;

/**
 * Classe abstraite représentant un animal du zoo.
 * Définit les attributs et comportements communs à tous les animaux.
 */
public abstract class Animal {
    /**
     * Le nom de l'animal.
     */
    protected String name;
    
    /**
     * La santé de l'animal (entre 0 et 100).
     */
    protected double health;
    
    /**
     * Le niveau de faim de l'animal (entre 0 et 100).
     */
    protected double hunger;
    
    /**
     * L'espèce de l'animal.
     */
    protected Species species;

    /**
     * Construit un nouvel animal.
     * @param name Le nom de l'animal
     * @param species L'espèce de l'animal
     */
    public Animal(String name, Species species) {
        this.name = name;
        this.health = 100.0;
        this.hunger = 0.0;
        this.species = species;
    }

    /**
     * Nourrit l'animal, réduisant son niveau de faim.
     */
    public void feed() {
        this.hunger = Math.max(0, this.hunger - 50);
    }

    /**
     * Soigne l'animal, augmentant sa santé.
     */
    public void heal() {
        this.health = Math.min(100, this.health + 20);
    }

    // ... [reste du code]
}
EOL

# Ajout des commentaires JavaDoc pour le modèle Mammifere
cat > temp_src/fr/zoomanager/model/animal/Mammifere.java << 'EOL'
package fr.zoomanager.model.animal;

/**
 * Classe abstraite représentant un mammifère.
 * Étend la classe Animal avec des caractéristiques spécifiques aux mammifères.
 */
public abstract class Mammifere extends Animal {
    /**
     * Indique si le mammifère est nocturne.
     */
    protected boolean isNocturnal;
    
    /**
     * Période de gestation en jours.
     */
    protected int gestationPeriod;

    /**
     * Construit un nouveau mammifère.
     * @param name Le nom du mammifère
     * @param species L'espèce du mammifère
     * @param isNocturnal Indique si le mammifère est nocturne
     * @param gestationPeriod La période de gestation en jours
     */
    public Mammifere(String name, Species species, boolean isNocturnal, int gestationPeriod) {
        super(name, species);
        this.isNocturnal = isNocturnal;
        this.gestationPeriod = gestationPeriod;
    }

    /**
     * Méthode abstraite pour la reproduction.
     * Doit être implémentée par les classes concrètes.
     */
    public abstract void reproduce();
}
EOL

# Ajout des commentaires JavaDoc pour la vue ConsoleView
cat > temp_src/fr/zoomanager/view/ConsoleView.java << 'EOL'
package fr.zoomanager.view;

import fr.zoomanager.model.Zoo;
import fr.zoomanager.model.animal.Animal;
import fr.zoomanager.model.employee.Employee;
import fr.zoomanager.model.employee.Soigneur;
import fr.zoomanager.model.enclos.Enclos;
import fr.zoomanager.model.user.Role;
import fr.zoomanager.model.user.User;
import java.util.Scanner;
import java.util.List;

/**
 * Classe gérant l'interface utilisateur en ligne de commande.
 * Affiche les menus et les informations du zoo avec une mise en forme colorée.
 */
public class ConsoleView {
    // ... [reste du code]
}
EOL

# Génération de la JavaDoc
echo "Génération de la documentation JavaDoc..."
javadoc -d doc -sourcepath temp_src -subpackages fr.zoomanager

# Nettoyage
rm -rf temp_src

echo "✅ Documentation JavaDoc générée dans le dossier 'doc'"
echo "Ouvrez doc/index.html dans votre navigateur pour consulter la documentation"
