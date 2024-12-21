import java.util.Arrays;


public class TileAngle extends Tile {
    public TileAngle(RotationFromOriginal rotationFromOriginal, Goal goal) {
        super("Angle", rotationFromOriginal, goal, Arrays.asList(Direction.UP, Direction.RIGHT));
    }
}
