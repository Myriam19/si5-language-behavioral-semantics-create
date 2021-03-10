# Syntaxe concrète graphique

En plus d'une syntaxe textuelle, le développeur a également accès à une syntaxe graphique qui represente visuellement l'ensemble du programme souhaité, et lui permettant ainsi d'avoir une meilleure lisibilité sur le programme et les différentes actions qui seront exécutées

### Représentation graphique

Chaque `ReferenceChoreography` de la `starting_choreo` est représentée par un rectangle contenant les différentes instructions. Les icônes des classes sont affichés pour une meilleure lisibilité. Entre chaque `ReferenceChoreography` voisine, il y a une flèche pointant vers suivante avec un label `then`.
En plus de la chorégraphie, les chorégraphies des interruptions sont également représentée de la même manière. Un flèche allant de la chorégraphie principale à la chorégraphie de l'interruption est représentée, avec un label qui décrit la condition à valider pour exécuter la chorégraphie de l'interruption.
Les `LoopChoreography` ont un élément en plus de leurs instructions qui est la condition de sortie.
Les `ParallelChoreography` ne sont pas représentée puisque l'exécution concurrente ne fonctionne pas.

### Debug

Une animation pour le debug a été ajoutée permettant de visualiser l'action en court : le contour ainsi que le label de l'action apparaît en rouge lorsqu'elle s'exécute.
