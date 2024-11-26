public class TileFactory {
    public Tiles createTile(String type, int orientation, Goal goal) {
        if (type.equals("Straight")) {
            return new Tiles_Straight(orientation, goal);
        } else if (type.equals("T")) {
            return new Tiles_T(orientation, goal);
        } else if (type.equals("Angle")) {
            return new Tiles_Angle(orientation, goal);
        }
        return null;
    }
}
