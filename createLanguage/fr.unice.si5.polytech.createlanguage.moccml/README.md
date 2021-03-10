# MoccML 

Ce projet permet de définir le comportement de notre programme lors d'une exécution concurrente. Deux méthode ont été définies comme étant parallèles: le`start` et `doStep` des `ReferenceChoreography` contenues dans une `ParallelChoreography`.

Malheureusement, lors du lancement, une erreur non comprise est apparue :
```
M1 java.lang.UnsatisfiedLinkError: no buddy-win32-x86_64 in java.library.path
M2 java.lang.NullPointerException
M3 java.lang.UnsatisfiedLinkError: no buddy-win32-x86_64.dll in java.library.path
M4 java.io.IOException: Cannot find /buddy-win32-x86_64.dll
M5 java.lang.UnsatisfiedLinkError: Can't load library: D:\Téléchargements\gemoc_studio-win32.win32.x86_64\buddy-win32-x86_64.dll
M6 java.io.FileNotFoundException: D:\Téléchargements\gemoc_studio-win32.win32.x86_64\buddy-win32-x86_64.dll (Le fichier spécifié est introuvable)

Create RelationModelListener fr.inria.aoste.timesquare.instantrelation.listener.RelationModelListener@1f6ca4ff
CCSL Factory
there is a deadlock ! no solution can be found
no more futures are found in the model
there is a deadlock ! no solution can be found
no more futures are found in the model
```

L'exécution concurrente aurait été intéressante à développer pour pouvoir par exemple faire tourner le robot tout en avançant. Il aurait peut être fallu redéfinir toutes les méthodes `start` et `dostep` en parallèle, et créer des régles de causalité pour imposer l'ordre pour toutes les `ReferenceChoreography` qui ne sont pas dans des `ParallelChoreography`
