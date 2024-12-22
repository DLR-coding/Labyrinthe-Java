import java.io.IOException;

public class Main_test4 {

    public static void main(String[] args) throws IOException {

        Game game = new Game();
        GameUI UI = new GameUI();
        //init board
        UI.replicateBoard(game._board._tiles, game._board._extraTile);

        // Afficher "FIN MAIN TEST"
        System.out.println("FIN MAIN TEST 4...");

    }
}
