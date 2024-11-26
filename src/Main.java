import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TileFactory tileFactory = new TileFactory();
        Board board = new Board();

        // Créer différents types de tuiles
        Tiles straightTile = tileFactory.createTile_Straight(0,null);
        Tiles tTile = tileFactory.createT(0, null);
        Tiles angleTile = tileFactory.createAngle(0, null);
        Tiles straightTile2 = tileFactory.createTile_Straight(1,null);


        // Placer les tuiles sur le plateau
        board.setTile(new Position(0, 0), straightTile);
        board.setTile(new Position(0, 1), tTile);
        board.setTile(new Position(0, 2), angleTile);
        board.setTile(new Position(1, 0), straightTile2);


        // Créer un pion et le placer en position (0,0)
        Position initialPosition = new Position(0, 0);
        Pawn pawn = new Pawn(initialPosition);

        // Ajouter le pion à la liste des pions du jeu
        List<Pawn> pawns = new ArrayList<>();
        pawns.add(pawn);

        // Afficher l'état initial du plateau
        board.printBoard(pawns);

        // Essayer de déplacer le pion vers le bas
        if (pawn.move(2, board)) {
            System.out.print("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible , il faut rotate.");
        }
        ArrayList<Boolean> paths = straightTile2.getPaths();
        System.out.print("straightTile2 paths : { ");
        for (int i = 0; i < paths.size(); i++) {
            System.out.print(paths.get(i) + " , ");
        }
        System.out.print("}");
        System.out.println();

        //Tourner la Tuile straighttile
        straightTile.rotate();
        ArrayList<Boolean> paths2 = straightTile.getPaths();
        System.out.print("straightTile NEW paths : { ");
        for (int i = 0; i < paths2.size(); i++) {
            System.out.print(paths2.get(i) + " , ");
        }
        System.out.print("}");
        System.out.println();


        if (pawn.move(2, board)) {
            System.out.println("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas toujours impossible");
        }


        // Afficher l'état du plateau après le mouvement
        board.printBoard(pawns);

    }
}