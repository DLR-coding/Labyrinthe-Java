import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<ArrayList<Tiles>> tiles;
    private Tiles extraTile;

    public Board() {
        this.tiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Tiles> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null); // or initialize with a Tiles object if needed
            }
            tiles.add(row);
        }
    }

    public Tiles getTile(Position position) {
        return tiles.get(position.getX()).get(position.getY());
    }

    public void setTile(Position position, Tiles tile) {
        tiles.get(position.getX()).set(position.getY(), tile);
    }

    public void moveRow(int row, int direction) {
        // Implémentation du déplacement de ligne
        // direction: 0 pour haut, 1 pour bas
        if (direction == 0) {
            // Déplacer la ligne vers le haut
            Tiles removedTile = tiles.get(row).remove(0);
            tiles.get(row).add(removedTile);
        } else if (direction == 1) {
            // Déplacer la ligne vers le bas
            Tiles removedTile = tiles.get(row).remove(6);
            tiles.get(row).add(0, removedTile);
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
                    removedTile = tiles.get(i).remove(column);
                } else {
                    tiles.get(i - 1).set(column, tiles.get(i).get(column));
                }
            }
            tiles.get(6).set(column, removedTile);
        } else if (direction == 1) {
            // Déplacer la colonne vers la droite
            Tiles removedTile = null;
            for (int i = 6; i >= 0; i--) {
                if (i == 6) {
                    removedTile = tiles.get(i).remove(column);
                } else {
                    tiles.get(i + 1).set(column, tiles.get(i).get(column));
                }
            }
            tiles.get(0).set(column, removedTile);
        }
    }

    public void addExtraTile(Tiles extraTile, int number, int direction) {
        // direction: 0 pour ligne, 1 pour colonne
        if (direction == 0) {
            // Ajouter à la ligne spécifiée
            if (number == 1 || number == 3 || number == 5) {
                Tiles removedTile = tiles.get(number).remove(6);
                for (int i = 5; i >= 0; i--) {
                    tiles.get(number).set(i + 1, tiles.get(number).get(i));
                }
                tiles.get(number).set(0, extraTile);
                this.extraTile = removedTile;
            }
        } else if (direction == 1) {
            // Ajouter à la colonne spécifiée
            if (number == 1 || number == 3 || number == 5) {
                Tiles removedTile = null;
                for (int i = 0; i < 7; i++) {
                    if (i == 6) {
                        removedTile = tiles.get(i).remove(number);
                    } else {
                        tiles.get(i).set(number, tiles.get(i + 1).get(number));
                    }
                }
                tiles.get(0).set(number, extraTile);
                this.extraTile = removedTile;
            }
        }
    }

    public void printBoard(List<Pawn> pawns) {
        System.out.println("Plateau de jeu:");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tiles tile = tiles.get(i).get(j);
                if (tile == null) {
                    System.out.print("[   ] ");
                } else {
                    System.out.print("[ " + tile.getType().charAt(0) + " ] ");
                }
            }
            System.out.println();
        }

        System.out.println("Positions des pions:");
        for (Pawn pawn : pawns) {
            System.out.println("Pion à la position: (" + pawn.get_position().getX() + ", " + pawn.get_position().getY() + ")");
        }
    }

}