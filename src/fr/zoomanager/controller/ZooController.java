package fr.zoomanager.controller;

import fr.zoomanager.model.Zoo;
import fr.zoomanager.model.animal.*;
import fr.zoomanager.model.employee.*;
import fr.zoomanager.model.enclos.Enclos;
import fr.zoomanager.model.financial.*;
import fr.zoomanager.view.ConsoleView;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

public class ZooController {
    private Zoo zoo;
    private ConsoleView view;
    private boolean running;

    public ZooController(Zoo zoo, ConsoleView view) {
        this.zoo = zoo;
        this.view = view;
        this.running = true;
        initializeZoo();
    }

    private void initializeZoo() {
        // Création des enclos initiaux
        Enclos savane = new Enclos("Savane", 5);
        Enclos voliere = new Enclos("Volière", 3);
        
        // Création des animaux initiaux
        Lion simba = new Lion("Simba", 4, true);
        Zebre marty = new Zebre("Marty", "Classique", 6);
        Pelican rico = new Pelican("Rico", 2.5, 0.3, 2.0);
        FlamantRose flamby = new FlamantRose("Flamby", 1.8, "Rose vif");
        
        // Ajout des animaux aux enclos
        savane.addAnimal(simba);
        savane.addAnimal(marty);
        voliere.addAnimal(rico);
        voliere.addAnimal(flamby);
        
        // Création des employés
        Soigneur soigneur = new Soigneur("Alice", 2000);
        soigneur.addSpecialty(Species.LION);
        soigneur.addSpecialty(Species.ZEBRE);
        
        Gardien gardien = new Gardien("Bob", 1800);
        gardien.assignEnclos(savane);
        gardien.assignEnclos(voliere);
        
        // Ajout au zoo
        zoo.addEnclos(savane);
        zoo.addEnclos(voliere);
        zoo.addEmployee(soigneur);
        zoo.addEmployee(gardien);
        
        // Ajout d'un budget initial
        zoo.getBudget().addTransaction(
            new Transaction(10000, "Budget initial", TransactionType.INCOME)
        );
    }

    public void start() {
        while (running) {
            zoo.updateState();
            view.displayZooStatus(zoo);
            view.displayMainMenu();
            processMainMenuChoice(view.getUserInput());
        }
    }

