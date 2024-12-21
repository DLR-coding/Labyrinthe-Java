package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {
    public BoardPanel boardPanel;
    public ExtraTilePanel extraTilePanel;
    public PlayersPanel playersPanel;

    public Game game;

    public MainUI(Game game) {
        this.game = game;

        setTitle("Labyrinth Game - MVC View");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialisation des composants
        boardPanel = new BoardPanel(game._board._tiles);
        extraTilePanel = new ExtraTilePanel(game._board._extraTile);
        playersPanel = new PlayersPanel(game._board._players);

        // Ajout des composants
        add(boardPanel, BorderLayout.CENTER);
        add(extraTilePanel, BorderLayout.NORTH);
        add(playersPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void updateView() {
        boardPanel.updateTiles(game._board._tiles);
        extraTilePanel.updateTile(game._board._extraTile);
        playersPanel.updatePlayers(game._board._players);
    }

}





