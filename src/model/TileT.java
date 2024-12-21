package model;

import java.util.Arrays;

public class TileT extends Tile {
    public TileT(RotationFromOriginal rotationFromOriginal, Goals goal) {
        super("T", rotationFromOriginal, goal, Arrays.asList(Direction.UP, Direction.RIGHT, Direction.DOWN));
    }
}
