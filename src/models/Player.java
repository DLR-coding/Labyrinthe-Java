package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Pawn _pawn;
    private List<Card> _cards;
    private int _age;

    public Player() {
        _pawn = new Pawn();
        _cards = new ArrayList<Card>();
        _age = 0;
    }

    public int get_age() {
        return _age;
    }

    public Pawn get_pawn() {
        return _pawn;
    }

    public List<Card> get_cards() {
        return _cards;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public void set_cards(List<Card> _cards) {
        this._cards = _cards;
    }

    public void set_pawn(Pawn _pawn) {
        this._pawn = _pawn;
    }
}
