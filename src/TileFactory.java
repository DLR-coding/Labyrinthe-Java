
public class TileFactory {


    public Tile createTileStraight(RotationFromOriginal rotationFromOriginal, Goal goal) {
        return new TileStraight(rotationFromOriginal, goal);
    }

    public Tile createTileT(RotationFromOriginal rotationFromOriginal, Goal goal) {
        return new TileT(rotationFromOriginal, goal);
    }

    public Tile createTileAngle(RotationFromOriginal rotationFromOriginal, Goal goal) {
        return new TileAngle(rotationFromOriginal, goal);
    }

    /*
    public Tile createRandomTile(Goal goal)
    {
        int type = random(0~2);
        if(type = 0 ) {
            return createTileStraight(random orientation , goal);
        }
        if ()
        // ....

    }

     */
}
