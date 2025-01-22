#!/bin/bash

# Création des dossiers nécessaires
mkdir -p src/fr/zoomanager/{controller,model/{animal,employee,enclos,financial,user},view}

# Package principal fr.zoomanager
cat > src/fr/zoomanager/package-info.java << 'EOL'
/**
 * Package principal de l'application ZooManager.
 * 
 * <p>Ce package contient l'architecture MVC complète pour la gestion d'un zoo,
 * permettant de gérer les animaux, les employés, les enclos et les finances.</p>
 * 
 * <p>L'application est structurée en plusieurs sous-packages :</p>
 * <ul>
 *     <li>controller : Gestion des interactions et de la logique applicative</li>
 *     <li>model : Données métier et logique business</li>
 *     <li>view : Interface utilisateur en mode console</li>
 * </ul>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager;
EOL

# Package controller
cat > src/fr/zoomanager/controller/package-info.java << 'EOL'
/**
 * Package contenant les contrôleurs de l'application.
 * 
 * <p>Gère la logique de contrôle entre la vue et le modèle,
 * en implémentant le pattern MVC. Le contrôleur principal ZooController
 * coordonne toutes les interactions entre l'utilisateur et le système.</p>
 * 
 * <p>Interactions :</p>
 * <ul>
 *     <li>Utilise fr.zoomanager.view pour l'interface utilisateur</li>
 *     <li>Manipule fr.zoomanager.model pour la logique métier</li>
 * </ul>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.controller;
EOL

# Package model
cat > src/fr/zoomanager/model/package-info.java << 'EOL'
/**
 * Package contenant le modèle de données du zoo.
 * 
 * <p>Contient la classe principale Zoo ainsi que tous les sous-packages
 * représentant les différentes entités du système :</p>
 * 
 * <ul>
 *     <li>animal : Gestion des différentes espèces d'animaux</li>
 *     <li>employee : Gestion du personnel</li>
 *     <li>enclos : Gestion des espaces pour les animaux</li>
 *     <li>financial : Gestion du budget et des transactions</li>
 *     <li>user : Gestion des utilisateurs et des rôles</li>
 * </ul>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model;
EOL

# Package model.animal
cat > src/fr/zoomanager/model/animal/package-info.java << 'EOL'
/**
 * Package gérant les différentes espèces d'animaux du zoo.
 * 
 * <p>Implémente une hiérarchie de classes d'animaux avec :</p>
 * <ul>
 *     <li>Une classe abstraite Animal</li>
 *     <li>Des classes abstraites intermédiaires (Mammifere, Oiseau)</li>
 *     <li>Des implémentations concrètes (Lion, Zebre, Pelican, FlamantRose)</li>
 * </ul>
 * 
 * <p>Chaque animal possède ses propres caractéristiques et comportements.</p>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model.animal;
EOL

# Package model.employee
cat > src/fr/zoomanager/model/employee/package-info.java << 'EOL'
/**
 * Package gérant le personnel du zoo.
 * 
 * <p>Définit les différents types d'employés et leurs responsabilités :</p>
 * <ul>
 *     <li>Soigneur : S'occupe des soins aux animaux</li>
 *     <li>Agent de ménage : Gère la propreté des enclos</li>
 * </ul>
 * 
 * <p>Interagit avec les packages :</p>
 * <ul>
 *     <li>animal : Pour les soins aux animaux</li>
 *     <li>enclos : Pour l'entretien des espaces</li>
 * </ul>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model.employee;
EOL

