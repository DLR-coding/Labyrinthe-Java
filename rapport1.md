Rapport 1
-------------------

### Justification des classes
- **model.TileFactory** : Plusieurs classes concrètes (model.TileAngle, model.TileStraight, model.TileT) héritent de la même classe abstraite (model.Tile). Grâce à la Factory , une classe externe ne dépendra que de la classe abstraite et de la fabrique, mais d’aucune classe concrète.
- **Enumeration Directon au lieu d'utiliser des Integer** : Permet d'avoir un code plus lisible et clair 
- **model.Player = Pawn** : pour des raisons de simplification , un joueur est considéré comme un pion.
### Classes qui changeront fort probablement 

- Tout ce qui est lié à la classe GameClient. Jusqu'à maintenant , les Tests n'ont été fait que dans des Main de test qui s'occupaient de tester la génération du jeu ainsi que les dépacements des joueurs.
- Les mouvements de joueurs seront peut-être dans une classe Controller.

### Ne pas prendre en compte 

- Ce qui se trouve hors du modèle



