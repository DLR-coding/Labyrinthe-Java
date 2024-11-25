package controllers;

import java.util.List;


public class Game {
    private Board board;
    private List<Pawn> pawns;

    public Game() {
        this.board = new Board();
        this.pawns = new ArrayList<>();
    }

    public void startGame() {
        // Initialiser le plateau et les pions
    }

    public void endGame() {
        // Terminer la partie
    }

    // Getters and setters
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public void setPawns(List<Pawn> pawns) {
        this.pawns = pawns;
    }
}
