<div align="center">

# 🦁 ZooManager

### *A comprehensive Java-based zoo management system*

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![MVC](https://img.shields.io/badge/Architecture-MVC-blue.svg)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
[![Console](https://img.shields.io/badge/Interface-Console-green.svg)](https://github.com)

---

### 🌍 Language / Langue

**[🇬🇧 English](#english)** | **[🇫🇷 Français](#français)**

---

</div>

<a name="english"></a>

## 🇬🇧 English Version

### 📖 About the Project

**ZooManager** is a comprehensive Java console application designed to simulate the management of a modern zoo. Built with an elegant MVC architecture, it provides a role-based access control system that allows different types of users to perform specific tasks according to their responsibilities.

Whether you're a zoo director managing the entire facility, a caretaker feeding and caring for animals, or cleaning staff maintaining enclosures, ZooManager provides an intuitive interface to handle all zoo operations efficiently.

---

### ✨ Key Features

<table>
<tr>
<td width="33%" align="center">

🎯 **Role-Based Access**
<br><br>
Three distinct user roles with specialized permissions and workflows

</td>
<td width="33%" align="center">

🐘 **Animal Management**
<br><br>
Complete lifecycle management for multiple animal species

</td>
<td width="33%" align="center">

💰 **Financial Tracking**
<br><br>
Comprehensive budget management with transaction history

</td>
</tr>
<tr>
<td align="center">

🏠 **Enclosure System**
<br><br>
Habitat management with capacity and cleanliness tracking

</td>
<td align="center">

👥 **Employee Management**
<br><br>
Staff assignment with specialty-based task allocation

</td>
<td align="center">

🎨 **Rich Console UI**
<br><br>
Color-coded interface with emojis for better UX

</td>
</tr>
</table>

---

### 🛠️ Technology Stack

- **Language:** Java (JDK 17+)
- **Architecture:** Model-View-Controller (MVC)
- **Interface:** Console-based with ANSI color support
- **Dependencies:** Java Standard Library only
- **Documentation:** JavaDoc (full API documentation included)

---

### 🏗️ Architecture

The application follows a clean **MVC architecture** pattern:

```
┌─────────────────────────────────────────────────────┐
│                   CONTROLLER                        │
│              (ZooController.java)                   │
│  • Business logic                                   │
│  • User action handling                             │
│  • State management                                 │
└──────────────┬─────────────────────┬────────────────┘
               │                     │
       ┌───────▼────────┐    ┌──────▼────────┐
       │     MODEL      │    │     VIEW      │
       │   (Zoo.java)   │    │(ConsoleView)  │
       │  • Entities    │    │ • UI Display  │
       │  • Animals     │    │ • User Input  │
       │  • Employees   │    │ • Formatting  │
       │  • Enclosures  │    └───────────────┘
       │  • Budget      │
       └────────────────┘
```

---

### 🚀 Getting Started

#### Prerequisites
- Java Development Kit (JDK) 17 or higher
- A terminal/console that supports ANSI color codes

#### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd ZooManager
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/fr/zoomanager/**/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin fr.zoomanager.Main
   ```

---

### 📖 Usage Guide

#### 👔 Director Role

As a director, you have full access to all zoo operations:

- **Manage Enclosures:** Create new habitats, view all enclosures, monitor cleanliness
- **Manage Animals:** Add new animals, feed them, heal sick animals, view complete roster
- **Manage Employees:** Hire new staff, assign employees to specific enclosures
- **Financial Reports:** View budget status, track income and expenses

#### 🧑‍⚕️ Caretaker (Soigneur) Role

Specialized in animal care with restrictions based on expertise:

- **View Animals:** See all animals in the zoo with health and hunger status
- **Feed Animals:** Provide food to animals (only for species matching your specialization)
- **Heal Animals:** Treat sick animals (only for species matching your specialization)
- **Specializations:** Each caretaker specializes in specific animal species

#### 🧹 Cleaning Staff (Agent de Ménage) Role

Responsible for maintaining enclosure hygiene:

- **View Enclosures:** See all habitats and their cleanliness levels
- **Clean Enclosures:** Perform cleaning tasks to maintain proper hygiene
- **Automated Rounds:** Systematic inspection of all zoo facilities

---

### 🦁 Available Species

The zoo supports four distinct animal species:

| Species | Type | Emoji | Characteristics |
|---------|------|-------|-----------------|
| **Lion** (Lion) | Mammal | 🦁 | King of the savanna |
| **Zebra** (Zèbre) | Mammal | 🦓 | Striped savanna dweller |
| **Pelican** (Pélican) | Bird | 🦢 | Aquatic bird |
| **Pink Flamingo** (Flamant Rose) | Bird | 🦩 | Elegant wading bird |

---

### 📁 Project Structure

```
ZooManager/
├── src/fr/zoomanager/
│   ├── Main.java                    # Application entry point
│   ├── controller/
│   │   └── ZooController.java       # Main controller logic
│   ├── model/
│   │   ├── Zoo.java                 # Zoo entity
│   │   ├── animal/                  # Animal hierarchy
│   │   │   ├── Animal.java          # Abstract base class
│   │   │   ├── Species.java         # Species enumeration
│   │   │   ├── Mammifere.java       # Mammal subclass
│   │   │   ├── Oiseau.java          # Bird subclass
│   │   │   └── [Species classes]    # Lion, Zebre, Pelican, FlamantRose
│   │   ├── employee/                # Employee hierarchy
│   │   │   ├── Employee.java        # Abstract base class
│   │   │   ├── Soigneur.java        # Caretaker
│   │   │   └── AgentMenage.java     # Cleaning staff
│   │   ├── enclos/
│   │   │   └── Enclos.java          # Enclosure/Habitat
│   │   ├── financial/               # Budget management
│   │   │   ├── Budget.java          # Financial tracking
│   │   │   ├── Transaction.java     # Transaction records
│   │   │   └── TransactionType.java # Income/Expense types
│   │   └── user/
│   │       ├── User.java            # User session
│   │       └── Role.java            # User roles enum
│   └── view/
│       └── ConsoleView.java         # Console UI
├── doc/                              # JavaDoc documentation
└── rap/                              # Reports and UML diagrams
    ├── uml/                          # UML class diagrams
    ├── mvc_general.png               # Architecture diagram
    └── rapport.pdf                   # Project report
```

---

<div align="center">

### 🎯 Initial Zoo Configuration

When you start the application, the zoo comes pre-populated with:

**2 Enclosures** | **4 Animals** | **2 Employees** | **€10,000 Budget**

---

**Made with ❤️ using Java**

</div>

---
---

<a name="français"></a>

## 🇫🇷 Version Française

### 📖 À propos du projet

**ZooManager** est une application console Java complète conçue pour simuler la gestion d'un zoo moderne. Construite avec une architecture MVC élégante, elle fournit un système de contrôle d'accès basé sur les rôles permettant à différents types d'utilisateurs d'effectuer des tâches spécifiques selon leurs responsabilités.

Que vous soyez directeur de zoo gérant l'ensemble des installations, soigneur nourrissant et prenant soin des animaux, ou agent de ménage entretenant les enclos, ZooManager offre une interface intuitive pour gérer efficacement toutes les opérations du zoo.

---

### ✨ Fonctionnalités principales

<table>
<tr>
<td width="33%" align="center">

🎯 **Accès par rôle**
<br><br>
Trois rôles d'utilisateur distincts avec des permissions et workflows spécialisés

</td>
<td width="33%" align="center">

🐘 **Gestion des animaux**
<br><br>
Gestion complète du cycle de vie de plusieurs espèces animales

</td>
<td width="33%" align="center">

💰 **Suivi financier**
<br><br>
Gestion budgétaire complète avec historique des transactions

</td>
</tr>
<tr>
<td align="center">

🏠 **Système d'enclos**
<br><br>
Gestion des habitats avec suivi de la capacité et de la propreté

</td>
<td align="center">

👥 **Gestion du personnel**
<br><br>
Affectation du personnel avec allocation des tâches selon les spécialités

</td>
<td align="center">

🎨 **Interface console riche**
<br><br>
Interface avec code couleur et emojis pour une meilleure UX

</td>
</tr>
</table>

---

### 🛠️ Stack technique

- **Langage :** Java (JDK 17+)
- **Architecture :** Model-View-Controller (MVC)
- **Interface :** Console avec support des couleurs ANSI
- **Dépendances :** Bibliothèque standard Java uniquement
- **Documentation :** JavaDoc (documentation API complète incluse)

---

### 🏗️ Architecture

L'application suit un pattern **d'architecture MVC** propre :

```
┌─────────────────────────────────────────────────────┐
│                 CONTRÔLEUR                          │
│              (ZooController.java)                   │
│  • Logique métier                                   │
│  • Gestion des actions utilisateur                  │
│  • Gestion d'état                                   │
└──────────────┬─────────────────────┬────────────────┘
               │                     │
       ┌───────▼────────┐    ┌──────▼────────┐
       │     MODÈLE     │    │      VUE      │
       │   (Zoo.java)   │    │(ConsoleView)  │
       │  • Entités     │    │ • Affichage   │
       │  • Animaux     │    │ • Saisie      │
       │  • Employés    │    │ • Formatage   │
       │  • Enclos      │    └───────────────┘
       │  • Budget      │
       └────────────────┘
```

---

### 🚀 Démarrage rapide

#### Prérequis
- Java Development Kit (JDK) 17 ou supérieur
- Un terminal/console supportant les codes couleur ANSI

#### Installation et exécution

1. **Cloner le dépôt**
   ```bash
   git clone <url-du-dépôt>
   cd ZooManager
   ```

2. **Compiler le projet**
   ```bash
   javac -d bin src/fr/zoomanager/**/*.java
   ```

3. **Lancer l'application**
   ```bash
   java -cp bin fr.zoomanager.Main
   ```

---

### 📺 Aperçu de l'application

#### Connexion et Menu Principal

```
=== 🔑 CONNEXION ===
1. 👨‍💼 Se connecter en tant que directeur
2. 👤 Se connecter en tant qu'employé
3. 🚪 Quitter
Votre choix : > 1

=== 👨‍💼 Connecté en tant que Directeur (Role: Directeur) ===

=== 👨‍💼 MENU DIRECTEUR ===
1. 🏠 Gérer les enclos
2. 🦁 Gérer les animaux
3. 👥 Gérer les employés
4. 💰 Voir les finances
5. 🚪 Se déconnecter
Votre choix : > 2
```

#### Gestion des Animaux

```
=== 🦁 GESTION DES ANIMAUX ===
1. 👁️ Voir tous les animaux
2. ➕ Ajouter un animal
3. 🍽️ Nourrir un animal
4. 💊 Soigner un animal
5. ↩️ Retour
Votre choix : > 1

✅
Enclos : Savane
✅ - Simba - Santé: 100,0%, Faim: 5,0%, Alpha: Oui, Taille du groupe: 4
✅ - Marty - Santé: 100,0%, Faim: 5,0%

Enclos : Volière
✅ - Rico - Santé: 100,0%, Faim: 5,0%
✅ - Flamby - Santé: 100,0%, Faim: 5,0%
```

#### Rapport Financier

```
Votre choix : > 4

=== Rapport financier ===
Balance actuelle: 10000,00€
Dernières transactions:
[16/10/2025 13:41] +€10000,00€ - Budget initial
```

---

### 📖 Guide d'utilisation

#### 👔 Rôle Directeur

En tant que directeur, vous avez un accès complet à toutes les opérations du zoo :

- **Gérer les enclos :** Créer de nouveaux habitats, voir tous les enclos, surveiller la propreté
- **Gérer les animaux :** Ajouter de nouveaux animaux, les nourrir, soigner les animaux malades, voir la liste complète
- **Gérer les employés :** Embaucher du nouveau personnel, affecter les employés à des enclos spécifiques
- **Rapports financiers :** Voir l'état du budget, suivre les revenus et les dépenses

#### 🧑‍⚕️ Rôle Soigneur

Spécialisé dans les soins aux animaux avec restrictions basées sur l'expertise :

- **Voir les animaux :** Voir tous les animaux du zoo avec leur état de santé et de faim
- **Nourrir les animaux :** Fournir de la nourriture aux animaux (uniquement pour les espèces correspondant à votre spécialisation)
- **Soigner les animaux :** Traiter les animaux malades (uniquement pour les espèces correspondant à votre spécialisation)
- **Spécialisations :** Chaque soigneur se spécialise dans des espèces animales spécifiques

#### 🧹 Rôle Agent de Ménage

Responsable du maintien de l'hygiène des enclos :

- **Voir les enclos :** Voir tous les habitats et leurs niveaux de propreté
- **Nettoyer les enclos :** Effectuer des tâches de nettoyage pour maintenir une hygiène appropriée
- **Rondes automatisées :** Inspection systématique de toutes les installations du zoo

---

### 🦁 Espèces disponibles

Le zoo prend en charge quatre espèces animales distinctes :

| Espèce | Type | Emoji | Caractéristiques |
|--------|------|-------|------------------|
| **Lion** | Mammifère | 🦁 | Roi de la savane |
| **Zèbre** | Mammifère | 🦓 | Habitant rayé de la savane |
| **Pélican** | Oiseau | 🦢 | Oiseau aquatique |
| **Flamant Rose** | Oiseau | 🦩 | Élégant échassier |

---

### 📁 Structure du projet

```
ZooManager/
├── src/fr/zoomanager/
│   ├── Main.java                    # Point d'entrée de l'application
│   ├── controller/
│   │   └── ZooController.java       # Logique principale du contrôleur
│   ├── model/
│   │   ├── Zoo.java                 # Entité Zoo
│   │   ├── animal/                  # Hiérarchie des animaux
│   │   │   ├── Animal.java          # Classe de base abstraite
│   │   │   ├── Species.java         # Énumération des espèces
│   │   │   ├── Mammifere.java       # Sous-classe Mammifère
│   │   │   ├── Oiseau.java          # Sous-classe Oiseau
│   │   │   └── [Classes espèces]    # Lion, Zebre, Pelican, FlamantRose
│   │   ├── employee/                # Hiérarchie des employés
│   │   │   ├── Employee.java        # Classe de base abstraite
│   │   │   ├── Soigneur.java        # Soigneur
│   │   │   └── AgentMenage.java     # Agent de ménage
│   │   ├── enclos/
│   │   │   └── Enclos.java          # Enclos/Habitat
│   │   ├── financial/               # Gestion budgétaire
│   │   │   ├── Budget.java          # Suivi financier
│   │   │   ├── Transaction.java     # Enregistrements de transactions
│   │   │   └── TransactionType.java # Types Revenus/Dépenses
│   │   └── user/
│   │       ├── User.java            # Session utilisateur
│   │       └── Role.java            # Énumération des rôles
│   └── view/
│       └── ConsoleView.java         # Interface console
├── doc/                              # Documentation JavaDoc
└── rap/                              # Rapports et diagrammes UML
    ├── uml/                          # Diagrammes de classes UML
    ├── mvc_general.png               # Diagramme d'architecture
    └── rapport.pdf                   # Rapport de projet
```

---

<div align="center">

### 🎯 Configuration initiale du zoo

Au démarrage de l'application, le zoo est pré-rempli avec :

**2 Enclos** | **4 Animaux** | **2 Employés** | **Budget de 10 000 €**

---

**Fait avec ❤️ en Java**

</div>
