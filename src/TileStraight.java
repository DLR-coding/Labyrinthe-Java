import java.util.Arrays;

public class TileStraight extends Tile {
    public TileStraight(RotationFromOriginal rotationFromOriginal, Goal goal) {
        super("Straight", rotationFromOriginal, goal, Arrays.asList(Direction.RIGHT, Direction.LEFT));
    }
}
