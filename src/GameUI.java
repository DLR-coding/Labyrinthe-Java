import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {
    private JPanel game;
    private JPanel board;
    private JLabel[][] tiles;

    public GameUI(){
        this.setSize(1200, 1200);
        game = new JPanel(new GridBagLayout());
        board = new JPanel(new GridLayout(7,7));
        this.add(game);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        c.gridx = 1;
        game.add(board, c);
        tiles = new JLabel[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                ImageIcon icon = new ImageIcon("src/img/tuile_angle.png");
                icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                tiles[i][j] = new JLabel();
                tiles[i][j].setSize(80, 80);
                tiles[i][j].setIcon(icon);
                board.add(tiles[i][j]);
            }
        }


        JPanel buttonsTop = new JPanel(new GridLayout(1,3));
        buttonsTop.add(new JButton("topBtn0"));
        buttonsTop.add(new JButton("topBtn1"));
        buttonsTop.add(new JButton("topBtn2"));
        c.weightx= 0.1;
        c.weighty= 0.1;
        c.gridy = 0;
        game.add(buttonsTop, c);

        JPanel buttonsBtm = new JPanel(new GridLayout(1,3));
        buttonsBtm.add(new JButton("btmBtn0"));
        buttonsBtm.add(new JButton("btmBtn1"));
        buttonsBtm.add(new JButton("btmBtn2"));
        c.weightx= 0.1;
        c.weighty= 0.1;
        c.gridy = 2;
        game.add(buttonsBtm, c);

        JPanel buttonsLeft = new JPanel(new GridLayout(3,1));
        buttonsLeft.add(new JButton("leftBtn0"));
        buttonsLeft.add(new JButton("leftBtn1"));
        buttonsLeft.add(new JButton("leftBtn2"));
        c.weightx= 0.1;
        c.weighty= 0.1;
        c.gridx = 0;
        c.gridy = 1;
        game.add(buttonsLeft, c);

        JPanel buttonsRight = new JPanel(new GridLayout(3,1));
        buttonsRight.add(new JButton("rightBtn0"));
        buttonsRight.add(new JButton("rightBtn1"));
        buttonsRight.add(new JButton("rightBtn2"));
        c.weightx= 0.1;
        c.weighty= 0.1;
        c.gridx = 2;
        game.add(buttonsRight, c);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        GameUI gui = new GameUI();
    }





}
