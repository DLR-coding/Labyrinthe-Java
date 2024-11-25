public class Pawn {
    private Position _position;

    public Pawn(Position position) {
        this.position = position;
    }

    public boolean move(Move move, Board board) {
        if (isMoveValid(move, board)) {
            switch (move.getDirection()) {
                case 0: // Haut
                    position.setY(position.getY() - 1);
                    break;
                case 1: // Droite
                    position.setX(position.getX() + 1);
                    break;
                case 2: // Bas
                    position.setY(position.getY() + 1);
                    break;
                case 3: // Gauche
                    position.setX(position.getX() - 1);
                    break;
            }
            return true;
        }
        return false;
    }

    public boolean isMoveValid(Move move, Board board) {
        Position newPosition = new Position(position.getX(), position.getY());
        switch (move.getDirection()) {
            case 0: // HautS
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

        Tiles currentTile = board.getTile(position);
        Tiles newTile = board.getTile(newPosition);

        if (currentTile == null || newTile == null) {
            return false; // Pas de tuile à la position actuelle ou nouvelle
        }

        return currentTile.isPathOpen(move.getDirection()) && newTile.isPathOpen((move.getDirection() + 2) % 4);
    }



    // Getters and setters
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}