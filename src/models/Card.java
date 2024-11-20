package models;

import javax.swing.*;
import java.awt.*;

public class Card {
    private String _background_path;
    private Image _image;

    public Card(String background_path) {
        _image = new ImageIcon(background_path).getImage();
    }
    public boolean isAccessible(){
        return false;
    }
}
