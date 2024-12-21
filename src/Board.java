import java.util.ArrayList;
import java.util.List;

public class Board {
    public Tile[][] _tiles;
    public Tile _extraTile;
    public List<Player> _players;


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

        this._extraTile = null;
        this._players = new ArrayList<>();
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
    public void addExtraTile(Direction direction, int number) {
        switch (direction) {
            case UP:
                moveUp(number);
                break;
            case DOWN:
                moveDown(number);
                break;
            case LEFT:
                moveLeft(number);
                break;
            case RIGHT:
                moveRight(number);
                break;
        }
    }

    private void moveUp(int numCol) {
        // Récupérer la tuile à la première ligne de la numCol spécifiée
        Tile newExtraTile = _tiles[0][numCol];
        // La retirer du tableau de tuiles
        _tiles[0][numCol] = null;

        // Déplacer les tuiles vers le haut
        for (int i = 0; i < _tiles.length - 1; i++) {
            _tiles[i][numCol] = _tiles[i + 1][numCol];

            // Vérifier si un joueur est présent sur la tuile déplacée
            for (Player player : this._players) {
                if (player.getPosition().getRow() == i + 1 && player.getPosition().getColumn() == numCol) {
                    player.setPosition(new Position(i, numCol));
                }
            }
        }

        // Ajouter la tuile extra à la dernière ligne
        _tiles[_tiles.length - 1][numCol] = _extraTile;
        // Update _extraTile
        _extraTile = newExtraTile;
    }

    private void moveDown(int numCol) {
        // Récupérer la tuile à la dernière ligne de la numCol spécifiée
        Tile newExtraTile = _tiles[_tiles.length - 1][numCol];
        // La retirer du tableau de tuiles
        _tiles[_tiles.length - 1][numCol] = null;

        // Déplacer les tuiles vers le bas
        for (int i = _tiles.length - 1; i > 0; i--) {
            _tiles[i][numCol] = _tiles[i - 1][numCol];

            // Vérifier si un joueur est présent sur la tuile déplacée
            for (Player player : this._players) {
                if (player.getPosition().getRow() == i - 1 && player.getPosition().getColumn() == numCol) {
                    player.setPosition(new Position(i, numCol));
                }
            }
        }

        // Ajouter la tuile extra à la première ligne
        _tiles[0][numCol] = _extraTile;
        // Update _extraTile
        _extraTile = newExtraTile;
    }

    private void moveLeft(int numRow) {
        // Récupérer la tuile à la première colonne de la numRow spécifiée
        Tile newExtraTile = _tiles[numRow][0];
        // La retirer du tableau de tuiles
        _tiles[numRow][0] = null;

        // Déplacer les tuiles vers la gauche
        for (int i = 0; i < _tiles[numRow].length - 1; i++) {
            _tiles[numRow][i] = _tiles[numRow][i + 1];

            // Vérifier si un joueur est présent sur la tuile déplacée
            for (Player player : this._players) {
                if (player.getPosition().getRow() == numRow && player.getPosition().getColumn() == i + 1) {
                    player.setPosition(new Position(numRow, i));
                }
            }
        }

        // Ajouter la tuile extra à la dernière colonne
        _tiles[numRow][_tiles[numRow].length - 1] = _extraTile;
        // Update _extraTile
        _extraTile = newExtraTile;
    }

    private void moveRight(int numRow) {
        // Récupérer la tuile à la dernière colonne de la numRow spécifiée
        Tile newExtraTile = _tiles[numRow][_tiles[numRow].length - 1];
        // La retirer du tableau de tuiles
        _tiles[numRow][_tiles[numRow].length - 1] = null;

        // Déplacer les tuiles vers la droite
        for (int i = _tiles[numRow].length - 1; i > 0; i--) {
            _tiles[numRow][i] = _tiles[numRow][i - 1];

            // Vérifier si un joueur est présent sur la tuile déplacée
            for (Player player : this._players) {
                if (player.getPosition().getRow() == numRow && player.getPosition().getColumn() == i - 1) {
                    player.setPosition(new Position(numRow, i));
                }
            }
        }

        // Ajouter la tuile extra à la première colonne
        _tiles[numRow][0] = _extraTile;
        // Update _extraTile
        _extraTile = newExtraTile;
    }

    public void printBoard() {
        // plateau
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
        //  joueur
        System.out.println("Positions des joueurs:");
        for (Player player : this._players) {
            System.out.print("Player " + this._players.indexOf(player) + " à la position: (" + player.getPosition().getRow() + ", " + player.getPosition().getColumn() + ") / " );
            if (!player._goalsList.isEmpty()) {
                System.out.println("Current Goals : " + player._goalsList.peek()._numgoal);
            } else {
                System.out.println("Current Goals :  ! le joueur a fini tt ses goals !");
            }
        }
        // extratile
        if (this._extraTile != null) {
            System.out.println("_extratile:" + this._extraTile.displayPaths());
        } else {
            System.out.println("_extratile: null");
        }

    }

}