import java.util.Arrays;

public class TileAngle extends Tile {
    public TileAngle(Orientation orientation, Goal goal) {
        super("Angle", orientation, goal, Arrays.asList(Direction.UP, Direction.RIGHT));
    }
}
