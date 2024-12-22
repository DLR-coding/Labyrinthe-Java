package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameUI extends JFrame {
    private final JPanel _game;
    private JPanel _board;
    private JLabel[][] _tiles;

    private JLabel _extraTile;

    public GameUI(){
        this.setSize(1200, 1200);
        _game = new JPanel(new GridBagLayout());
        _board = new JPanel(new GridLayout(7,7));
        this.add(_game);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridy = 1;
        c.gridx = 1;
        _game.add(_board, c);
        _tiles = new JLabel[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                _tiles[i][j] = new JLabel();
                _tiles[i][j].setSize(80, 80);
                _board.add(_tiles[i][j]);
            }
        }
        this._extraTile = new JLabel();
        _extraTile.setSize(80,80);



        JPanel dpad = new JPanel(new GridLayout(3, 3, 5, 5));
            JButton up = new JButton("Up");
            JButton down = new JButton("Down");
            JButton left = new JButton("Left");
            JButton right = new JButton("Right");
            dpad.add(new JLabel()); // Spacer
            dpad.add(up);
            dpad.add(new JLabel()); // Spacer
            dpad.add(left);
            dpad.add(new JLabel()); // Center spacer
            dpad.add(right);
            dpad.add(new JLabel()); // Spacer
            dpad.add(down);
            dpad.add(new JLabel()); // Spacer
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 1; // Single column
            c.gridheight = 1; // One row
            c.weightx = 0.5; // Allow some horizontal space
            c.weighty = 0.2; // Less vertical space
            c.fill = GridBagConstraints.NONE;
            c.anchor = GridBagConstraints.WEST;
            _game.add(dpad, c);

            // Button setup
            JButton actionButton = new JButton("Action");
            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weightx = 0.5;
            c.weighty = 0.2;
            c.fill = GridBagConstraints.NONE;
            c.anchor = GridBagConstraints.EAST;
            _game.add(actionButton, c);

        this.setVisible(true);
    }

    private static void setImage(JLabel tile, BufferedImage image){
        tile.setIcon(new ImageIcon(image));
    }

    private static void rotateTileClockwise(JLabel tile){
        setImage(tile, ImageHelper.rotateClockwise((BufferedImage)tile.getIcon()));
    }

    /* public static void rotateTileTrig(JLabel tile){
        setImage(tile, view.ImageHelper.rotateCounterClockwise((BufferedImage)tile.getIcon()));
    } */ // no current use for this

    private void moveRow(int row, Direction direction) throws Exception {
        if(direction == Direction.RIGHT){
            ImageIcon tempIcon = (ImageIcon) this._tiles[row][6].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    _tiles[row][i].setIcon(this._extraTile.getIcon());
                }
                else{
                    _tiles[row][i].setIcon(_tiles[row][i-1].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Direction.LEFT){
            ImageIcon tempIcon = (ImageIcon) this._tiles[row][0].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    _tiles[row][i].setIcon(this._extraTile.getIcon());
                }
                else{
                    _tiles[row][i].setIcon(_tiles[row][i+1].getIcon());
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
            ImageIcon tempIcon = (ImageIcon) this._tiles[6][column].getIcon();
            for (int i =6; i>=0; i--){
                if(i==0) {
                    _tiles[i][column].setIcon(this._extraTile.getIcon());
                }
                else{
                    _tiles[i][column].setIcon(_tiles[i-1][column].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else if(direction == Direction.UP){
            ImageIcon tempIcon = (ImageIcon) this._tiles[0][column].getIcon();
            for(int i=0; i<7; i++){
                if(i==6) {
                    _tiles[i][column].setIcon(this._extraTile.getIcon());
                }
                else{
                    _tiles[i][column].setIcon(_tiles[i+1][column].getIcon());
                }
                this._extraTile.setIcon(tempIcon);
            }
        }
        else{
            throw new Exception("Failure moving column. invalid direction");
        }
    }

    public void replicateBoard(Tile[][] board, Tile extraTile) throws IOException {
        int i = 0;
        int j = 0;
        for(Tile[] row : board){
            for(Tile tile : row){
                tileToLabel(tile, _tiles[i][j]);
                j++;
            }
            j=0;
            i++;
        }
        tileToLabel(extraTile, this._extraTile);
    }

    private void tileToLabel(Tile tile, JLabel label) throws IOException {
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
