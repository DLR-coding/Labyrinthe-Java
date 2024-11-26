import java.util.ArrayList;

public abstract class Tiles {
    protected String type;
    protected int orientation; // 0 pour 0 degrés, 1 pour 90 degrés, 2 pour 180 degrés, 3 pour 270 degrés
    protected Goal goal;
    protected ArrayList<Boolean> paths; // paths[0] = haut, paths[1] = droite, paths[2] = bas, paths[3] = gauche

    public Tiles(String type, int orientation, Goal goal, ArrayList<Boolean> paths) {
        this.type = type;
        this.orientation = orientation;
        this.goal = goal;
        this.paths = paths;
    }




    public void rotate() { //  ! Rotation de 90 degrés -> on peut faire avec param int degré ou donner param nbfois_rotate
        ArrayList<Boolean> newPaths = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            newPaths.add(paths.get((i + 1) % 4));
        }
        paths = newPaths;
        orientation = (orientation + 1) % 4;
    }

    public boolean isPathOpen(int direction) {
        return paths.get(direction);
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public ArrayList<Boolean> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Boolean> paths) {
        this.paths = paths;
    }
}