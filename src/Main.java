import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Init Board
        Board board = new Board();
        TileFactory tileFactory = new TileFactory();

        Tile tileS1 = tileFactory.createTileStraight(Orientation.NORTH, null); // Horizontal
        Tile tileS2 = tileFactory.createTileStraight(Orientation.EAST, null); // Vertical

        board.setTile(new Position(0, 0), tileS1);
        board.setTile(new Position(1, 0), tileS2);

        // Créer et placer le pion
        Position initialPosition = new Position(0, 0);
        Pawn pawn = new Pawn(initialPosition);
        List<Pawn> pawnlist = new ArrayList<>();
        pawnlist.add(pawn);

        // Afficher l'état initial du plateau
        System.out.println("État initial du plateau:");
        board.printBoard(pawnlist);



        // Essayer de déplacer le pion vers le bas
        if (pawn.move(Direction.DOWN, board)) {
            System.out.print("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible , il faut rotate.");
        }

        // Afficher l'état actuel du tableau de paths de TileS1
        System.out.println("État actuel du tableau de paths de TileS1: " + tileS1.getDisplayPaths());


        // Rotater TileS1 et afficher le nouvel état de son tableau de paths
        tileS1.rotate();
        System.out.println("Nouvel état du tableau de paths de TileS1 après rotation: " + tileS1.getDisplayPaths());

        // Réessayer de déplacer le pion vers le bas (on y arrive cette fois-ci)
        if (pawn.move(Direction.DOWN, board)) {
            System.out.println("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible.");
        }

        // Afficher l'état final du plateau
        System.out.println("État final du plateau:");
        board.printBoard(pawnlist);

        // Afficher "FIN MAIN TEST"
        System.out.println("FIN MAIN TEST");

    }
}