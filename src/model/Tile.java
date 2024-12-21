package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    // ! enlever le paramètre de rotation de tuile lorsqu'on le construit pcq on rotatera manuelllement
    public String type;
    public RotationFromOriginal rotationFromOriginal; // DEFAULT, CW90, CW180, CW270
    public Goals goal;
    public List<Direction> paths; // Liste des directions ouvertes

    public Tile(String type, RotationFromOriginal rotationFromOriginal, Goals goal, List<Direction> paths) {
        this.type = type;
        this.rotationFromOriginal = rotationFromOriginal;
        this.goal = goal;
        this.paths = rotatePaths(paths, rotationFromOriginal);
    }

    private List<Direction> rotatePaths(List<Direction> paths, RotationFromOriginal rotationFromOriginal) {
        List<Direction> rotatedPaths = new ArrayList<>();
        for (Direction direction : paths) {
            rotatedPaths.add(getRotatedDirection(direction, rotationFromOriginal));
        }
        return rotatedPaths;
    }

    private Direction getRotatedDirection(Direction direction, RotationFromOriginal rotationFromOriginal) {
        switch (rotationFromOriginal) {
            case DEFAULT:
                return direction;
            case CW90:
                return switch (direction) {
                    case UP -> Direction.RIGHT;
                    case RIGHT -> Direction.DOWN;
                    case DOWN -> Direction.LEFT;
                    case LEFT -> Direction.UP;
                };
            case CW180:
                return switch (direction) {
                    case UP -> Direction.DOWN;
                    case RIGHT -> Direction.LEFT;
                    case DOWN -> Direction.UP;
                    case LEFT -> Direction.RIGHT;
                };
            case CW270:
                return switch (direction) {
                    case UP -> Direction.LEFT;
                    case RIGHT -> Direction.UP;
                    case DOWN -> Direction.RIGHT;
                    case LEFT -> Direction.DOWN;
                };
            default:
                throw new IllegalArgumentException("Invalid rotationFromOriginal: " + rotationFromOriginal);
        }
    }

    public void rotate() {
        rotationFromOriginal = getNextOrientation(rotationFromOriginal);
        paths = rotatePaths(paths, rotationFromOriginal);
    }

    private RotationFromOriginal getNextOrientation(RotationFromOriginal rotationFromOriginal) {
        switch (rotationFromOriginal) {
            case DEFAULT:
                return RotationFromOriginal.CW90;
            case CW90:
                return RotationFromOriginal.CW180;
            case CW180:
                return RotationFromOriginal.CW270;
            case CW270:
                return RotationFromOriginal.DEFAULT;
            default:
                throw new IllegalArgumentException("Invalid rotationFromOriginal: " + rotationFromOriginal);
        }
    }

    public boolean isPathOpen(Direction direction) {
        return paths.contains(direction);
    }

    public String displayPaths() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Direction direction : Direction.values()) {
            if (isPathOpen(direction)) {
                switch (direction) {
                    case UP:
                        sb.append("↑ , ");
                        break;
                    case RIGHT:
                        sb.append("→ , ");
                        break;
                    case DOWN:
                        sb.append("↓ , ");
                        break;
                    case LEFT:
                        sb.append("← , ");
                        break;
                }
            } else {
                sb.append("x , ");
            }
        }
        sb.append("] ");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Tile{" +
                "type='" + type + '\'' +
                ", rotationFromOriginal=" + rotationFromOriginal +
                ", goal=" + goal +
                ", paths=" + displayPaths() +
                '}';
    }

    public Goals getGoal() {
        return goal;
    }

    public void setGoal(Goals goal) {
        this.goal = goal;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RotationFromOriginal getOrientation() {
        return rotationFromOriginal;
    }

    public void setOrientation(RotationFromOriginal rotationFromOriginal) {
        this.rotationFromOriginal = rotationFromOriginal;
        this.paths = rotatePaths(this.paths, rotationFromOriginal);
    }

    public List<Direction> getPaths() {
        return paths;
    }

    public void setPaths(List<Direction> paths) {
        this.paths = rotatePaths(paths, this.rotationFromOriginal);
    }
}
