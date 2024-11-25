public class Main_Test1 {
    public static void main(String[] args) {
        Board board = new Board();
        // Créer les tuiles
        Tiles tile1 = new Tiles_Straight(0, null); // Horizontale
        Tiles tile2 = new Tiles_Straight(1, null); // Verticale


        board.setTile(new Position(0, 0), tile1);
        board.setTile(new Position(0, 1), tile2);


        // Créer un pion et le placer en position (0,0)
        Position initialPosition = new Position(0, 0);
        Pawn pawn = new Pawn(initialPosition);

        // Essayer de se déplacer vers le bas
        Move move = new Move(board, "pawn", 2, initialPosition); // 2 pour bas

        // Essayer de déplacer le pion
        if (pawn.move(move, board)) {
            System.out.println("Pion déplacé vers le bas.");
        } else {
            System.out.println("Déplacement vers le bas impossible.");
        }
    }
}
