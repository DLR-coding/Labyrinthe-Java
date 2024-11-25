public class Move {

    public static boolean movePawn(Pawn pawn, int direction, Board board) {
        Position newPosition = new Position(pawn.getPosition().getX(), pawn.getPosition().getY());
        switch (direction) {
            case 0: // Haut
                newPosition.setY(newPosition.getY() - 1);
                break;
            case 1: // Droite
                newPosition.setX(newPosition.getX() + 1);
                break;
            case 2: // Bas
                newPosition.setY(newPosition.getY() + 1);
                break;
            case 3: // Gauche
                newPosition.setX(newPosition.getX() - 1);
                break;
        }

        if (newPosition.getX() < 0 || newPosition.getX() >= 7 || newPosition.getY() < 0 || newPosition.getY() >= 7) {
            return false; // Hors des limites du plateau
        }

        Tiles currentTile = board.getTile(pawn.getPosition());
        Tiles newTile = board.getTile(newPosition);

        if (currentTile == null || newTile == null) {
            return false; // Pas de tuile à la position actuelle ou nouvelle
        }

        if (currentTile.isPathOpen(direction) && newTile.isPathOpen((direction + 2) % 4)) {
            pawn.setPosition(newPosition);
            return true;
        }

        return false;
    }

    public static void moveRow(Board board, int row, int direction) {
        // Implémentation du déplacement de ligne
        // direction: 0 pour haut, 1 pour bas
        if (direction == 0) {
            // Déplacer la ligne vers le haut
            for (int col = 0; col < 7; col++) {
                Tiles tile = board.getTile(new Position(row, col));
                board.setTile(new Position(row - 1, col), tile);
            }
        } else if (direction == 1) {
            // Déplacer la ligne vers le bas
            for (int col = 0; col < 7; col++) {
                Tiles tile = board.getTile(new Position(row, col));
                board.setTile(new Position(row + 1, col), tile);
            }
        }
    }

    public static void moveColumn(Board board, int column, int direction) {
        // Implémentation du déplacement de colonne
        // direction: 0 pour gauche, 1 pour droite
        if (direction == 0) {
            // Déplacer la colonne vers la gauche
            for (int row = 0; row < 7; row++) {
                Tiles tile = board.getTile(new Position(row, column));
                board.setTile(new Position(row, column - 1), tile);
            }
        } else if (direction == 1) {
            // Déplacer la colonne vers la droite
            for (int row = 0; row < 7; row++) {
                Tiles tile = board.getTile(new Position(row, column));
                board.setTile(new Position(row, column + 1), tile);
            }
        }
    }
}