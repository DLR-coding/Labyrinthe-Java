import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameUI extends JFrame {
    private JPanel game;
    private JPanel board;
    private JLabel[][] tiles;

    private JLabel extraTile;

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
                Random rand = new Random();
                int tiletype = rand.nextInt(3);
                ImageIcon icon = new ImageIcon();
                if(tiletype == 0){
                    icon = new ImageIcon("src/img/tiles/tile_angle.jpeg");
                }
                else if(tiletype == 1){
                    icon = new ImageIcon("src/img/tiles/tile_straight.jpeg");
                }
                else{
                    icon = new ImageIcon("src/img/tiles/tile_T.jpeg");
                }
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

    public static void setImage(JLabel tile, BufferedImage image){
        tile.setIcon(new ImageIcon(image));
    }

    public static void rotateTileClockwise(JLabel tile){
        setImage(tile, ImageHelper.rotateClockwise((BufferedImage)tile.getIcon()));
    }

    public static void rotateTileTrig(JLabel tile){
        setImage(tile, ImageHelper.rotateCounterClockwise((BufferedImage)tile.getIcon()));
    }

    private void moveRow(int row, Orientation direction){
        if(direction == Orientation.EAST){
            ImageIcon tempIcon = (ImageIcon) this.tiles[row][6].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    tiles[row][i].setIcon(this.extraTile.getIcon());
                }
                else{
                    tiles[row][i].setIcon(tiles[row][i-1].getIcon());
                }
                this.extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Orientation.WEST){
            ImageIcon tempIcon = (ImageIcon) this.tiles[row][0].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    tiles[row][i].setIcon(this.extraTile.getIcon());
                }
                else{
                    tiles[row][i].setIcon(tiles[row][i+1].getIcon());
                }
                this.extraTile.setIcon(tempIcon);
            }
        }
        else{

        }

    }

    private void moveColumn(int column, Orientation direction){
        if(direction == Orientation.SOUTH){
            ImageIcon tempIcon = (ImageIcon) this.tiles[6][column].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    tiles[i][column].setIcon(this.extraTile.getIcon());
                }
                else{
                    tiles[i][column].setIcon(tiles[i-1][column].getIcon());
                }
                this.extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Orientation.NORTH){
            ImageIcon tempIcon = (ImageIcon) this.tiles[0][column].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    tiles[i][column].setIcon(this.extraTile.getIcon());
                }
                else{
                    tiles[i][column].setIcon(tiles[i+1][column].getIcon());
                }
                this.extraTile.setIcon(tempIcon);
            }
        }
        else{

        }
    }

    public void replicateBoard(){

    }

    public void tileToLabel(Tile tile, JLabel label){
        switch(tile.type){
            case "T":
                if(tile.goal != null){
                    label.setIcon(merge());
                }
                else{

                }
            case "Straight":
                if(){

                }
                else{

                }
            case "Angle":
                if(){

                }
                else{

                }
        }
    }

    public static void main(String[] args) {
        GameUI gui = new GameUI();
    }





}
