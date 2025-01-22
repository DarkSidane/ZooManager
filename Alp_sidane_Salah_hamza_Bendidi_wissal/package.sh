# Package model.enclos
cat > src/fr/zoomanager/model/enclos/package-info.java << 'EOL'
/**
 * Package gérant les enclos du zoo.
 * 
 * <p>Définit la structure et la gestion des espaces hébergeant les animaux.
 * Chaque enclos a une capacité maximale et un niveau de propreté à maintenir.</p>
 * 
 * <p>Interagit avec :</p>
 * <ul>
 *     <li>animal : Pour héberger les animaux</li>
 *     <li>employee : Pour l'entretien par les agents</li>
 * </ul>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model.enclos;
EOL

# Package model.financial
cat > src/fr/zoomanager/model/financial/package-info.java << 'EOL'
/**
 * Package gérant les aspects financiers du zoo.
 * 
 * <p>Gère :</p>
 * <ul>
 *     <li>Le budget global</li>
 *     <li>Les transactions (entrées/sorties)</li>
 *     <li>Les rapports financiers</li>
 * </ul>
 * 
 * <p>Utilisé par tous les autres packages pour le suivi des coûts
 * (nourriture, soins, salaires, entretien, etc.)</p>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model.financial;
EOL

# Package model.user
cat > src/fr/zoomanager/model/user/package-info.java << 'EOL'
/**
 * Package gérant les utilisateurs et les rôles du système.
 * 
 * <p>Définit :</p>
 * <ul>
 *     <li>Les différents rôles (Directeur, Soigneur, Agent de ménage)</li>
 *     <li>La gestion des utilisateurs et leurs permissions</li>
 * </ul>
 * 
 * <p>Utilisé par le contrôleur pour gérer les accès et les droits
 * aux différentes fonctionnalités du système.</p>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.model.user;
EOL

# Package view
cat > src/fr/zoomanager/view/package-info.java << 'EOL'
/**
 * Package contenant l'interface utilisateur du zoo.
 * 
 * <p>Implémente une interface en ligne de commande avec :</p>
 * <ul>
 *     <li>Menus interactifs</li>
 *     <li>Affichage coloré</li>
 *     <li>Gestion des entrées utilisateur</li>
 *     <li>Messages d'état et d'erreur</li>
 * </ul>
 * 
 * <p>Communique avec le contrôleur pour traiter les actions utilisateur
 * et afficher les résultats.</p>
 * 
 * @author Sidane Alp
 * @author Hamza Salah
 * @author Wissal Bendidi
 * @version 1.0
 * @since 22/01/2025
 */
package fr.zoomanager.view;
EOL

echo "✅ Fichiers package-info.java mis à jour avec succès !"
