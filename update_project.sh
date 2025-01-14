#!/bin/bash

# Assurez-vous que le dossier existe
mkdir -p src/fr/zoomanager/controller

# Création de ZooController.java avec son contenu complet
cat > "src/fr/zoomanager/controller/ZooController.java" << 'EOL'
package fr.zoomanager.controller;

import fr.zoomanager.model.Zoo;
import fr.zoomanager.model.animal.*;
import fr.zoomanager.model.employee.*;
import fr.zoomanager.model.enclos.Enclos;
import fr.zoomanager.model.financial.*;
import fr.zoomanager.model.user.*;
import fr.zoomanager.view.ConsoleView;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

public class ZooController {
    private Zoo zoo;
    private ConsoleView view;
    private boolean running;
    private User currentUser;

    public ZooController(Zoo zoo, ConsoleView view) {
        this.zoo = zoo;
        this.view = view;
        this.running = true;
        initializeZoo();
    }

    private void initializeZoo() {
        Enclos savane = new Enclos("Savane", 5);
        Enclos voliere = new Enclos("Volière", 3);
        
        Lion simba = new Lion("Simba", 4, true);
        Zebre marty = new Zebre("Marty", "Classique", 6);
        Pelican rico = new Pelican("Rico", 2.5, 0.3, 2.0);
        FlamantRose flamby = new FlamantRose("Flamby", 1.8, "Rose vif");
        
        savane.addAnimal(simba);
        savane.addAnimal(marty);
        voliere.addAnimal(rico);
        voliere.addAnimal(flamby);
        
        Soigneur soigneur = new Soigneur("Alice", 2000);
        soigneur.addSpecialty(Species.LION);
        soigneur.addSpecialty(Species.ZEBRE);
        
        AgentMenage agentMenage = new AgentMenage("Bob", 1800);
        agentMenage.assignEnclos(savane);
        agentMenage.assignEnclos(voliere);
        
        zoo.addEnclos(savane);
        zoo.addEnclos(voliere);
        zoo.addEmployee(soigneur);
        zoo.addEmployee(agentMenage);
        
        zoo.getBudget().addTransaction(
            new Transaction(10000, "Budget initial", TransactionType.INCOME)
        );
    }

    public void start() {
        while (running) {
            if (currentUser == null) {
                handleLogin();
            } else {
                zoo.updateState();
                view.displayUserStatus(currentUser);
                view.displayMainMenu(currentUser.getRole());
                processMainMenuChoice(view.getUserInput());
            }
        }
    }

    private void handleLogin() {
        view.displayLoginMenu();
        String choice = view.getUserInput();
        
        switch (choice) {
            case "1":
                currentUser = new User(new Employee("Directeur", 5000) {
                    @Override
                    public void work() {}
                }, Role.DIRECTEUR);
                break;
            case "2":
                handleEmployeeLogin();
                break;
            case "3":
                running = false;
                view.displayMessage("Au revoir !");
                break;
            default:
                view.displayError("Choix invalide");
        }
    }

