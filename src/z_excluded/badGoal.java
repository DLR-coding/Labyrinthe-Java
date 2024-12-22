package model;

public class badGoal {
    public int _numgoal;
    public String _imgPath;

    public badGoal(int numgoal) {
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
