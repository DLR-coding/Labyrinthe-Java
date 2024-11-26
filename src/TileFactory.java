public class TileFactory {

    public Tiles createTile_Straight(int orientation, Goal goal) {
        return new Tiles_Straight(orientation, goal);
    }

    public Tiles createT(int orientation, Goal goal) {
        return new Tiles_T(orientation, goal);
    }

    public Tiles createAngle(int orientation, Goal goal) {
        return new Tiles_Angle(orientation, goal);
    }
}
