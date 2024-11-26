public class Pawn {
    private Position _position;

    public Pawn(Position position) {
        this._position = position;
    }

    public boolean move(int direction, Board board) {
        if (isMoveValid(direction, board)) {
            switch (direction) {
                case 0: // Haut
                    _position.setY(_position.getY() - 1);
                    break;
                case 1: // Droite
                    _position.setX(_position.getX() + 1);
                    break;
                case 2: // Bass
                    _position.setY(_position.getY() + 1);
                    break;
                case 3: // Gauche
                    _position.setX(_position.getX() - 1);
                    break;
            }
            return true;
        }
        return false;
    }

    public boolean isMoveValid(int direction, Board board) {
        Position newPosition = new Position(_position.getX(), _position.getY());
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

        Tiles currentTile = board.getTile(_position);
        Tiles newTile = board.getTile(newPosition);

        if (currentTile == null || newTile == null) {
            return false; // Pas de tuile à la _position actuelle ou nouvelle
        }

        return currentTile.isPathOpen(direction) && newTile.isPathOpen((direction + 2) % 4);
    }

    public Position get_position() {
        return _position;
    }

    public void set_position(Position position) {
        this._position = position;
    }
}