# Organisation des modules 

Ce dossier contient l'ensemble des modules necessaires au fonctionnement du robot

## Structure des modules

- `fr.unice.si5.polytech.createlanguage.abstractsyntax` contient l'ensemble du model de langage 
- `fr.unice.si5.polytech.createlanguage.concretesyntax` contient la définition de la grammaire du langage
- `fr.unice.si5.polytech.createlanguage.rewritingrules` contient la definitions de la sémantique du langage 

## Quickstart (Eclipse Gemoc Studio)

- start Gemoc in a new workspace and import all the `fr.unice.si5.polytech.createlanguage.*` projects as existing project (import -> project -> general -> existing project in the workspace). 
- open the Ecore model (`fr.unice.si5.polytech.createlanguage.abstractsyntax/model/createlanguage.ecore`) and then right click -> generate -> all. 
- open the xtext file (`fr.unice.si5.polytech.createlanguage.concretesyntax/src/fr/unice/polytech/si5/CreateLanguage.xtext`) and then right click -> run as -> generate Xtext artefacts
- run a new eclipse application, create a project and put a `.create` file in it...  
- launch Webots sofware
- create a new configuration based on `Executable model with GEMOC Java engine`
- run the .create file with this configuration
