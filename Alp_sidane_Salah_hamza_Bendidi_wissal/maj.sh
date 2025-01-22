#!/bin/bash
# Nettoyage de l'ancienne documentation
rm -rf javadoc/
# Création du dossier de documentation
mkdir -p javadoc
# Génération de la documentation
javadoc \
    -d javadoc \
    -sourcepath src \
    -subpackages fr.zoomanager \
    -encoding UTF-8 \
    -charset UTF-8 \
    -html5 \
    -author \
    -version \
    -use \
    -private \
    -splitindex \
    -linksource \
    -windowtitle "ZooManager - Documentation" \
    -doctitle "Documentation ZooManager" \
    -overview src/fr/zoomanager/overview.html \
    -tag param:a:"Paramètre :" \
    -tag return:a:"Retour :" \
    -tag throws:a:"Exception :" \
    -link https://docs.oracle.com/en/java/javase/11/docs/api/ \
    -Xdoclint:none \
    -notimestamp
# Correction des liens dans la barre de navigation
echo "Correction des liens dans la barre de navigation..."
find javadoc -name "*.html" -type f -exec sed -i '' \
    -e 's#<li>Package</li>#<li><a href="allpackages-index.html">Package</a></li>#g' \
    -e 's#<li>Class</li>#<li><a href="allclasses-index.html">Class</a></li>#g' \
    -e 's#<li>Use</li>#<li><a href="package-use.html">Use</a></li>#g' {} +
# Vérification de la génération
if [ $? -eq 0 ]; then
    echo "✅ Documentation générée avec succès dans le dossier 'javadoc'"
    echo "Pour visualiser correctement :"
    echo "1. Exécutez : python3 -m http.server 8000"
    echo "2. Ouvrez : http://localhost:8000/javadoc/"
else
    echo "❌ Erreur lors de la génération de la documentation"
fi
