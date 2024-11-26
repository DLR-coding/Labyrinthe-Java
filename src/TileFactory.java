public class TileFactory {

    public Tiles createTile_Straight(int orientation, Goal goal) {
        return new Tiles_Straight(orientation, goal);
    }

    public Tiles createTile_T(int orientation, Goal goal) {
        return new Tiles_T(orientation, goal);
    }

    public Tiles createTile_Angle(int orientation, Goal goal) {
        return new Tiles_Angle(orientation, goal);
    }
}
