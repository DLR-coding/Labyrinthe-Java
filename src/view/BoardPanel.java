package view;

import javax.swing.*;
import java.awt.*;
import model.Tile;

public class BoardPanel extends JPanel {
    private TilePanel[][] tilePanels;

    public BoardPanel(Tile[][] tiles) {
        setLayout(new GridLayout(7, 7));
        tilePanels = new TilePanel[7][7];

        // Création des panneaux pour chaque tuile
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tilePanels[i][j] = new TilePanel(tiles[i][j]);
                add(tilePanels[i][j]);
            }
        }
    }

    // Met à jour les tuiles affichées
    public void updateTiles(Tile[][] tiles) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tilePanels[i][j].set_tile(tiles[i][j]);
                tilePanels[i][j].repaint();
            }
        }
    }
}

