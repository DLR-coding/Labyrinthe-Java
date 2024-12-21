package model;

import java.util.Random;

public class TileFactory {


    public Tile createTileStraight(RotationFromOriginal rotationFromOriginal, Goals goal) {
        return new TileStraight(rotationFromOriginal, goal);
    }

    public Tile createTileT(RotationFromOriginal rotationFromOriginal, Goals goal) {
        return new TileT(rotationFromOriginal, goal);
    }

    public Tile createTileAngle(RotationFromOriginal rotationFromOriginal, Goals goal) {
        return new TileAngle(rotationFromOriginal, goal);
    }


    public Tile createRandomTile(Goals goal) {
        Random ran = new Random();
        RotationFromOriginal rotationFromOriginal = RotationFromOriginal.values()[ran.nextInt(5)];
        int type = ran.nextInt(3);
        switch (type) {
            case 0:
                return createTileStraight(rotationFromOriginal, goal);
            case 1:
                return createTileT(rotationFromOriginal, goal);
            case 2:
                return createTileAngle(rotationFromOriginal, goal);
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

}
