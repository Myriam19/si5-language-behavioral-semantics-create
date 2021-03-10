# Organisation du modèle

Le model s'organise autour de la classe centrale `CreateProgram`, qui est le point d'entrée de la structure du language.
Cette classe possède un ensemble de `Choreography` qui seront les différentes chorégraphies définies par l'utilisateur. Elle possède également un ensemble de `starting_choreos` contenant des `ChoreoToRun` qui seront les chorégraphies à executer en debut de programme, les unes à la suite des autres.

Une `Instrution` est une classe abstraite qui a plusieurs classes filles : `Action`, `Choreography`, `ChoreToRun`

Une `Choreography` est une classe abstraite qui peut être déclinée de deux façons : `FiniteChoreography` ou `LoopChoreography`. Chaque chorégraphie possède ensuite un ensemble d'instructions. Elle possède également un ensemble d'`Interruption`.

La classe `ChoreToRun` a deux classes filles : `ReferenceChoreography` et `ParallelChoreography`. Ces deux classes vont référencer des chorégraphies à exécuter.
Le fait d'avoir une liste `starting_choreo` permet de différencier l'initialisation et la définition des chorégraphies à l'exécution de celles-ci. La liste permet également d'avoir une meilleure visualisation des différentes chorégraphies et de l'ordre d'exécution dans la syntaxe concrète graphique (au lieu d'avoir uniquement une chorégraphie à lancer contenant des chorégraphies, elles seront chacune représentée indépendamment et lier par un lien réprésentant l'ordre d'exécution).

Une `ReferenceChoreography` contient une chorégraphie. Elle permet d'avoir plusieurs instances à représenter graphiquement d'une même chorégraphie (si une même chorégraphie apparaît plusieurs fois dans la liste de `starting_choreo`), et également d'inclure une chorégraphie dans une autre uniquement en renseignant son nom (ce qui va créer une instance de `ReferenceChoreography`).

Une `Action` est une classe qui se decline en plusieurs classes filles correspondantes aux actions disponibles et executables par le robot. 

Une `Interruption` est un classe composé d'une condition (condition de declanchement de l'interruption), ainsi que de la référence de la chorégraphie à lancer lorsque l'interruption est levée. Le fait de contenir une ReferenceChoreography au lieu de référencer une chorégraphie est aussi un choix fait par rapport à la syntaxe graphique. Si une même chorégraphie est présente deux fois dans le starting_choreo, les chorégraphies à lancer dans l'interruption sera également dupliquée pour une meilleure lisibilité. Malheureusement, cette fonctionnalité n'a pas été implémentée correctement ce qui fait que la chorégraphie de l'interruption n'apparaît qu'une seule fois même si la chorégraphie contenant l'interruption est bien dupliquée.

Une `Condition` est découpée en trois sous-classes : les `AndConditions` et les `OrConditions` qui représentent plusieurs conditions séparées par un opérateur logique, et des `BooleanEvent`, qui sont les conditions auxquels réagit le robot. 

### Actions

`GoForward` permet de déplacer le robot vers l'avant soit en indiquant une distance en cm, soit en indiquant une durée en secondes.
`GoBackward` agit comme `GoForward` mais en faisant aller le robot en arrière.
`Rotate` fait tourner le robot d'un certain angle en degrés à définir. Si l'angle est positif, il tourne à gauche, sinon à droite.
`Stop` permet d'arrêter le robot pendant une certaine durée à définir.
`GrabInFront` va faire tourner le robot de 180 degrees pour mettre la pince face à l'objet, ouvrir la pince, reculer, et fermer la pince.
`ReleaseInFront` ouvre la pince, avance le robot, et referme la pince
`GotoClosestObject` ne fonctionne pas actuellement mais aurait permit de se diriger vers le premier objet détecté par la caméra à l'avant.

### BooleanEvents

`ObjectFound` passe à true si un objet se trouve à une distance inférieure de la distance définie par l'utilisateur.
`ObstacleFoundLeft` et `ObstacleFoundRight` passe à true si un obstacle est détécté.
`VirtualWallFound` passe a true si un Virtual wall est détécté.
Le passage à true se fait dans le rewritingrules.
