import java.util.Arrays;

public class TileT extends Tile {
    public TileT(Orientation orientation, Goal goal) {
        super("T", orientation, goal, Arrays.asList(Direction.UP, Direction.RIGHT, Direction.DOWN));
    }
}
