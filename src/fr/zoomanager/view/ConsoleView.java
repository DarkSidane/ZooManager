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
 * Interface utilisateur en ligne de commande du zoo.
 * Gère l'affichage des menus et l'interaction avec l'utilisateur.
 * Utilise des codes ANSI pour la coloration et des émojis pour une meilleure lisibilité.
 *
 * @see Role
 * @see Zoo
 */
public class ConsoleView {
    /** Scanner pour la lecture des entrées utilisateur */
    private Scanner scanner;

    // Codes couleur ANSI
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";

    /**
     * Constructeur initialisant le scanner d'entrée.
     */
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche l'utilisateur actuellement connecté.
     *
     * @param currentUser L'utilisateur connecté
     */
    public void displayUserStatus(User currentUser) {
        String roleEmoji = getRoleEmoji(currentUser.getRole());
        System.out.println("\n" + BOLD + BLUE + "=== " + roleEmoji + " " +
            currentUser.toString() + " ===" + RESET);
    }

    /**
     * Retourne l'émoji correspondant au rôle.
     *
     * @param role Le rôle de l'utilisateur
     * @return L'émoji correspondant
     */
    private String getRoleEmoji(Role role) {
        switch (role) {
            case DIRECTEUR: return "👨‍💼";
            case SOIGNEUR: return "👨‍⚕️";
            case AGENT_MENAGE: return "🧹";
            default: return "👤";
        }
    }

