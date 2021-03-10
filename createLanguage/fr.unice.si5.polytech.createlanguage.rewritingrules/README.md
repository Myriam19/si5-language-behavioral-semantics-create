# Regles d'écriture de CreateLanguage

## Organisation du code

Pour pouvoir mettre en place la notion d'interruption, nous avons décidé de mttre un place un mécanisme de "faux parrallélisme", qui permet de pouvoir vérifier les conditions d'interruption de manière fréquente lorsque le robot réalise une action. 

Pour cela, nous avons découpé chaque classe (i.e Aspect) en deux méthodes : `start` et `doStep` 
Le start permet d'initialiser les differents états du robot en fonction de l'action à réaliser. De cette manière, nous pouvons stocker, par exemple, l'action courante. Ensuite, la méthode doStep permet pour une action donné, de l'executer "pas à pas". De cette manière, chaque action est fragmenté, et nous pouvons vérifier les conditions à chaque réalisation d'une partie de l'action voulue. 


## Difficultés rencontrées

### GoToClosestObject

Une des fonctionnalités que nous aurions aimé fournir aux developpeurs est de pouvoir, après la détéction d'un objet, se diriger vers ce dernier pour pouvoir l'attraper avec la pince du robot. 

Pour ce faire, nous avons utilisé une des fonctions fournis par l'API JAva, qui permet de détecter des objets dans le champs de vision du robot. 
Notre première intuition fut alors de récupérer les attributs de ces objets pour pouvoir calculer deux éléments :
- la distance entre le robot et l'objet
- l'angle decrit entre le robot et l'objet pour pouvoir tourner d'un angle précis avant d'avancer en sa direction

Malheureusement, l'ensemble des méthodes mise en places dans la quête de faire fonctionner cette fonctionnalité ont échoué.

NB : le calcul de la distance entre deux objet n'a pas posé problème, mais bien le calcul de l'orientation par rapport à l'objet

NB bis : l'ensemble de la mise en place et du code associé a ces méthodes sont presentes en commentaire du code de la classe `GoToClosetObjectAspect` dans le fichier `CreateLanguageAspect.xtend` du module `rewritingrules` 

#### Méthode naive

La prémière méthode que nous avons essayé de mettre en place se basait sur l'orientation de l'objet. En effet, lorsque nous récupérions un objet, il était possible d'avoir accès à deux éléments : sa position et son orientation.

En allant regarder la documention de Webots, nous nous sommes rendus compte que l'orientation retournée était celle par rapport à la caméra qui a détécté l'objet. Nous avons donc naivement récupéré cette valeur, et demandé au robot de tourner de l'angle donné. Sans succés : peu importe l'objet et sa position par rapport au robot, la valeur ne changeait pas.

#### Méthode coordonnées GPS

Nous nous sommes donc rabatus sur une méthode se basant sur les coordonnées GPS. L'idéé ici était de se baser sur une formule permettant de calculer l'angle decrit entre deux points GPS. Là encore, impossible d'obtenir une valeur d'angle cohérente malgrés les differentes formules utilisées.

#### Méthode vectorielle

La dernière méthode testée fut de se baser sur une approche vectorielle. En effet, étant donné qu'il n'était pas possible de récuprer l'orientation du robot et/ou de l'objet, nous avons donc calculé des vecteurs et fait des calculs dessus. Pour cela, nous avons tout d'abord créé un vecteur entre la position inital du robot et une position finale (deplacement "en ligne" droite du robot depusi le point initial), puis un vecteur formé avec la position d'arrivée du robot et celle de l'objet. De cette manière, nous obtenons donc deux vecteurs et pouvons à partir de ces vecteurs calculer l'angle formé entre ces deux vecteurs. Une fois l'angle obtenu, nous avons pris le complement à 180° de l'angle, puisque le robot se trouvait en position finale et non initale. Encore une fois, la valeur de l'angle retourné était incohérente. 
