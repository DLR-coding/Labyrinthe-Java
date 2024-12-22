Rapport 2
-------------------
### Changements



un rapport pour présenter vos 
## nouveaux choix de conception depuis le 1er rendu 

- **Enum Goals** : pour nous, un goal n'est qu'un chiffre. Donc il nous a été préférable d'avoir une énumeration plutôt que des Integer.
- **view.GameUI** : view.GameUI est un JFrame et gère comme prévu l'intégralité de l'affichage, et utilise view.ImageHelper. Le changement est qu'elle n'est pas liée aux classes    du modèle (pas eu le temps d'enlever les dernières dépendances dans le code). L'idée voulue est qu'elle crée au début d'une partie un plateau qui est une copie du modèle, et elle est un observer du controleur, pour copier sur son affichage les mouvements qu'il fait sur le modèle, afin de ne pas avoir de dépendances inutiles avec le modèle.

En plus de ceci, l'idée recherchée est d'avoir un pad directionnel et un bouton qui permettent de gérer les mouvements des joueurs et les déplacements de tuiles, plutôt que d'avoir des boutons tout autour du plateau (éventuellement des boutons pour rotate la tuile à insérer)





