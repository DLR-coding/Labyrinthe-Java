package controllers;

import models.Tile;
import view.Map;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Map fenetre = new Map();
        // Définir les dimensions de la fenêtre
        fenetre.setSize(800, 800);

        // Indiquer quoi faire quand on ferme la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrer la fenêtre à l'écran
        fenetre.setLocationRelativeTo(null);

        // Rendre la fenêtre visible
        fenetre.setVisible(true);

        // Géneration des tuiles **************************************
        List<Tile> _lst_tiles = new ArrayList<Tile>();

    }
}
