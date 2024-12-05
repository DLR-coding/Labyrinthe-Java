import java.util.ArrayList;
import java.util.List;

public class Player2 {
    public int _numPlayer;
    public String _name;
    public Player _player;
    public List<Goal> _goalsList;

    public Player2(int numPlayer, Player player, List<Goal> goals) {
        this._numPlayer = numPlayer;
        this._name = "Player " + numPlayer;
        this._player = player;
        this._goalsList = new ArrayList<>(goals);
    }

    public Player2(int numPlayer, String name, Player player, List<Goal> goals) {
        this._numPlayer = numPlayer;
        this._name = name;
        this._player = player;
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

    public Player get_pawn() {
        return _player;
    }

    public void set_pawn(Player _player) {
        this._player = _player;
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