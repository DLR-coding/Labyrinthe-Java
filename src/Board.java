import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<ArrayList<Tiles>> _tiles;
    private Tiles _extraTile;

    public Board() {
        this._tiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Tiles> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null); // or initialize with a Tiles object if needed
            }
            _tiles.add(row);
        }
    }

    public Tiles getTile(Position position) {
        return _tiles.get(position.getX()).get(position.getY());
    }

    public void setTile(Position position, Tiles tile) {
        _tiles.get(position.getX()).set(position.getY(), tile);
    }

    public void moveRow(int row, int direction) {
        // Implémentation du déplacement de ligne
        // direction: 0 pour haut, 1 pour bas
        if (direction == 0) {
            // Déplacer la ligne vers le haut
            Tiles removedTile = _tiles.get(row).remove(0);
            _tiles.get(row).add(removedTile);
        } else if (direction == 1) {
            // Déplacer la ligne vers le bas
            Tiles removedTile = _tiles.get(row).remove(6);
            _tiles.get(row).add(0, removedTile);
        }
    }

    public void moveColumn(int column, int direction) {
        // Implémentation du déplacement de colonne
        // direction: 0 pour gauche, 1 pour droite
        if (direction == 0) {
            // Déplacer la colonne vers la gauche
            Tiles removedTile = null;
            for (int i = 0; i < 7; i++) {
                if (i == 0) {
                    removedTile = _tiles.get(i).remove(column);
                } else {
                    _tiles.get(i - 1).set(column, _tiles.get(i).get(column));
                }
            }
            _tiles.get(6).set(column, removedTile);
        } else if (direction == 1) {
            // Déplacer la colonne vers la droite
            Tiles removedTile = null;
            for (int i = 6; i >= 0; i--) {
                if (i == 6) {
                    removedTile = _tiles.get(i).remove(column);
                } else {
                    _tiles.get(i + 1).set(column, _tiles.get(i).get(column));
                }
            }
            _tiles.get(0).set(column, removedTile);
        }
    }

    public void addExtraTile(Tiles extraTile, int number, int direction) {
        // direction: 0 pour ligne, 1 pour colonne
        if (direction == 0) {
            // Ajouter à la ligne spécifiée
            if (number == 1 || number == 3 || number == 5) {
                Tiles removedTile = _tiles.get(number).remove(6);
                for (int i = 5; i >= 0; i--) {
                    _tiles.get(number).set(i + 1, _tiles.get(number).get(i));
                }
                _tiles.get(number).set(0, extraTile);
                this._extraTile = removedTile;
            }
        } else if (direction == 1) {
            // Ajouter à la colonne spécifiée
            if (number == 1 || number == 3 || number == 5) {
                Tiles removedTile = null;
                for (int i = 0; i < 7; i++) {
                    if (i == 6) {
                        removedTile = _tiles.get(i).remove(number);
                    } else {
                        _tiles.get(i).set(number, _tiles.get(i + 1).get(number));
                    }
                }
                _tiles.get(0).set(number, extraTile);
                this._extraTile = removedTile;
            }
        }
    }

    public void printBoard(List<Pawn> pawns) {
        System.out.println("Plateau de jeu:");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tiles tile = _tiles.get(i).get(j);
                if (tile == null) {
                    System.out.print("[  x , x , x , x ,]");
                } else {
                System.out.print("[ " + tile.getDisplayPaths() +  "]" );
                }
            }
            System.out.println();
        }

        System.out.println("Positions des pions:");
        for (Pawn pawn : pawns) {
            System.out.println("Pion à la position: (" + pawn.getPosition().getX() + ", " + pawn.getPosition().getY() + ")");
        }
    }
}