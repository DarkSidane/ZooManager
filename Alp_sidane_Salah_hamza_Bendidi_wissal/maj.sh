#!/bin/bash

# Couleurs pour les messages
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}Début de la génération de la documentation...${NC}"

# Vérification de la présence de Java
if ! command -v javac &> /dev/null; then
    echo -e "${RED}❌ Java n'est pas installé. Veuillez installer Java JDK.${NC}"
    exit 1
fi

# Vérification de l'existence du projet
if [ ! -d "src" ]; then
    echo -e "${RED}❌ Le dossier 'src' n'existe pas dans le répertoire courant.${NC}"
    exit 1
fi

# Suppression de l'ancienne documentation si elle existe
echo -e "${YELLOW}Nettoyage de l'ancienne documentation...${NC}"
rm -rf doc/

# Création du dossier de documentation
mkdir -p doc

# Génération de la documentation
echo -e "${YELLOW}Génération de la nouvelle documentation...${NC}"
javadoc -d doc \
    -sourcepath src \
    -subpackages fr.zoomanager \
    -encoding UTF-8 \
    -charset UTF-8 \
    -author \
    -version \
    -use \
    -windowtitle "ZooManager - Documentation" \
    -doctitle "Documentation ZooManager" \
    -header "<h1>ZooManager</h1>" \
    -bottom "<i>Copyright © 2024 - ZooManager</i>" \
    -overview src/fr/zoomanager/overview.html \
    -link https://docs.oracle.com/en/java/javase/11/docs/api/ \
    2>javadoc-errors.txt

# Vérification de la génération
if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ Documentation générée avec succès !${NC}"
    echo -e "${YELLOW}Ouverture de la documentation dans le navigateur...${NC}"
    
    # Détection du système d'exploitation pour ouvrir le navigateur
    case "$(uname -s)" in
        Linux*)     xdg-open doc/index.html;;
        Darwin*)    open doc/index.html;;        # macOS
        MINGW*)     start doc/index.html;;       # Windows Git Bash
        *)          echo -e "${YELLOW}Ouvrez le fichier doc/index.html dans votre navigateur${NC}";;
    esac
else
    echo -e "${RED}❌ Erreur lors de la génération de la documentation${NC}"
    echo -e "${YELLOW}Consultez le fichier javadoc-errors.txt pour plus de détails${NC}"
    exit 1
fi

# Création du fichier overview.html s'il n'existe pas
mkdir -p src/fr/zoomanager
if [ ! -f "src/fr/zoomanager/overview.html" ]; then
    cat > src/fr/zoomanager/overview.html << 'EOL'
<!DOCTYPE HTML>
<html>
<head>
    <title>ZooManager - Vue d'ensemble</title>
</head>
<body>
    <h1>ZooManager</h1>
    <p>Application de gestion de zoo développée en Java avec une architecture MVC.</p>
    
    <h2>Fonctionnalités principales</h2>
    <ul>
        <li>Gestion des animaux (Lions, Zèbres, Pélicans, Flamants roses)</li>
        <li>Gestion du personnel (Soigneurs, Agents de ménage)</li>
        <li>Gestion des enclos</li>
        <li>Système de rôles (Directeur, Soigneur, Agent de ménage)</li>
        <li>Gestion financière</li>
    </ul>
    
    <h2>Architecture</h2>
    <ul>
        <li><strong>Model:</strong> Classes métier (Zoo, Animal, Employee, etc.)</li>
        <li><strong>View:</strong> Interface utilisateur en console</li>
        <li><strong>Controller:</strong> Gestion des interactions et de la logique applicative</li>
    </ul>
</body>
</html>
EOL
fi

echo -e "${GREEN}✅ Documentation prête à être consultée !${NC}"
echo -e "${YELLOW}Vous pouvez maintenant consulter la documentation dans le dossier 'doc'${NC}"
