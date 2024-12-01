import java.util.ArrayList;
import java.util.List;

public class Player {
    private int _numPlayer;
    private String _name;
    private Pawn _pawn;
    private List<Goal> _goalsList;

    public Player(int numPlayer, Pawn pawn, List<Goal> goals) {
        this._numPlayer = numPlayer;
        this._name = "Player " + numPlayer;
        this._pawn = pawn;
        this._goalsList = new ArrayList<>(goals);
    }

    public Player(int numPlayer, String name, Pawn pawn, List<Goal> goals) {
        this._numPlayer = numPlayer;
        this._name = name;
        this._pawn = pawn;
        this._goalsList = new ArrayList<>(goals);
    }

    public int getNumPlayer() {
        return _numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this._numPlayer = numPlayer;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Pawn get_pawn() {
        return _pawn;
    }

    public void set_pawn(Pawn _pawn) {
        this._pawn = _pawn;
    }

    public List<Goal> get_goalsList() {
        return _goalsList;
    }

    public void set_goalsList(List<Goal> _goalsList) {
        this._goalsList = _goalsList;
    }

    public void achieveGoal(Goal goal) {
        _goalsList.remove(goal);
    }

    public boolean hasAchievedAllGoals() {
        return _goalsList.isEmpty();
    }


}