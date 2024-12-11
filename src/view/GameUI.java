package view;

import javax.swing.*;

import java.awt.*;

public class GameUI extends JFrame {
    public JPanel mainPanel;
    public JPanel boardPanel;
    public JLabel[][] tiles;

    public GameUI() {
        // Initialiser le tableau de tiles
        tiles = new JLabel[7][7];

        // Configurer le boardPanel avec un GridLayout de 7x7
        boardPanel.setLayout(new GridLayout(7, 7));

        // Ajouter les tiles au boardPanel
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                tiles[i][j] = new JLabel();
                tiles[i][j].setIcon(new ImageIcon("path/to/your/image.png")); // Remplacez par le chemin de votre image
                boardPanel.add(tiles[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GameUI");
        frame.setContentPane(new GameUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
