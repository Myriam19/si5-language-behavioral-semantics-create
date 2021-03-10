

# Regles d'écriture de CreateLanguage

## Organisation du code

Pour pouvoir mettre en place la notion d'interruption, nous avons décidé de mettre en place un mécanisme de "faux parallélisme", qui permet de pouvoir vérifier les conditions d'interruption de manière fréquente lorsque le robot réalise une action.

Pour cela, nous avons ajouté deux méthodes à chaque classe `Instruction` (i.e Aspect) : `start` et `doStep`
Le start permet d'initialiser les différents états du robot en fonction de l'action à réaliser. De cette manière, nous pouvons stocker, par exemple, l'action courante dans la chorégaphie. Toutes les instructions possède une variable `isRunning` qui passe à true dans le `start`.
Ensuite, la méthode doStep permet pour une action donnée, de l'exécuter "pas à pas". De cette manière, chaque action est fragmentée, et nous pouvons vérifier les conditions à chaque réalisation d'une partie de l'action voulue. Pour cela, chaque action calcule la durée de l'action à exécuter (à part pour le grab et le release) dans le `start`. Ce temps diminue après chaque `doStep` de 0.32 seconde. Lorsque ce temps est inférieur ou égal à 0, `isRunning` passe à false.

### Choreography

Comme dit précédemment, la chorégraphie récupère sa première instruction, la `start`, et la stock dans une variable currentInstruction. Dans le `doStep`, elle fait une boucle sur les interruptions, vérifie leur condition, et si elle est valide, exécute la chorégraphie de l'interruption. Après avoir vérifié les interruptions, elle fait un `doStep` sur l'instruction courante si elle est en cours, sinon elle passe à la suivante. Arrivée à la dernière instruction, elle passe sa variable `isRunning` à false.
La `LoopChoreography`, quant à elle, refais un `start` une fois arrivée à la dernière instruction. Elle a également une étape supplémentaire qui est de vérifier sa condition de fin après le `doStep` de l'instruction en cours. Si elle est valide, elle passe `isRunning` à false.

### Conditions

Toutes les conditions ont une variable isValid qui est consultée par l'interruption, et une méthode check permettant de mettre à jour cette variable.

### Main

La méthode main ne fait que boucler sur les `ChoreoToRun` de `starting_choreo`, la `start`, et fait un `doStep` de cette chorégraphie tant qu'elle est en cours.

## Difficultés rencontrées

### Step du contrôleur

Cette méthode de `doStep` a été assez compliquée à mettre en place. Nous avons fait appel la méthode step du contrôleur qui permet de faire bouger le robot à chaque fin de doStep de chaque action. L'appeler à l'extérieur de ces classes actions ne faisait pas fonctionner correctement notre programme.

### GoToClosestObject

Une des fonctionnalités que nous aurions aimé fournir aux développeurs est de pouvoir, après la détection d'un objet, se diriger vers ce dernier pour pouvoir l'attraper avec la pince du robot.

Pour ce faire, nous avons utilisé une des fonctions fournis par l'API Java, qui permet de détecter des objets dans le champ de vision du robot.
Notre première intuition fut alors de récupérer les attributs de ces objets pour pouvoir calculer deux éléments :
- la distance entre le robot et l'objet
- l'angle décrit entre le robot et l'objet pour pouvoir tourner d'un angle précis avant d'avancer en sa direction

Malheureusement, l'ensemble des méthodes mise en place dans la quête de faire fonctionner cette fonctionnalité ont échoué.

NB : le calcul de la distance entre deux objets n'a pas posé problème, mais bien le calcul de l'orientation par rapport à l'objet.

NB bis : l'ensemble de la mise en place et du code associé a ces méthodes sont présentes en commentaire du code de la classe `GoToClosetObjectAspect` dans le fichier `CreateLanguageAspect.xtend` du module `rewritingrules`

#### Méthode naïve

La première méthode que nous avons essayé de mettre en place se basait sur l'orientation de l'objet. En effet, lorsque nous récupérions un objet, il était possible d'avoir accès à deux éléments : sa position et son orientation.

En allant regarder la documentation de Webots, nous nous sommes rendus compte que l'orientation retournée était celle par rapport à la caméra qui a détecté l'objet. Nous avons donc naïvement récupéré cette valeur, et demandé au robot de tourner de l'angle donné. Sans succès : peu importe l'objet et sa position par rapport au robot, la valeur ne changeait pas.

#### Méthode coordonnées GPS

Nous nous sommes donc rabattus sur une méthode se basant sur les coordonnées GPS. L'idéé ici était de se baser sur une formule permettant de calculer l'angle décrit entre deux points GPS. Là encore, impossible d'obtenir une valeur d'angle cohérente malgré les différentes formules utilisées.

#### Méthode vectorielle

La dernière méthode testée fut de se baser sur une approche vectorielle. En effet, étant donné qu'il n'était pas possible de récupérer l'orientation du robot et/ou de l'objet, nous avons donc calculé des vecteurs et fait des calculs dessus. Pour cela, nous avons tout d'abord créé un vecteur entre la position initial du robot et une position finale (déplacement "en ligne" droite du robot depuis le point initial), puis un vecteur formé avec la position d'arrivée du robot et celle de l'objet. De cette manière, nous obtenons donc deux vecteurs et pouvons à partir de ces vecteurs calculer l'angle formé entre ces deux vecteurs. Une fois l'angle obtenu, nous avons pris le complément à 180° de l'angle, puisque le robot se trouvait en position finale et non initiale. Encore une fois, la valeur de l'angle retourné était incohérente. 
