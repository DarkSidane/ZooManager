# ZooManager

Application de gestion de zoo en Java avec architecture MVC.

## Structure du projet

```
ZooManager/
├── src/             # Code source Java
├── doc/             # Documentation Javadoc
└── rap/             # Rapport et diagrammes UML
```

## Fonctionnalités

- Gestion des enclos (création, nettoyage)
- Gestion des animaux (lions, zèbres, pélicans, flamants roses)
- Gestion du personnel (soigneurs, gardiens)
- Gestion financière (budget, transactions)

## Compilation et exécution

### Compilation
```bash
# Création du dossier bin
mkdir -p bin

# Compilation
javac -d bin -sourcepath src src/fr/zoomanager/Main.java
```

### Exécution
```bash
java -cp bin fr.zoomanager.Main
```

## Génération de la documentation
```bash
javadoc -d doc -sourcepath src -subpackages fr.zoomanager
```

## Architecture MVC

- Model : Classes représentant les données et la logique métier
- View : Interface utilisateur en ligne de commande
- Controller : Gestion des interactions utilisateur

## Principes SOLID

1. Single Responsibility Principle
   - Chaque classe a une responsabilité unique
   - Ex: Zoo gère la structure, Animal gère le comportement

2. Open/Closed Principle
   - Extension facile (nouveaux animaux, enclos)
   - Pas de modification du code existant

3. Liskov Substitution Principle
   - Les sous-classes peuvent remplacer leurs classes parentes
   - Ex: Lion/Zebre peuvent remplacer Mammifere

4. Interface Segregation Principle
   - Interfaces spécifiques pour chaque type de comportement

5. Dependency Inversion Principle
   - Dépendances vers des abstractions
   - Ex: Zoo dépend de l'interface Animal

## Auteurs

[Vos noms]
