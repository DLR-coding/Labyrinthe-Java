Rapport 2
-------------------
### Changements


###  Classes
- **Enum Goals** : un goal n'est un chiffre. Donc il nous a été préférable d'avoir une énumeration.

- **GameUI** : GameUI est un JFrame et gère comme prévu l'intégralité de l'affichage, et utilise ImageHelper. Le changement est qu'elle n'est pas liée aux classes    du modèle (pas eu le temps d'enlever les dernières dépendances dans le code). L'idée voulue est qu'elle crée au début d'une partie un plateau qui est une copie du modèle, et elle est un observer du controleur, pour copier sur son affichage les mouvements qu'il fait sur le modèle, afin de ne pas avoir de dépendances inutiles avec le modèle.

En plus de ceci, l'idée recherchée est d'avoir un pad directionnel et un bouton qui permettent de gérer les mouvements des joueurs et les déplacements de tuiles, plutôt que d'avoir des boutons tout autour du plateau (éventuellement des boutons pour rotate la tuile à insérer) 

### ~ ~ ~
- Board._players ? ou _players dans Game seulement (dans ce cas je dois changer mon move de Colonne)

- classe Pion et Players ? -> interface Player avec Bot et Human ?

  Les joueurs sont simplement des pions qui doivent être déplacés sur le plateau, et qu'il n'y a pas d'autres informations spécifiques à chaque joueur, donc nous les considérons comme étant la même enetité et les stockons dans la classe Board.


