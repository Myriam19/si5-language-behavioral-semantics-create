# si5-language-behavioral-semantics-create

### Contexte
Ce langage a pour but de faciliter le développement d'un programme permettant de contrôler un robot (Create++), tout en laissant un maximum de liberté au développeur. Ce robot est destiné principalement au "nettoyage" de l'espace dans lequel il évolue, mais peut être utilisé de diverse manière grâce aux différents modules qui le compose :
- Camera avant et arrière
- Pince arrière
- Stylo
- GPS

L'objectif de ce langage est donc de mettre à disposition du développeur une "boite à outil" dans laquelle il peut récuperer des concepts et les mettre en place au sein de son programme pour arriver à ses fins.

Nous nous sommes focaliser sur la partie nettoyage (c'est à dire le contrôle du déplacement du robot) et l'utilisation de la pince arrière (c'est à dire permettre au développeur d'attrapper et déplacer des objets dans la scène)

### Organisation du langage

Le langage met donc à disposition un ensemble de concepts qui peuvent être utilisé pour guider et contrôler les actions du robot dans son environnement.

Pour ce faire, le développeur peut définir des `choreography` qui sont des successions d'instructions (autre chorégraphie ou actions comme avancer, tourner...) à réaliser. Le chorégraphie peut être `Finite` : elle s'arrête une fois que toutes les instructions qu'elle contient ont été exéctutées ; ou `Loop` : elle s'exécute en boucle tant qu'une condition (condition de sortie) n'est pas remplie.
La `LoopChoreography` permet à l'utilisateur de ne pas avoir à inclure cette même chorégraphie dans une chorégraphie pour boucler, et elle permet également de  définir une condition de fin qui sera vérifiée régulièrement lors de l'exécution de ces instructions.

Pour pouvoir réagir plus précisément dans son environnement, il est également possible de définir des `interruptions` dans une chorégraphie. Ces interruptions permettent à tout moment de l'exécution de la chorégraphie d'interrompre celle-ci (sous couvert d'une condition) pour exécuter une autre chorégraphie. Une fois la chorégraphie annexe executée, le robot reprendra la chorégraphie initale là où il avait été interrompu. Les interruptions possèdent une condition qui peut être potentiellement un groupe de conditions `and` ou `or`.

Le développeur peut également définir des `ParallelChoreography` contenant une liste de chorégraphies, qui permettent l'exécution concurrente des ces chorégraphies. L'implémentation ne semble pas fonctionner actuellement.

Les argumentations de nos choix seront détaillées dans le README des différents modules.

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


### Evolutions possibles

Il aurait été intéressant de développer d'autres concepts tels que :
- Une condition permettant de détecter quand le robot est bloquée
- Une condition permettant de détecter s'il y a un obstable présent devant le robot (actuellement intégrée dans Obstacle trouvé à droite).
- Une condition permettant de détecter lorsque le robot est à une position gps précise
- Une action permettant d'aller à une position gps précise
- Amélioration de l'action permettant d'aller vers l'objet le plus proche
- Amélioration des chorégraphies parallèle
