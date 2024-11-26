import java.util.ArrayList;

public abstract class Tiles {
    protected String _type;
    // _orientation utile lorsqu'on génère les Tiles. Pour savoir cmb de fois ont rotate() leur init paths
    protected int orientation; // 0 pour 0 degrés, 1 pour 90 degrés, 2 pour 180 degrés, 3 pour 270 degrés
    protected Goal _goal;
    protected ArrayList<Boolean> paths; // paths[0] = haut, paths[1] = droite, paths[2] = bas, paths[3] = gauche

    public Tiles(String type, int orientation, Goal goal, ArrayList<Boolean> paths) {
        this._type = type;
        this.orientation = orientation;
        this._goal = goal;
        this.paths = paths;
    }




    public void rotate() {
        ArrayList<Boolean> newPaths = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            newPaths.add(paths.get((i + 1) % 4));
        }
        paths = newPaths;
    }

    public boolean isPathOpen(Direction direction) {
        int index = direction.ordinal(); // ordinal() c "le num d'index" dans l'enum direction
        return paths.get(index);
    }

    // Getters and setters
    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Goal get_goal() {
        return _goal;
    }

    public void set_goal(Goal _goal) {
        this._goal = _goal;
    }

    public ArrayList<Boolean> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Boolean> paths) {
        this.paths = paths;
    }

    public String getDisplayPaths() {
        String sb = (paths.get(Direction.UP.ordinal()) ? " ↑ ," : " x ,") + // Haut
                (paths.get(Direction.RIGHT.ordinal()) ? " → ," : " x ,") + // Droite
                (paths.get(Direction.DOWN.ordinal()) ? " ↓ ," : " x ,") + // Bas
                (paths.get(Direction.LEFT.ordinal()) ? " ← ," : " x ,"); // Gauche
        return sb;
    }
}