public class TileFactory {


    public Tile createTileStraight(Orientation orientation, Goal goal) {
        return new TileStraight(orientation, goal);
    }

    public Tile createTileT(Orientation orientation, Goal goal) {
        return new TileT(orientation, goal);
    }

    public Tile createTileAngle(Orientation orientation, Goal goal) {
        return new TileAngle(orientation, goal);
    }
}