    /**
     * Affiche le menu de connexion.
     */
    public void displayLoginMenu() {
        System.out.println("\n" + BOLD + PURPLE + "=== 🔑 CONNEXION ===" + RESET);
        System.out.println(CYAN + "1. 👨‍💼 Se connecter en tant que directeur");
        System.out.println("2. 👤 Se connecter en tant qu'employé");
        System.out.println("3. 🚪 Quitter" + RESET);
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Affiche le menu de connexion pour les employés.
     *
     * @param employees La liste des employés
     */
    public void displayEmployeeLoginMenu(List<Employee> employees) {
        System.out.println("\n" + BOLD + PURPLE + "=== 👥 CHOIX DE L'EMPLOYÉ ===" + RESET);
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            String emoji = emp instanceof Soigneur ? "👨‍⚕️" : "🧹";
            System.out.printf(CYAN + "%d. %s %s (%s)%n" + RESET,
                i + 1, emoji, emp.getName(),
                emp instanceof Soigneur ? "Soigneur" : "Agent de ménage");
        }
        System.out.println(CYAN + (employees.size() + 1) + ". ↩️ Retour" + RESET);
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Affiche le menu principal en fonction du rôle de l'utilisateur.
     *
     * @param role Le rôle de l'utilisateur
     */
    public void displayMainMenu(Role role) {
        String menuTitle = "";
        switch (role) {
            case DIRECTEUR:
                menuTitle = "👨‍💼 MENU DIRECTEUR";
                break;
            case SOIGNEUR:
                menuTitle = "👨‍⚕️ MENU SOIGNEUR";
                break;
            case AGENT_MENAGE:
                menuTitle = "🧹 MENU AGENT DE MÉNAGE";
                break;
        }

        System.out.println("\n" + BOLD + BLUE + "=== " + menuTitle + " ===" + RESET);
        if (role == Role.DIRECTEUR) {
            System.out.println(CYAN + "1. 🏠 Gérer les enclos");
            System.out.println("2. 🦁 Gérer les animaux");
            System.out.println("3. 👥 Gérer les employés");
            System.out.println("4. 💰 Voir les finances");
            System.out.println("5. 🚪 Se déconnecter" + RESET);
        } else if (role == Role.SOIGNEUR) {
            System.out.println(CYAN + "1. 👁️ Voir les animaux");
            System.out.println("2. 🍽️ Nourrir un animal");
            System.out.println("3. 💊 Soigner un animal");
            System.out.println("4. 🚪 Se déconnecter" + RESET);
        } else if (role == Role.AGENT_MENAGE) {
            System.out.println(CYAN + "1. 👁️ Voir les enclos");
            System.out.println("2. 🧹 Nettoyer un enclos");
            System.out.println("3. 🚪 Se déconnecter" + RESET);
        }
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Affiche le menu de gestion des enclos.
     */
    public void displayEnclosMenu() {
        System.out.println("\n" + BOLD + YELLOW + "=== 🏠 GESTION DES ENCLOS ===" + RESET);
        System.out.println(CYAN + "1. 👁️ Voir tous les enclos");
        System.out.println("2. ➕ Ajouter un enclos");
        System.out.println("3. 🧹 Nettoyer un enclos");
        System.out.println("4. ↩️ Retour" + RESET);
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Affiche le menu de gestion des animaux.
     */
    public void displayAnimalMenu() {
        System.out.println("\n" + BOLD + YELLOW + "=== 🦁 GESTION DES ANIMAUX ===" + RESET);
        System.out.println(CYAN + "1. 👁️ Voir tous les animaux");
        System.out.println("2. ➕ Ajouter un animal");
        System.out.println("3. 🍽️ Nourrir un animal");
        System.out.println("4. 💊 Soigner un animal");
        System.out.println("5. ↩️ Retour" + RESET);
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Affiche le menu de gestion des employés.
     */
    public void displayEmployeeMenu() {
        System.out.println("\n" + BOLD + YELLOW + "=== 👥 GESTION DES EMPLOYÉS ===" + RESET);
        System.out.println(CYAN + "1. 👁️ Voir tous les employés");
        System.out.println("2. ➕ Ajouter un employé");
        System.out.println("3. 🔄 Assigner un enclos");
        System.out.println("4. ↩️ Retour" + RESET);
        System.out.print(BOLD + "Votre choix : " + RESET);
    }

    /**
     * Récupère l'entrée utilisateur.
     *
     * @return L'entrée nettoyée des espaces inutiles
     */
    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Affiche un message de succès.
     *
     * @param message Le message à afficher en vert
     */
    public void displayMessage(String message) {
        System.out.println(GREEN + "✅ " + message + RESET);
    }

    /**
     * Affiche un message d'erreur.
     *
     * @param message Le message à afficher en rouge
     */
    public void displayError(String message) {
        System.out.println(RED + "❌ Erreur : " + message + RESET);
    }

    /**
     * Affiche l'état du zoo.
     *
     * @param zoo Le zoo
     */
    public void displayZooStatus(Zoo zoo) {
        System.out.println("\n" + BOLD + BLUE + "=== 🏰 ÉTAT DU ZOO ===" + RESET);
        System.out.println(YELLOW + "🏷️ Nom : " + RESET + zoo.getName());
        System.out.println(YELLOW + "🏠 Nombre d'enclos : " + RESET + zoo.getEnclos().size());
        System.out.println(YELLOW + "👥 Nombre d'employés : " + RESET + zoo.getEmployees().size());
        System.out.println(YELLOW + "💰 Balance : " + RESET +
            String.format("%.2f€", zoo.getBudget().getBalance()));
    }

    /**
     * Affiche l'état d'un enclos.
     *
     * @param enclos L'enclos
     */
    public void displayEnclosStatus(Enclos enclos) {
        System.out.println("\n" + GREEN + enclos.getStatus() + RESET);
        System.out.println(BOLD + "🦁 Animaux présents :" + RESET);
        for (Animal animal : enclos.getAnimals()) {
            displayAnimalStatus(animal);
        }
    }

    /**
     * Affiche l'état d'un animal.
     *
     * @param animal L'animal
     */
    private void displayAnimalStatus(Animal animal) {
        String healthEmoji = getHealthEmoji(animal.getHealth());
        String hungerEmoji = getHungerEmoji(animal.getHunger());
        System.out.println(CYAN + "- " + healthEmoji + " " + hungerEmoji + " " +
            animal.getStatus() + RESET);
    }

    /**
     * Retourne l'émoji correspondant à la santé de l'animal.
     *
     * @param health La santé de l'animal
     * @return L'émoji correspondant
     */
    private String getHealthEmoji(double health) {
        if (health > 80) return "💚";
        if (health > 50) return "💛";
        if (health > 20) return "🧡";
        return "❤️";
    }

    /**
     * Retourne l'émoji correspondant à la faim de l'animal.
     *
     * @param hunger La faim de l'animal
     * @return L'émoji correspondant
     */
    private String getHungerEmoji(double hunger) {
        if (hunger < 20) return "😊";
        if (hunger < 50) return "😐";
        if (hunger < 80) return "😟";
        return "😫";
    }

    /**
     * Affiche tous les enclos du zoo.
     *
     * @param zoo Le zoo
     */
    public void displayAllEnclos(Zoo zoo) {
        System.out.println("\n" + BOLD + BLUE + "=== 🏠 LISTE DES ENCLOS ===" + RESET);
        for (int i = 0; i < zoo.getEnclos().size(); i++) {
            Enclos enclos = zoo.getEnclos().get(i);
            String cleanlinessEmoji = getCleanlinessEmoji(enclos.getCleanliness());
            System.out.printf(CYAN + "%d. %s %s%n" + RESET,
                i + 1, cleanlinessEmoji, enclos.getStatus());
        }
    }

    /**
     * Retourne l'émoji correspondant à la propreté de l'enclos.
     *
     * @param cleanliness La propreté de l'enclos
     * @return L'émoji correspondant
     */
    private String getCleanlinessEmoji(double cleanliness) {
        if (cleanliness > 80) return "✨";
        if (cleanliness > 50) return "🌟";
        if (cleanliness > 20) return "😬";
        return "🗑️";
    }

    /**
     * Affiche tous les employés du zoo.
     *
     * @param zoo Le zoo
     */
    public void displayAllEmployees(Zoo zoo) {
        System.out.println("\n" + BOLD + BLUE + "=== 👥 LISTE DES EMPLOYÉS ===" + RESET);
        for (int i = 0; i < zoo.getEmployees().size(); i++) {
            Employee emp = zoo.getEmployees().get(i);
            String roleEmoji = emp instanceof Soigneur ? "👨‍⚕️" : "🧹";
            System.out.printf(CYAN + "%d. %s %s (Salaire: %.2f€)%n" + RESET,
                i + 1, roleEmoji, emp.getName(), emp.getSalary());
        }
    }
}
