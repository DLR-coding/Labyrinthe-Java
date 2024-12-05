import java.util.ArrayList;
import java.util.List;
/*
public class Game {
    private Board board;
    private List<Player> players;
    private List<Goal> allGoals;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.allGoals = new ArrayList<>();
    }

    public void startGame() {
        // Initialiser le plateau et les joueurs
        System.out.println("Chargement...");
        initializeBoard();
        initializePlayers();

        // Lancer la partie
        System.out.println("La partie commence !");
        while (true) {
            // Tour de jeu

        }

    }

    public void endGame() {
        // Terminer la partie
    }

    private void initializeBoard() {
        // Initialiser le plateau avec des tuiles et des objectifs
        TileFactory tileFactory = new TileFactory();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tile tile = tileFactory.createTileStraight(Orientation.NORTH, 0);
                board.setTile(new Position(i, j), tile);
            }
        }
        // Ajouter des objectifs aux tuiles
        addGoalsToBoard();
    }

    private void initializePlayers() {
        // Initialiser les joueurs avec des objectifs
        for (int i = 0; i < 4; i++) {
            Pawn pawn = new Pawn(new Position(i, 0));
            List<Goal> goals = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                goals.add(allGoals.get(i * 6 + j));
            }
            Player player = new Player(i + 1, pawn, goals);
            players.add(player);
        }
    }

    private void addGoalsToBoard() {
        // Ajouter des objectifs aux tuiles
        for (int i = 0; i < 24; i++) {
            int x = (int) (Math.random() * 7);
            int y = (int) (Math.random() * 7);
            Goal goal = new Goal(i + 1);
            allGoals.add(goal);
            Tile tile = board.getTile(new Position(x, y));
            if (tile != null) {
                tile.setGoal(goal);
            }
        }
    }


} */