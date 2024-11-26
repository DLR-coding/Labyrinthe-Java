public class Pawn {
    private Position _position;

    public Pawn(Position position) {
        this._position = position;
    }

    public boolean move(Direction direction, Board board) {
        if (isMoveValid(direction, board)) {
            switch (direction) {
                case UP: // Haut
                    _position.setY(_position.getY() - 1);
                    break;
                case RIGHT: // Droite
                    _position.setX(_position.getX() + 1);
                    break;
                case DOWN: // Bas
                    _position.setY(_position.getY() + 1);
                    break;
                case LEFT: // Gauche
                    _position.setX(_position.getX() - 1);
                    break;
            }
            return true;
        }
        return false;
    }

    public boolean isMoveValid(Direction direction, Board board) {
        Position newPosition = new Position(_position.getX(), _position.getY());
        switch (direction) {
            case UP: // Haut
                newPosition.setY(newPosition.getY() - 1);
                break;
            case RIGHT: // Droite
                newPosition.setX(newPosition.getX() + 1);
                break;
            case DOWN: // Bas
                newPosition.setY(newPosition.getY() + 1);
                break;
            case LEFT: // Gauche
                newPosition.setX(newPosition.getX() - 1);
                break;
        }

        if (newPosition.getX() < 0 || newPosition.getX() >= 7 || newPosition.getY() < 0 || newPosition.getY() >= 7) {
            return false; // Hors des limites du plateau
        }

        Tiles currentTile = board.getTile(_position);
        Tiles newTile = board.getTile(newPosition);

        if (newTile == null) {
            return false; // Pas de tuile à la _position nouvelle
        }

        return currentTile.isPathOpen(direction) && newTile.isPathOpen(Direction.values()[(direction.ordinal() + 2) % 4]);
    }

    public Position getPosition() {
        return _position;
    }

    public void set_position(Position position) {
        this._position = position;
    }
}