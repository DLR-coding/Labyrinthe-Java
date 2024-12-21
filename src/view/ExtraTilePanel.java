package view;

import javax.swing.*;
import java.awt.*;
import model.Tile;

public class ExtraTilePanel extends JPanel {
    private TilePanel extraTilePanel;

    public ExtraTilePanel(Tile extraTile) {
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Tuile Supplémentaire");
        extraTilePanel = new TilePanel(extraTile);
        extraTilePanel.setPreferredSize(new Dimension(60, 60));

        add(label);
        add(extraTilePanel);
    }

    // Met à jour la tuile supplémentaire affichée
    public void updateTile(Tile newTile) {
        extraTilePanel.set_tile(newTile);
        extraTilePanel.repaint();
    }
}

