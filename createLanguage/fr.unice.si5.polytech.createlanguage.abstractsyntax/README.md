# Organisation du modèle

Le model s'organise autour de la classe centrale `CreateProgram`, qui est le point d'entrée de la structure du language.
Cette classe possède un ensemble de `Choreography` qui seront les différentes chorégraphies défini par l'utilisateur. Elle possèdent également un ensemble de `starting_choreos` qui seront les chorégraphies à executer en debut de programme, les unes à la suite des autres.

Une `Choreography` est une classe abstraite qui peut être declinée de deux façons : `FiniteChoreography` ou `LoopChoreography`. Chaque chorégraphie possèdent ensuite un ensemble d'instructions, qui sont des choregraphies ou des actions. Elle possède également un ensemble d'`Interruption`.

Une `Action` est une classe qui se decline en plusieurs classes filles correspondantes aux actions disponibles et executables par le robot. 

Une `Interruption` est un classe composé d'une condition (condition de declanchement de l'interruption), ainsi que de la référence de la chorégraphie à lancer lorsque l'interruption est levée. 

Une `Condition` est découpée en trois sous-classes : les `AndConditions` et les `OrConditions` qui représentent deux conditions séparées par un opérateur logique, et des `BooleanEvent`, qui sont les conditions auxquels réagit le robot.  
