package model;

import view.MainUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Game {
    public Board _board;
    public List<badGoal> _allGoals;
    public boolean _isfinished;


    public Game() {
        this._board = new Board();
        this._allGoals = new ArrayList<>();
        this._isfinished = false;
    }

    public void startGame() {
        // Initialiser le plateau et les joueurs
        System.out.println("Chargement...");
        initializeBoard();
        initializePlayers();
        this._board.printBoard();
        // Lancer la partie
        System.out.println("La partie commence !");



        this._board.printBoard();


        /*
        while (true) {
            // Tour de jeu


        }
         */


    }

    public void endGame() {
        // Terminer la partie
    }

    public void initializeBoard() {
        System.out.println("Initialisation du plateau...");
        // Initialiser le plateau avec des tuiles et des objectifs
        TileFactory tileFactory = new TileFactory();

        // placer Tuiles fixes d'abord
        // Ligne 0
        Tile tile = tileFactory.createTileAngle(RotationFromOriginal.CW90, Goals.G1);
        _board.setTile(new Position(0, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, Goals.G2);
        _board.setTile(new Position(0, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, Goals.G3);
        _board.setTile(new Position(0, 4), tile);
        tile = tileFactory.createTileAngle(RotationFromOriginal.CW180, Goals.G4);
        _board.setTile(new Position(0, 6), tile);

        // Ligne 2
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, Goals.G4);
        _board.setTile(new Position(2, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, Goals.G5);
        _board.setTile(new Position(2, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW90, Goals.G6);
        _board.setTile(new Position(2, 4), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, Goals.G7);
        _board.setTile(new Position(2, 6), tile);

        // Ligne 4
        tile = tileFactory.createTileT(RotationFromOriginal.DEFAULT, Goals.G8);
        _board.setTile(new Position(4, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, Goals.G9);
        _board.setTile(new Position(4, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, Goals.G10);
        _board.setTile(new Position(4, 4), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW180, Goals.G11);
        _board.setTile(new Position(4, 6), tile);

        // Ligne 6
        tile = tileFactory.createTileStraight(RotationFromOriginal.DEFAULT, Goals.G1);
        _board.setTile(new Position(6, 0), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, Goals.G2);
        _board.setTile(new Position(6, 2), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, Goals.G3);
        _board.setTile(new Position(6, 4), tile);
        tile = tileFactory.createTileAngle(RotationFromOriginal.CW270, Goals.G1);
        _board.setTile(new Position(6, 6), tile);

        //////// Tuiles non fixes   ////////
        tile = tileFactory.createTileT(RotationFromOriginal.CW90, Goals.G1);
        _board.setTile(new Position(0, 1), tile);
        tile = tileFactory.createTileT(RotationFromOriginal.CW270, Goals.G12);
        _board.setTile(new Position(1, 1), tile);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (_board.getTile(new model.Position(i, j)) == null) { // Si la tuile n'existe pas encore
                    int randomInt = new Random().nextInt(12) + 13; // G13 to G24
                    Goals randomGoal = Goals.values()[randomInt];
                    tile = tileFactory.createRandomTile(randomGoal);

                    System.out.println("\u001B[31m" + "Tile created at (" + i + ", " + j + "): " + tile.toString() + "\u001B[0m");

                }
            }
        }
        System.out.println("Initialisation du plateau terminée.");
    }


    public void initializePlayers() {
        // Initialiser les joueurs avec des objectifs
        Player player1 = new Player(new Position(0, 0) , 1);
        Player player2 = new Player(new Position(0, 6) , 2);
        Player player3 = new Player(new Position(6, 0) , 3);
        Player player4 = new Player(new Position(6, 6) , 4);

        player1._goalsList = new Stack<>();
        for (int i = 1; i <= 6; i++) {
            player1._goalsList.push(Goals.values()[i]);
        }

        player2._goalsList = new Stack<>();
        for (int i = 7; i <= 12; i++) {
            player2._goalsList.push(Goals.values()[i]);
        }

        player3._goalsList = new Stack<>();
        for (int i = 13; i <= 18; i++) {
            player3._goalsList.push(Goals.values()[i]);
        }

        player4._goalsList = new Stack<>();
        for (int i = 19; i <= 24; i++) {
            player4._goalsList.push(Goals.values()[i]);
        }

        this._board._players.add(player1); this._board._players.add(player2); this._board._players.add(player3); this._board._players.add(player4);
    }



    public void addObserver(MainUI ui) {



    }
}