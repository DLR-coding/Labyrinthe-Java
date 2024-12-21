package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Player;

public class PlayersPanel extends JPanel {
    public PlayersPanel(List<Player> players) {
        setLayout(new GridLayout(1, players.size()));
        updatePlayers(players);
    }

    // Met à jour l'affichage des joueurs
    public void updatePlayers(List<Player> players) {
        removeAll(); // Nettoyer les anciens composants
        for (Player player : players) {
            JPanel playerPanel = new JPanel();
            playerPanel.setBorder(BorderFactory.createTitledBorder("Joueur " + player._numPlayer));
            JLabel goalLabel = new JLabel("Objectif : " + player.getCurrentGoal());
            playerPanel.add(goalLabel);
            add(playerPanel);
        }
        revalidate();
        repaint();
    }
}
