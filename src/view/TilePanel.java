package view;

import javax.swing.*;
import java.awt.*;
import model.Tile;

public class TilePanel extends JPanel {
    private Tile _tile;

    public TilePanel(Tile tile) {
        this._tile = tile;
    }

    public void set_tile(Tile _tile) {
        this._tile = _tile;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (_tile != null) {
            String imagePath = getImagePath(_tile.type);
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private String getImagePath(String type) {
        switch (type) {
            case "Straight": return "src/img/tuile_line.png";
            case "T": return "src/img/tuile_T.png";
            case "Angle": return "src/img/tuile_angle.png";
            default: return "src/img/tile_default.png";
        }
    }
}