    private void handleEmployeeLogin() {
        view.displayEmployeeLoginMenu(zoo.getEmployees());
        try {
            int choice = Integer.parseInt(view.getUserInput()) - 1;
            if (choice >= 0 && choice < zoo.getEmployees().size()) {
                Employee emp = zoo.getEmployees().get(choice);
                Role role = (emp instanceof Soigneur) ? Role.SOIGNEUR : Role.AGENT_MENAGE;
                currentUser = new User(emp, role);
            } else if (choice == zoo.getEmployees().size()) {
                return;
            } else {
                view.displayError("Choix invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }

    private void processMainMenuChoice(String choice) {
        switch (currentUser.getRole()) {
            case DIRECTEUR:
                processDirecteurChoice(choice);
                break;
            case SOIGNEUR:
                processSoigneurChoice(choice);
                break;
            case AGENT_MENAGE:
                processAgentMenageChoice(choice);
                break;
        }
    }

    private void processDirecteurChoice(String choice) {
        switch (choice) {
            case "1":
                handleEnclosMenu();
                break;
            case "2":
                handleAnimalMenu();
                break;
            case "3":
                handleEmployeeMenu();
                break;
            case "4":
                view.displayMessage(zoo.getBudget().generateReport());
                break;
            case "5":
                currentUser = null;
                break;
            default:
                view.displayError("Choix invalide");
        }
    }

    private void processSoigneurChoice(String choice) {
        switch (choice) {
            case "1":
                displayAllAnimals();
                break;
            case "2":
                feedAnimal();
                break;
            case "3":
                healAnimal();
                break;
            case "4":
                currentUser = null;
                break;
            default:
                view.displayError("Choix invalide");
        }
    }

    private void processAgentMenageChoice(String choice) {
        switch (choice) {
            case "1":
                view.displayAllEnclos(zoo);
                break;
            case "2":
                cleanEnclos();
                break;
            case "3":
                currentUser = null;
                break;
            default:
                view.displayError("Choix invalide");
        }
    }

    private void handleEnclosMenu() {
        boolean enclosMenuRunning = true;
        while (enclosMenuRunning) {
            view.displayEnclosMenu();
            String choice = view.getUserInput();
            switch (choice) {
                case "1":
                    view.displayAllEnclos(zoo);
                    break;
                case "2":
                    createNewEnclos();
                    break;
                case "3":
                    cleanEnclos();
                    break;
                case "4":
                    enclosMenuRunning = false;
                    break;
                default:
                    view.displayError("Choix invalide");
            }
        }
    }

    private void createNewEnclos() {
        view.displayMessage("Nom de l'enclos : ");
        String name = view.getUserInput();
        view.displayMessage("Capacité : ");
        try {
            int capacity = Integer.parseInt(view.getUserInput());
            Enclos newEnclos = new Enclos(name, capacity);
            zoo.addEnclos(newEnclos);
            zoo.getBudget().addTransaction(
                new Transaction(-5000, "Construction enclos: " + name, TransactionType.EXPENSE)
            );
            view.displayMessage("Enclos créé avec succès !");
        } catch (NumberFormatException e) {
            view.displayError("Capacité invalide");
        }
    }

    private void cleanEnclos() {
        if (currentUser.getRole() != Role.AGENT_MENAGE && currentUser.getRole() != Role.DIRECTEUR) {
            view.displayError("Vous n'avez pas les droits pour effectuer cette action");
            return;
        }

        view.displayAllEnclos(zoo);
        view.displayMessage("Numéro de l'enclos à nettoyer : ");
        try {
            int index = Integer.parseInt(view.getUserInput()) - 1;
            if (index >= 0 && index < zoo.getEnclos().size()) {
                Enclos enclos = zoo.getEnclos().get(index);
                enclos.clean();
                zoo.getBudget().addTransaction(
                    new Transaction(-100, "Nettoyage enclos: " + enclos.getName(), 
                    TransactionType.EXPENSE)
                );
                view.displayMessage("Enclos nettoyé !");
            } else {
                view.displayError("Numéro d'enclos invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }

    private void handleAnimalMenu() {
        boolean animalMenuRunning = true;
        while (animalMenuRunning) {
            view.displayAnimalMenu();
            String choice = view.getUserInput();
            switch (choice) {
                case "1":
                    displayAllAnimals();
                    break;
                case "2":
                    createNewAnimal();
                    break;
                case "3":
                    feedAnimal();
                    break;
                case "4":
                    healAnimal();
                    break;
                case "5":
                    animalMenuRunning = false;
                    break;
                default:
                    view.displayError("Choix invalide");
            }
        }
    }

    private void displayAllAnimals() {
        for (Enclos enclos : zoo.getEnclos()) {
            view.displayMessage("\nEnclos : " + enclos.getName());
            for (Animal animal : enclos.getAnimals()) {
                view.displayMessage("- " + animal.getStatus());
            }
        }
    }

    private void createNewAnimal() {
        if (currentUser.getRole() != Role.DIRECTEUR) {
            view.displayError("Seul le directeur peut ajouter des animaux");
            return;
        }

        view.displayAllEnclos(zoo);
        view.displayMessage("Dans quel enclos voulez-vous ajouter l'animal ? (numéro) : ");
        
        try {
            int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
            if (enclosIndex < 0 || enclosIndex >= zoo.getEnclos().size()) {
                view.displayError("Numéro d'enclos invalide");
                return;
            }
            
            Enclos selectedEnclos = zoo.getEnclos().get(enclosIndex);
            
            view.displayMessage("Type d'animal (1: Lion, 2: Zèbre, 3: Pélican, 4: Flamant Rose) : ");
            String typeChoice = view.getUserInput();
            
            view.displayMessage("Nom de l'animal : ");
            String name = view.getUserInput();
            
            Animal newAnimal = null;
            
            switch (typeChoice) {
                case "1":
                    view.displayMessage("Taille du groupe : ");
                    int prideSize = Integer.parseInt(view.getUserInput());
                    view.displayMessage("Est-il l'alpha ? (oui/non) : ");
                    boolean isAlpha = view.getUserInput().toLowerCase().equals("oui");
                    newAnimal = new Lion(name, prideSize, isAlpha);
                    break;
                case "2":
                    view.displayMessage("Type de rayures : ");
                    String stripePattern = view.getUserInput();
                    view.displayMessage("Taille du troupeau : ");
                    int herdSize = Integer.parseInt(view.getUserInput());
                    newAnimal = new Zebre(name, stripePattern, herdSize);
                    break;
                case "3":
                    view.displayMessage("Envergure (en mètres) : ");
                    double wingspan = Double.parseDouble(view.getUserInput());
                    view.displayMessage("Taille du bec (en mètres) : ");
                    double beakSize = Double.parseDouble(view.getUserInput());
                    view.displayMessage("Capacité de la poche (en litres) : ");
                    double pouchCapacity = Double.parseDouble(view.getUserInput());
                    newAnimal = new Pelican(name, wingspan, beakSize, pouchCapacity);
                    break;
                case "4":
                    view.displayMessage("Envergure (en mètres) : ");
                    double flamantWingspan = Double.parseDouble(view.getUserInput());
                    view.displayMessage("Couleur du plumage : ");
                    String plumageColor = view.getUserInput();
                    newAnimal = new FlamantRose(name, flamantWingspan, plumageColor);
                    break;
                default:
                    view.displayError("Type d'animal invalide");
                    return;
            }
            
            if (newAnimal != null) {
                selectedEnclos.addAnimal(newAnimal);
                zoo.getBudget().addTransaction(
                    new Transaction(-1000, "Acquisition: " + newAnimal.getName(), 
                    TransactionType.EXPENSE)
                );
                view.displayMessage("Animal ajouté avec succès !");
            }
            
        } catch (NumberFormatException e) {
            view.displayError("Valeur numérique invalide");
        }
    }

    private void feedAnimal() {
        if (!(currentUser.getEmployee() instanceof Soigneur)) {
            view.displayError("Vous devez être un soigneur pour effectuer cette action");
            return;
        }

        Soigneur soigneur = (Soigneur) currentUser.getEmployee();
        view.displayAllEnclos(zoo);
        view.displayMessage("Numéro de l'enclos contenant l'animal à nourrir : ");
        
        try {
            int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
            if (enclosIndex >= 0 && enclosIndex < zoo.getEnclos().size()) {
                Enclos selectedEnclos = zoo.getEnclos().get(enclosIndex);
                List<Animal> animals = selectedEnclos.getAnimals();
                
                if (animals.isEmpty()) {
                    view.displayMessage("Cet enclos ne contient aucun animal.");
                    return;
                }
                
                for (int i = 0; i < animals.size(); i++) {
                    view.displayMessage((i + 1) + ". " + animals.get(i).getStatus());
                }
                
                view.displayMessage("Numéro de l'animal à nourrir : ");
                int animalIndex = Integer.parseInt(view.getUserInput()) - 1;
                
                if (animalIndex >= 0 && animalIndex < animals.size()) {
                    Animal animal = animals.get(animalIndex);
                    
                    if (soigneur.getSpecialties().contains(animal.getSpecies())) {
                        soigneur.feedAnimal(animal);
                        zoo.getBudget().addTransaction(
                            new Transaction(-50, "Nourriture pour " + animal.getName(), 
                            TransactionType.EXPENSE)
                        );
                        view.displayMessage(animal.getName() + " a été nourri !");
                    } else {
                        view.displayError("Vous n'êtes pas qualifié pour nourrir cette espèce");
                    }
                } else {
                    view.displayError("Numéro d'animal invalide");
                }
            } else {
                view.displayError("Numéro d'enclos invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }

    private void healAnimal() {
        if (!(currentUser.getEmployee() instanceof Soigneur)) {
            view.displayError("Vous devez être un soigneur pour effectuer cette action");
            return;
        }

        Soigneur soigneur = (Soigneur) currentUser.getEmployee();
        view.displayAllEnclos(zoo);
        view.displayMessage("Numéro de l'enclos contenant l'animal à soigner : ");
        
        try {
            int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
            if (enclosIndex >= 0 && enclosIndex < zoo.getEnclos().size()) {
                Enclos selectedEnclos = zoo.getEnclos().get(enclosIndex);
                List<Animal> animals = selectedEnclos.getAnimals();
                
                if (animals.isEmpty()) {
                    view.displayMessage("Cet enclos ne contient aucun animal.");
                    return;
                }
                
                for (int i = 0; i < animals.size(); i++) {
                    view.displayMessage((i + 1) + ". " + animals.get(i).getStatus());
                }
                
                view.displayMessage("Numéro de l'animal à soigner : ");
                int animalIndex = Integer.parseInt(view.getUserInput()) - 1;
                
                if (animalIndex >= 0 && animalIndex < animals.size()) {
                    Animal animal = animals.get(animalIndex);
                    
                    if (soigneur.getSpecialties().contains(animal.getSpecies())) {
                        soigneur.healAnimal(animal);
                        zoo.getBudget().addTransaction(
                            new Transaction(-200, "Soins médicaux pour " + animal.getName(), 
                            TransactionType.EXPENSE)
                        );
                        view.displayMessage(animal.getName() + " a été soigné !");
                    } else {
                        view.displayError("Vous n'êtes pas qualifié pour soigner cette espèce");
                    }
                } else {
                    view.displayError("Numéro d'animal invalide");
                }
            } else {
                view.displayError("Numéro d'enclos invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }

    private void handleEmployeeMenu() {
        boolean employeeMenuRunning = true;
        while (employeeMenuRunning) {
            view.displayEmployeeMenu();
            String choice = view.getUserInput();
            switch (choice) {
                case "1":
                    view.displayAllEmployees(zoo);
                    break;
                case "2":
                    createNewEmployee();
                    break;
                case "3":
                    assignEnclosToEmployee();
                    break;
                case "4":
                    employeeMenuRunning = false;
                    break;
                default:
                    view.displayError("Choix invalide");
            }
        }
    }

    private void createNewEmployee() {
        if (currentUser.getRole() != Role.DIRECTEUR) {
            view.displayError("Seul le directeur peut créer des employés");
            return;
        }

        view.displayMessage("Type d'employé (1: Soigneur, 2: Agent de ménage) : ");
        String type = view.getUserInput();
        view.displayMessage("Nom : ");
        String name = view.getUserInput();
        view.displayMessage("Salaire : ");
        
        try {
            double salary = Double.parseDouble(view.getUserInput());
            Employee newEmployee;
            
            switch (type) {
                case "1":
                    Soigneur soigneur = new Soigneur(name, salary);
                    view.displayMessage("Spécialités (1: Lion, 2: Zèbre, 3: Pélican, 4: Flamant Rose, 0: Terminer) : ");
                    while (true) {
                        String specChoice = view.getUserInput();
                        if (specChoice.equals("0")) break;
                        switch (specChoice) {
                            case "1": soigneur.addSpecialty(Species.LION); break;
                            case "2": soigneur.addSpecialty(Species.ZEBRE); break;
                            case "3": soigneur.addSpecialty(Species.PELICAN); break;
                            case "4": soigneur.addSpecialty(Species.FLAMANT_ROSE); break;
                            default: view.displayError("Spécialité invalide");
                        }
                        view.displayMessage("Autre spécialité ? (0 pour terminer) : ");
                    }
                    newEmployee = soigneur;
                    break;
                case "2":
                    newEmployee = new AgentMenage(name, salary);
                    break;
                default:
                    view.displayError("Type d'employé invalide");
                    return;
            }
            
            zoo.addEmployee(newEmployee);
            zoo.getBudget().addTransaction(
                new Transaction(-salary, "Recrutement: " + name, TransactionType.EXPENSE)
            );
            view.displayMessage("Employé ajouté avec succès !");
            
        } catch (NumberFormatException e) {
            view.displayError("Salaire invalide");
        }
    }

    private void assignEnclosToEmployee() {
        if (currentUser.getRole() != Role.DIRECTEUR) {
            view.displayError("Seul le directeur peut assigner des enclos");
            return;
        }

        view.displayAllEmployees(zoo);
        view.displayMessage("Numéro de l'employé : ");
        
        try {
            int empIndex = Integer.parseInt(view.getUserInput()) - 1;
            if (empIndex >= 0 && empIndex < zoo.getEmployees().size()) {
                Employee emp = zoo.getEmployees().get(empIndex);
                if (emp instanceof AgentMenage) {
                    AgentMenage agentMenage = (AgentMenage) emp;
                    view.displayAllEnclos(zoo);
                    view.displayMessage("Numéro de l'enclos à assigner : ");
                    
                    int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
                    if (enclosIndex >= 0 && enclosIndex < zoo.getEnclos().size()) {
                        Enclos enclos = zoo.getEnclos().get(enclosIndex);
                        agentMenage.assignEnclos(enclos);
                        view.displayMessage("Enclos assigné avec succès !");
                    } else {
                        view.displayError("Numéro d'enclos invalide");
                    }
                } else {
                    view.displayError("Cet employé n'est pas un agent de ménage");
                }
            } else {
                view.displayError("Numéro d'employé invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }
}
EOL

echo "✅ Le fichier ZooController.java a été créé avec succès!"
