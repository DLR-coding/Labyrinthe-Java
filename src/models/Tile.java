package models;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private boolean _estFixe;
    private Image _image;
    private int _x;
    private int _y;

    public Tile(boolean estFixe, String image) {
        _estFixe = estFixe;
        _image = new ImageIcon(image).getImage();
    }


}
