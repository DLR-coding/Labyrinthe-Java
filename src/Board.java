import java.util.List;

public class Board {
    private Tile[][] _tiles;
    private Tile _extraTile;

    public Board() {
        /*
        _board : Tile[7][7]
            [
               0 [ [0][0] , [0][1] , [0][2] , [0][3] , [0][4] , [0][5] , [0][6] ] ,
               1 [ [1][0] , [1][1] , [1][2] , [1][3] , [1][4] , [1][5] , [1][6] ] ,
               2 [ [2][0] , [2][1] , [2][2] , [2][3] , [2][4] , [2][5] , [2][6] ] ,
               3 [ [3][0] , [3][1] , [3][2] , [3][3] , [3][4] , [3][5] , [3][6] ] ,
               4 [ [4][0] , [4][1] , [4][2] , [4][3] , [4][4] , [4][5] , [4][6] ] ,
               5 [ [5][0] , [5][1] , [5][2] , [5][3] , [5][4] , [5][5] , [5][6] ] ,
               6 [ [6][0] , [6][1] , [6][2] , [6][3] , [6][4] , [6][5] , [6][6] ]
            ]
         */
        this._tiles = new Tile[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this._tiles[i][j] = null; // Initialiser avec null
            }
        }
    }

    public Tile getTile(Position position) {
        return _tiles[position.getRow()][position.getColumn()];
    }

    public void setTile(Position position, Tile tile) {
        _tiles[position.getRow()][position.getColumn()] = tile;
    }

    /**
     * Ajoute une tuile supplémentaire (_extraTile) à la fin ou au début d'une ligne ou colonne du tableau de tuiles (_tiles)
     * en fonction de la direction de déplacement donnée.
     *
     * @param direction la direction de déplacement (UP, DOWN, LEFT, RIGHT)
     * @param number    le numéro de la ligne ou colonne où ajouter la tuile
     */
    public void addExtraTile(Direction direction, int number) { //jsp quel autre nom donner
        // Détermine la ligne et la colonne où ajouter la tuile en fonction de la direction
        int row = -1, col = -1;
        switch (direction) {
            case UP:
                // Ajouter la tuile à la dernière ligne
                row = 6;
                col = number;
                break;
            case DOWN:
                // Ajouter la tuile à la première ligne
                row = 0;
                col = number;
                break;
            case LEFT:
                // Ajouter la tuile à dernière colonne
                row = number;
                col = 6;
                break;
            case RIGHT:
                // Ajouter la tuile à la première colonne
                row = number;
                col = 6;
                break;
        }

        // Vérifie si la ligne et la colonne sont pas hors Board
        if (row >= 0 && row < _tiles.length && col >= 0 && col < _tiles[0].length) {
            // Récupère les tuiles de la ligne où ajouter la tuile
            Tile[] rowTiles = _tiles[row];

            // Crée un nouveau tableau de tuiles pour la ligne avec la tuile supplémentaire
            Tile[] newRowTiles = new Tile[rowTiles.length + 1];

            // Ajoute la tuile supplémentaire à la fin de la ligne
            if (col == rowTiles.length) {
                System.arraycopy(rowTiles, 0, newRowTiles, 0, rowTiles.length);
                newRowTiles[col] = _extraTile;
            }
            // Ajoute la tuile supplémentaire au début de la ligne
            else if (col == 0) {
                newRowTiles[0] = _extraTile;
                System.arraycopy(rowTiles, 0, newRowTiles, 1, rowTiles.length);
            }
            // Ajoute la tuile supplémentaire à une position intermédiaire de la ligne
            else {
                System.arraycopy(rowTiles, 0, newRowTiles, 0, col);
                newRowTiles[col] = _extraTile;
                System.arraycopy(rowTiles, col, newRowTiles, col + 1, rowTiles.length - col);
            }

            // Met à jour la ligne de tuiles avec la nouvelle ligne
            _tiles[row] = newRowTiles;
        }
    }

    public void printBoard(List<Player> players) {
        System.out.println("Plateau de jeu:");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tile tile = _tiles[i][j];
                if (tile == null) {
                    System.out.print("[   ,   ,   ,   , ] ");
                } else {
                    System.out.print(tile.displayPaths());
                }
            }
            System.out.println();
        }

        System.out.println("Positions des joueurs:");
        for (Player player : players) {
            System.out.print(players.indexOf(player) + " à la position: (" + player.getPosition().getRow() + ", " + player.getPosition().getColumn() + ") / " );
            if (!player._goalsList.isEmpty()) {
                System.out.println("Current Goals : " + player._goalsList.peek()._numgoal);
            } else {
                System.out.println("Current Goals :  ! le joueur a fini tt ses goals !");
            }
        }
        if (this._extraTile != null) {
            System.out.println("_extratile:" + this._extraTile.displayPaths());
        } else {
            System.out.println("_extratile: null");
        }

    }

}