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

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayUserStatus(User currentUser) {
        System.out.println("\n=== " + currentUser.toString() + " ===");
    }

    public void displayLoginMenu() {
        System.out.println("\n=== CONNEXION ===");
        System.out.println("1. Se connecter en tant que directeur");
        System.out.println("2. Se connecter en tant qu'employé");
        System.out.println("3. Quitter");
        System.out.print("Votre choix : ");
    }

    public void displayEmployeeLoginMenu(List<Employee> employees) {
        System.out.println("\n=== CHOIX DE L'EMPLOYÉ ===");
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            System.out.printf("%d. %s (%s)%n", i + 1, emp.getName(), 
                emp instanceof Soigneur ? "Soigneur" : "Agent de ménage");
        }
        System.out.println((employees.size() + 1) + ". Retour");
        System.out.print("Votre choix : ");
    }

    public void displayMainMenu(Role role) {
        System.out.println("\n=== MENU PRINCIPAL ===");
        if (role == Role.DIRECTEUR) {
            System.out.println("1. Gérer les enclos");
            System.out.println("2. Gérer les animaux");
            System.out.println("3. Gérer les employés");
            System.out.println("4. Voir les finances");
            System.out.println("5. Se déconnecter");
        } else if (role == Role.SOIGNEUR) {
            System.out.println("1. Voir les animaux");
            System.out.println("2. Nourrir un animal");
            System.out.println("3. Soigner un animal");
            System.out.println("4. Se déconnecter");
        } else if (role == Role.AGENT_MENAGE) {
            System.out.println("1. Voir les enclos");
            System.out.println("2. Nettoyer un enclos");
            System.out.println("3. Se déconnecter");
        }
        System.out.print("Votre choix : ");
    }

    public void displayEnclosMenu() {
        System.out.println("\n=== GESTION DES ENCLOS ===");
        System.out.println("1. Voir tous les enclos");
        System.out.println("2. Ajouter un enclos");
        System.out.println("3. Nettoyer un enclos");
        System.out.println("4. Retour");
        System.out.print("Votre choix : ");
    }

    public void displayAnimalMenu() {
        System.out.println("\n=== GESTION DES ANIMAUX ===");
        System.out.println("1. Voir tous les animaux");
        System.out.println("2. Ajouter un animal");
        System.out.println("3. Nourrir un animal");
        System.out.println("4. Soigner un animal");
        System.out.println("5. Retour");
        System.out.print("Votre choix : ");
    }

    public void displayEmployeeMenu() {
        System.out.println("\n=== GESTION DES EMPLOYÉS ===");
        System.out.println("1. Voir tous les employés");
        System.out.println("2. Ajouter un employé");
        System.out.println("3. Assigner un enclos");
        System.out.println("4. Retour");
        System.out.print("Votre choix : ");
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("❌ Erreur : " + message);
    }

    public void displayZooStatus(Zoo zoo) {
        System.out.println("\n=== ÉTAT DU ZOO ===");
        System.out.println("Nom : " + zoo.getName());
        System.out.println("Nombre d'enclos : " + zoo.getEnclos().size());
        System.out.println("Nombre d'employés : " + zoo.getEmployees().size());
        System.out.println("Balance : " + String.format("%.2f€", zoo.getBudget().getBalance()));
    }

    public void displayEnclosStatus(Enclos enclos) {
        System.out.println("\n" + enclos.getStatus());
        System.out.println("Animaux présents :");
        for (Animal animal : enclos.getAnimals()) {
            System.out.println("- " + animal.getStatus());
        }
    }

    public void displayAllEnclos(Zoo zoo) {
        System.out.println("\n=== LISTE DES ENCLOS ===");
        for (int i = 0; i < zoo.getEnclos().size(); i++) {
            System.out.printf("%d. %s%n", i + 1, zoo.getEnclos().get(i).getStatus());
        }
    }

    public void displayAllEmployees(Zoo zoo) {
        System.out.println("\n=== LISTE DES EMPLOYÉS ===");
        for (int i = 0; i < zoo.getEmployees().size(); i++) {
            Employee emp = zoo.getEmployees().get(i);
            System.out.printf("%d. %s (Salaire: %.2f€)%n", i + 1, emp.getName(), emp.getSalary());
        }
    }
}
