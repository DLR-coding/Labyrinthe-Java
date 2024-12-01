import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    public String type;
    public Orientation orientation; // NORTH, EAST, SOUTH, WEST
    public Goal goal;
    public List<Direction> paths; // Liste des directions ouvertes

    public Tile(String type, Orientation orientation, Goal goal, List<Direction> paths) {
        this.type = type;
        this.orientation = orientation;
        this.goal = goal;
        this.paths = rotatePaths(paths, orientation);
    }

    private List<Direction> rotatePaths(List<Direction> paths, Orientation orientation) {
        List<Direction> rotatedPaths = new ArrayList<>();
        for (Direction direction : paths) {
            rotatedPaths.add(getRotatedDirection(direction, orientation));
        }
        return rotatedPaths;
    }

    private Direction getRotatedDirection(Direction direction, Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return direction;
            case EAST:
                return switch (direction) {
                    case UP -> Direction.RIGHT;
                    case RIGHT -> Direction.DOWN;
                    case DOWN -> Direction.LEFT;
                    case LEFT -> Direction.UP;
                };
            case SOUTH:
                return switch (direction) {
                    case UP -> Direction.DOWN;
                    case RIGHT -> Direction.LEFT;
                    case DOWN -> Direction.UP;
                    case LEFT -> Direction.RIGHT;
                };
            case WEST:
                return switch (direction) {
                    case UP -> Direction.LEFT;
                    case RIGHT -> Direction.UP;
                    case DOWN -> Direction.RIGHT;
                    case LEFT -> Direction.DOWN;
                };
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
    }

    public void rotate() {
        orientation = getNextOrientation(orientation);
        paths = rotatePaths(paths, orientation);
    }

    private Orientation getNextOrientation(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return Orientation.EAST;
            case EAST:
                return Orientation.SOUTH;
            case SOUTH:
                return Orientation.WEST;
            case WEST:
                return Orientation.NORTH;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
    }

    public boolean isPathOpen(Direction direction) {
        return paths.contains(direction);
    }

    public String getDisplayPaths() {
        StringBuilder sb = new StringBuilder();
        for (Direction direction : Direction.values()) {
            if (paths.contains(direction)) {
                sb.append(direction.toString().charAt(0));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        this.paths = rotatePaths(this.paths, orientation);
    }

    public List<Direction> getPaths() {
        return paths;
    }

    public void setPaths(List<Direction> paths) {
        this.paths = rotatePaths(paths, this.orientation);
    }
}
