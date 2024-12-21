public class Goal {
    public int _numgoal;
    public String _imgPath;

    public Goal(int numgoal) {
        this._numgoal = numgoal;
        this._imgPath = "G" + numgoal + ".png";
    }

    // Getters and setters
    public int getNumGoal() {
        return _numgoal;
    }

    public void setNumGoal(int numgoal) {
        this._numgoal = numgoal;
    }
}