    private void processMainMenuChoice(String choice) {
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
                running = false;
                view.displayMessage("Au revoir !");
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
	    // Affichage du menu de sélection de l'enclos
	    view.displayAllEnclos(zoo);
	    view.displayMessage("Dans quel enclos voulez-vous ajouter l'animal ? (numéro) : ");
	    
	    try {
		int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
		if (enclosIndex < 0 || enclosIndex >= zoo.getEnclos().size()) {
		    view.displayError("Numéro d'enclos invalide");
		    return;
		}
		
		Enclos selectedEnclos = zoo.getEnclos().get(enclosIndex);
		
		// Menu de sélection du type d'animal
		view.displayMessage("Type d'animal (1: Lion, 2: Zèbre, 3: Pélican, 4: Flamant Rose) : ");
		String typeChoice = view.getUserInput();
		
		view.displayMessage("Nom de l'animal : ");
		String name = view.getUserInput();
		
		Animal newAnimal = null;
		
		switch (typeChoice) {
		    case "1": // Lion
			view.displayMessage("Taille du groupe : ");
			int prideSize = Integer.parseInt(view.getUserInput());
			view.displayMessage("Est-il l'alpha ? (oui/non) : ");
			boolean isAlpha = view.getUserInput().toLowerCase().equals("oui");
			newAnimal = new Lion(name, prideSize, isAlpha);
			break;
			
		    case "2": // Zèbre
			view.displayMessage("Type de rayures : ");
			String stripePattern = view.getUserInput();
			view.displayMessage("Taille du troupeau : ");
			int herdSize = Integer.parseInt(view.getUserInput());
			newAnimal = new Zebre(name, stripePattern, herdSize);
			break;
			
		    case "3": // Pélican
			view.displayMessage("Envergure (en mètres) : ");
			double wingspan = Double.parseDouble(view.getUserInput());
			view.displayMessage("Taille du bec (en mètres) : ");
			double beakSize = Double.parseDouble(view.getUserInput());
			view.displayMessage("Capacité de la poche (en litres) : ");
			double pouchCapacity = Double.parseDouble(view.getUserInput());
			newAnimal = new Pelican(name, wingspan, beakSize, pouchCapacity);
			break;
			
		    case "4": // Flamant Rose
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
			new Transaction(-1000, "Acquisition: " + newAnimal.getName(), TransactionType.EXPENSE)
		    );
		    view.displayMessage("Animal ajouté avec succès !");
		}
		
	    } catch (NumberFormatException e) {
		view.displayError("Valeur numérique invalide");
	    }
	}

	private void feedAnimal() {
	    // Sélection de l'enclos
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
		    
		    // Affichage des animaux de l'enclos
		    for (int i = 0; i < animals.size(); i++) {
			view.displayMessage((i + 1) + ". " + animals.get(i).getStatus());
		    }
		    
		    view.displayMessage("Numéro de l'animal à nourrir : ");
		    int animalIndex = Integer.parseInt(view.getUserInput()) - 1;
		    
		    if (animalIndex >= 0 && animalIndex < animals.size()) {
			Animal animal = animals.get(animalIndex);
			animal.feed();
			zoo.getBudget().addTransaction(
			    new Transaction(-50, "Nourriture pour " + animal.getName(), TransactionType.EXPENSE)
			);
			view.displayMessage(animal.getName() + " a été nourri !");
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
	    // Vérification qu'il y a des soigneurs disponibles
	    List<Soigneur> soigneurs = zoo.getEmployees().stream()
		.filter(emp -> emp instanceof Soigneur)
		.map(emp -> (Soigneur) emp)
		.collect(Collectors.toList());
		
	    if (soigneurs.isEmpty()) {
		view.displayError("Aucun soigneur disponible pour effectuer les soins");
		return;
	    }
	    
	    // Sélection de l'enclos
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
		    
		    // Affichage des animaux de l'enclos
		    for (int i = 0; i < animals.size(); i++) {
			view.displayMessage((i + 1) + ". " + animals.get(i).getStatus());
		    }
		    
		    view.displayMessage("Numéro de l'animal à soigner : ");
		    int animalIndex = Integer.parseInt(view.getUserInput()) - 1;
		    
		    if (animalIndex >= 0 && animalIndex < animals.size()) {
			Animal animal = animals.get(animalIndex);
			
			// Recherche d'un soigneur qualifié
			Optional<Soigneur> qualifiedSoigneur = soigneurs.stream()
			    .filter(s -> s.getSpecialties().contains(animal.getSpecies()))
			    .findFirst();
			
			if (qualifiedSoigneur.isPresent()) {
			    Soigneur soigneur = qualifiedSoigneur.get();
			    soigneur.healAnimal(animal);
			    zoo.getBudget().addTransaction(
				new Transaction(-200, "Soins médicaux pour " + animal.getName(), 
				TransactionType.EXPENSE)
			    );
			    view.displayMessage(animal.getName() + " a été soigné par " + soigneur.getName() + " !");
			} else {
			    view.displayError("Aucun soigneur qualifié pour cette espèce");
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
        view.displayMessage("Type d'employé (1: Soigneur, 2: Gardien) : ");
        String type = view.getUserInput();
        view.displayMessage("Nom : ");
        String name = view.getUserInput();
        view.displayMessage("Salaire : ");
        
        try {
            double salary = Double.parseDouble(view.getUserInput());
            Employee newEmployee;
            
            switch (type) {
                case "1":
                    newEmployee = new Soigneur(name, salary);
                    break;
                case "2":
                    newEmployee = new Gardien(name, salary);
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
        view.displayAllEmployees(zoo);
        view.displayMessage("Numéro de l'employé : ");
        
        try {
            int empIndex = Integer.parseInt(view.getUserInput()) - 1;
            if (empIndex >= 0 && empIndex < zoo.getEmployees().size()) {
                Employee emp = zoo.getEmployees().get(empIndex);
                if (emp instanceof Gardien) {
                    Gardien gardien = (Gardien) emp;
                    view.displayAllEnclos(zoo);
                    view.displayMessage("Numéro de l'enclos à assigner : ");
                    
                    int enclosIndex = Integer.parseInt(view.getUserInput()) - 1;
                    if (enclosIndex >= 0 && enclosIndex < zoo.getEnclos().size()) {
                        Enclos enclos = zoo.getEnclos().get(enclosIndex);
                        gardien.assignEnclos(enclos);
                        view.displayMessage("Enclos assigné avec succès !");
                    } else {
                        view.displayError("Numéro d'enclos invalide");
                    }
                } else {
                    view.displayError("Cet employé n'est pas un gardien");
                }
            } else {
                view.displayError("Numéro d'employé invalide");
            }
        } catch (NumberFormatException e) {
            view.displayError("Numéro invalide");
        }
    }
}
