import java.util.Arrays;

public class TileStraight extends Tile {
    public TileStraight(Orientation orientation, Goal goal) {
        super("Straight", orientation, goal, Arrays.asList(Direction.RIGHT, Direction.LEFT));
    }
}
