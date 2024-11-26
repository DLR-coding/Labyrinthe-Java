import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TileFactory tileFactory = new TileFactory();
        Board board = new Board();

        // Créer différents types de tuiles
        Tiles straightTile = tileFactory.createTile("Straight", 0, null);
        Tiles tTile = tileFactory.createTile("T", 0, null);
        Tiles angleTile = tileFactory.createTile("Angle", 0, null);

        // Placer les tuiles sur le plateau
        board.setTile(new Position(0, 0), straightTile);
        board.setTile(new Position(0, 1), tTile);
        board.setTile(new Position(0, 2), angleTile);

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
            System.out.println("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible.");
        }

        // Afficher l'état du plateau après le mouvement
        board.printBoard(pawns);

        // Déplacer une ligne vers le haut
        board.moveRow(1, 0); // 0 pour haut

        // Afficher l'état du plateau après le mouvement de ligne
        board.printBoard(pawns);

        // Déplacer une colonne vers la droite
        board.moveColumn(1, 1); // 1 pour droite

        // Afficher l'état du plateau après le mouvement de colonne
        board.printBoard(pawns);

        // Ajouter la tuile supplémentaire à la ligne 1
        Tiles extraTile = tileFactory.createTile("Straight", 0, null);
        board.addExtraTile(extraTile, 1, 0); // 0 pour ligne

        // Afficher l'état du plateau après l'ajout de la tuile supplémentaire
        board.printBoard(pawns);

        // Ajouter la tuile supplémentaire à la colonne 1
        board.addExtraTile(extraTile, 1, 1); // 1 pour colonne

        // Afficher l'état du plateau après l'ajout de la tuile supplémentaire
        board.printBoard(pawns);
    }
}