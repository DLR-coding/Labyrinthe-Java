package z_excluded;

public class Main_test1 {
    public static void main(String[] args) {

        // Init model.Board
        model.Board board = new model.Board();
        model.TileFactory tileFactory = new model.TileFactory();

        model.Tile tileS1 = tileFactory.createTileStraight(model.RotationFromOriginal.DEFAULT, null); // Horizontal
        model.Tile tileS2 = tileFactory.createTileStraight(model.RotationFromOriginal.CW90, null); // Vertical

        board.setTile(new model.Position(0, 0), tileS1);
        board.setTile(new model.Position(1, 0), tileS2);

        // Créer et placer le pion
        model.Position initialPosition = new model.Position(0, 0);
        model.Player player = new model.Player(initialPosition , 1);
        List<model.Player> pawnlist = new ArrayList<>();
        pawnlist.add(player);

        // Afficher l'état initial du plateau
        System.out.println("État initial du plateau:");
        board.printBoard(pawnlist);



        // Essayer de déplacer le pion vers le bas
        if (player.move(model.Direction.DOWN, board)) {
            System.out.print("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible , il faut rotate.");
        }

        // Afficher l'état actuel du tableau de paths de TileS1
        System.out.println("État actuel du tableau de paths de TileS1: " + tileS1.displayPaths());


        // Rotater TileS1 et afficher le nouvel état de son tableau de paths
        tileS1.rotate();
        System.out.println("Nouvel état du tableau de paths de TileS1 après rotation: " + tileS1.displayPaths());

        // Réessayer de déplacer le pion vers le bas (on y arrive cette fois-ci)
        if (player.move(model.Direction.DOWN, board)) {
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