# si5-language-behavioral-semantics-create

### Contexte
Ce langage a pour but de faciliter le développement d'un programme permettant de contrôler un robot (Create++), tout en laissant un maximum de liberté au développeur. Ce robot est destiné principalement au "nettoyage" de l'espace dans lequel il évolue, mais peut être utilisé de diverse manière grâce aux différents modules qui le compose :
- Camera avant et arrière
- Pince arrière
- Stylo
- GPS

L'objectif de ce langage est donc de mettre à disposition du développeur une "boite à outil" dans laquelle il peut recuperer des concepts et les mettres en place au sein de son programme pour arriver à ses fins.

### Organisation du langage

Le langage met donc à disposition un ensemble de concepts qui peuvent être utilisé pour guider et contrôler les actions du robot dans son environnement.

Pour ce faire, le développeur peut définir des `choreography` qui sont des successions d'actions à réaliser. Le chorégraphie peut être `Finite` : elle s'arrête une fois que toutes les actions qu'elle contient ont été exectuté ; ou `Loop` : elle s'execute en boucle tant qu'une condition (conditions de sortie) n'est pas remplie.

Pour pouvoir réagir plus précisément dans son environnement, il est également possible de définir des `interruptions` dans une chorégraphie. Ces interruptions permettent à tout moment de l'exécution de la chorégraphie d'interrompre celle-ci (sous couvert d'une condition) pour exécuter une autre chorégraphie. Une fois la chorégraphie annexe executée, le robot reprendra la chorégraphie initale là où il avait été interrompu. Les interruptions possèdent une ou plusieurs conditions.

### Action et condition

Voici l'ensemble des actions et conditions auxquels le robot peut répondre :

Actions :
- Avancer
- Reculer
- Tourner
- S'arrêter
- Attraper un objet devant
- Relâcher un objet devant
- Se diriger vers l'objet le plus proche (concept seulement, implémentation échouée, voir README du module `rewrintingrules`)

Conditions :
- Objet trouvé
- Mur virtuel trouvé
- Obstacle à droite trouvé
- Obstacle à gauche trouvé

### Syntaxe concrète graphique

En plus d'une syntaxe textuelle, le développeur a également accès à une syntaxe graphique qui represente visuellement l'ensemble du programme souhaité, et lui permettant ainsi d'avoir une meilleure lisibilité sur le programme et les différentes actions qui seront exécutées
