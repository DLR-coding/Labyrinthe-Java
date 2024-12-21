package model;

import java.util.Arrays;


public class TileAngle extends Tile {
    public TileAngle(RotationFromOriginal rotationFromOriginal, Goals goal) {
        super("Angle", rotationFromOriginal, goal, Arrays.asList(Direction.UP, Direction.RIGHT));
    }
}
