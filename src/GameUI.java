import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameUI extends JFrame {
    private final JPanel game;
    private JPanel board;
    private JLabel[][] tiles;

    private JLabel _extraTile;

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
                tiles[i][j] = new JLabel();
                tiles[i][j].setSize(80, 80);
                board.add(tiles[i][j]);
            }
        }
        this._extraTile = new JLabel();
        _extraTile.setSize(80,80);


        JPanel buttonsTop = new JPanel(new GridLayout(1,3));
        buttonsTop.add(new JButton("topBtn0"));
        buttonsTop.add(new JButton("topBtn1"));
        buttonsTop.add(new JButton("topBtn2"));
        c.weightx= 1;
        c.weighty= 1;
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

    private void moveRow(int row, Direction direction) throws Exception {
        if(direction == Direction.RIGHT){
            ImageIcon tempIcon = (ImageIcon) this.tiles[row][6].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    tiles[row][i].setIcon(this._extraTile.getIcon());
                }
                else{
                    tiles[row][i].setIcon(tiles[row][i-1].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Direction.LEFT){
            ImageIcon tempIcon = (ImageIcon) this.tiles[row][0].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    tiles[row][i].setIcon(this._extraTile.getIcon());
                }
                else{
                    tiles[row][i].setIcon(tiles[row][i+1].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else{
            throw new Exception("Failure moving row. invalid direction");
        }

    }

    private void moveColumn(int column, Direction direction) throws Exception {
        if(direction == Direction.DOWN){
            ImageIcon tempIcon = (ImageIcon) this.tiles[6][column].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    tiles[i][column].setIcon(this._extraTile.getIcon());
                }
                else{
                    tiles[i][column].setIcon(tiles[i-1][column].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Direction.UP){
            ImageIcon tempIcon = (ImageIcon) this.tiles[0][column].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    tiles[i][column].setIcon(this._extraTile.getIcon());
                }
                else{
                    tiles[i][column].setIcon(tiles[i+1][column].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else{
            throw new Exception("Failure moving column. invalid direction");
        }
    }

    public void replicateBoard(Tile[][] board, Tile extratile) throws IOException {
        int i = 0;
        int j = 0;
        for(Tile[] row : board){
            for(Tile tile : row){
                tileToLabel(tile, tiles[i][j]);
                j++;
            }
            j=0;
            i++;
        }
        tileToLabel(extratile, this._extraTile);
    }

    public void tileToLabel(Tile tile, JLabel label) throws IOException {
        switch(tile.type){
            case "T":
                if(tile.goal != null){
                    label.setIcon((Icon) ImageHelper.merge("src/img/tiles/tile_T.jpeg", "src/img/goals/" + tile.goal._imgPath).getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                }
                else{
                    label.setIcon(new ImageIcon("src/img/tiles/tile_T.jpeg"));
                }
                break;
            case "Straight":
                if(tile.goal != null){
                    label.setIcon((Icon) ImageHelper.merge("src/img/tiles/tile_Straight.jpeg", "src/img/goals/" + tile.goal._imgPath).getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                }
                else{
                    label.setIcon(new ImageIcon("src/img/tiles/tile_Straight.jpeg"));
                }
                break;
            case "Angle":
                if(tile.goal != null){
                    label.setIcon((Icon) ImageHelper.merge("src/img/tiles/tile_Angle.jpeg", "src/img/goals/" + tile.goal._imgPath).getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                }
                else{
                    label.setIcon(new ImageIcon("src/img/tiles/tile_Angle.jpeg"));
                }
                break;
        }
        switch (tile.rotationFromOriginal){
            case CW90:
                 rotateTileClockwise(label);
                 break;
            case CW180:
                rotateTileClockwise(label);
                rotateTileClockwise(label);
                break;
            case CW270:
                rotateTileClockwise(label);
                rotateTileClockwise(label);
                rotateTileClockwise(label);
                break;
            default:
                break;
        }
    }




}
