package models;

import javax.swing.*;
import java.awt.*;

public class Pawn {
    private int _posX=0;
    private int _posY=0;
    private Image _image;
    public Pawn() {
        this._image = new ImageIcon("../img/pawn.png").getImage();
    }

    public int get_posX() {
        return _posX;
    }

    public int get_posY() {
        return _posY;
    }
    public void move(int x, int y) {
        this._posX = x;
        this._posY = y;
    }
}
