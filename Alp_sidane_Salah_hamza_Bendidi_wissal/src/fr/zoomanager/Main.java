package fr.zoomanager;

import fr.zoomanager.controller.ZooController;
import fr.zoomanager.model.Zoo;
import fr.zoomanager.view.ConsoleView;

/**
 * Point d'entrée principal de l'application ZooManager.
 * Cette classe initialise les composants principaux (modèle, vue, contrôleur)
 * et démarre l'application.
 * 
 * @author Votre équipe
 * @version 1.0
 */
public class Main {
    /**
     * Méthode principale qui démarre l'application.
     * Initialise le modèle (Zoo), la vue (ConsoleView) et le contrôleur (ZooController),
     * puis lance l'application en appelant la méthode `start()` du contrôleur.
     * 
     * @param args Arguments de la ligne de commande (non utilisés dans cette application)
     */
    public static void main(String[] args) {
        // Initialisation du modèle (Zoo)
        Zoo zoo = new Zoo();
        
        // Initialisation de la vue (ConsoleView)
        ConsoleView view = new ConsoleView();
        
        // Initialisation du contrôleur (ZooController)
        ZooController controller = new ZooController(zoo, view);
        
        // Démarrage de l'application
        controller.start();
    }
}
