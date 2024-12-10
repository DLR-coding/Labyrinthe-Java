import java.util.ArrayList;
import java.util.List;

public class Game {
    public Board _board;
    public List<Player> _players;
    public List<Goal> _allGoals;
    public boolean _finished;


    public Game() {
        this._board = new Board();
        this._players = new ArrayList<>();
        this._allGoals = new ArrayList<>();
        this._finished = false;
    }

    public void startGame() {
        // Initialiser le plateau et les joueurs
        System.out.println("Chargement...");
        initializeBoard();
        initializePlayers();
        this._board.printBoard(this._players);
        // Lancer la partie
        System.out.println("La partie commence !");



        this._board.printBoard(this._players);


        /*
        while (true) {
            // Tour de jeu


        }
         */


    }

    public void endGame() {
        // Terminer la partie
    }

    private void initializeBoard() {
        System.out.println("Initialisation du plateau...");
        // Initialiser le plateau avec des tuiles et des objectifs
        TileFactory tileFactory = new TileFactory();
        // placer Tuiles fixes d'abord
        // Ligne 0
        Tile tile = tileFactory.createTileAngle(RotationFromOriginal.CW90, new Goal(0));
        _board.setTile(new Position(0, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, new Goal(1));
        _board.setTile(new Position(0, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, new Goal(2));
        _board.setTile(new Position(0, 4), tile);
        tile = tileFactory.createTileAngle(RotationFromOriginal.CW180, new Goal(0));
        _board.setTile(new Position(0, 6), tile);

        //  Ligne 2
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, new Goal(3));
        _board.setTile(new Position(2, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, new Goal(4));
        _board.setTile(new Position(2, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW90, new Goal(5));
        _board.setTile(new Position(2, 4), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, new Goal(6));
        _board.setTile(new Position(2, 6), tile);

        // Ligne 4
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, new Goal(7));
        _board.setTile(new Position(4, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, new Goal(8));
        _board.setTile(new Position(4, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, new Goal(9));
        _board.setTile(new Position(4, 4), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, new Goal(10));
        _board.setTile(new Position(4, 6), tile);

        // Ligne 6
        tile = tileFactory.createTileStraight(RotationFromOriginal.DEFAULT, new Goal(0));
        _board.setTile(new Position(6, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, new Goal(1));
        _board.setTile(new Position(6, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, new Goal(2));
        _board.setTile(new Position(6, 4), tile);
        tile = tileFactory.createTileAngle(RotationFromOriginal.CW270, new Goal(0));
        _board.setTile(new Position(6, 6), tile);



        //////// Tuiles non fixes   ////////
        tile = tileFactory.createTileT(RotationFromOriginal.CW90, new Goal(0));
        _board.setTile(new Position(0, 1), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, new Goal(11));
        _board.setTile(new Position(1, 1), tile);
        ////    ////
        /*
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (_board.getTile(new Position(i, j)) == null) {// Si la tuile n'existe pas encore
                    Tile nonfixtile = tileFactory.createTileStraight(RotationFromOriginal.DEFAULT, 0);
                    _board.setTile(new Position(i, j), nonfixtile);
                }
            }
        }
        // Ajouter des objectifs aux tuiles
        addGoalsToBoard();
         */
        System.out.println("Initialisation du plateau terminée.");
    }

    private void initializePlayers() {
        // Initialiser les joueurs avec des objectifs
        Player player1 = new Player(new Position(0, 0) , 1);
        player1._goalsList.add(new Goal(11));
        _players.add(player1);
    }

    private void addGoalsToBoard() {
        // Ajouter des objectifs aux tuiles
        for (int i = 0; i < 24; i++) {
            int x = (int) (Math.random() * 7);
            int y = (int) (Math.random() * 7);
            Goal goal = new Goal(i + 1);
            _allGoals.add(goal);
            Tile tile = _board.getTile(new Position(x, y));
            if (tile != null) {
                tile.setGoal(goal);
            }
        }
    }
}