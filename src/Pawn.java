public class Pawn {
    private Position _position;

    public Pawn(Position position) {
        this._position = position;
    }

    public boolean move(Direction direction, Board board) {
        Position newPosition = new Position(this._position.getRow(), this._position.getColumn());
        switch (direction) {
            case UP:
                newPosition.setRow(newPosition.getRow() - 1);
                break;
            case RIGHT:
                newPosition.setColumn(newPosition.getColumn() + 1);
                break;
            case DOWN:
                newPosition.setRow(newPosition.getRow() + 1);
                break;
            case LEFT:
                newPosition.setColumn(newPosition.getColumn() - 1);
                break;
        }

        if (newPosition.getRow() < 0 || newPosition.getRow() >= 7 || newPosition.getColumn() < 0 || newPosition.getColumn() >= 7) {
            return false; // Hors des limites du plateau
        }

        Tile currentTile = board.getTile(this._position);
        Tile newTile = board.getTile(newPosition);

        if (currentTile == null || newTile == null) {
            return false; // Pas de tuile à la position actuelle ou nouvelle
        }

        if (currentTile.isPathOpen(direction) && newTile.isPathOpen(getOppositeDirection(direction))) {
            this._position = newPosition;
            return true;
        }

        return false;
    }

    private Direction getOppositeDirection(Direction direction) {
        switch (direction) {
            case UP:
                return Direction.DOWN;
            case RIGHT:
                return Direction.LEFT;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    public Position getPosition() {
        return _position;
    }

    public void set_position(Position position) {
        this._position = position;
    }
}