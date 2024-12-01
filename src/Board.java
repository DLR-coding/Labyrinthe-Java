import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<ArrayList<Tile>> _tiles;
    private Tile _extraTile;

    public Board() {
        this._tiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Tile> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null); // or initialize with a Tiles object if needed
            }
            _tiles.add(row);
        }
    }

    private void initializeBoard() {
        // Initialiser le plateau avec des tuiles et des objectifs
        TileFactory tileFactory = new TileFactory();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tile tile = tileFactory.createTileStraight(Orientation.NORTH, null);
                this.setTile(new Position(i, j), tile);
            }
        }
        // addGoalsToBoard();
    }


    public Tile getTile(Position position) {
        return _tiles.get(position.getRow()).get(position.getCol());
    }

    public void setTile(Position position, Tile tile) {
        _tiles.get(position.getRow()).set(position.getCol(), tile);
    }



    public void printBoard(List<Pawn> pawns) {
        System.out.println("Plateau de jeu:");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Tile tile = _tiles.get(j).get(i);
                if (tile == null) {
                    System.out.print("[  x , x , x , x ,]");
                } else {
                System.out.print("[ " + tile.getDisplayPaths() +  "]" );
                }
            }
            System.out.println();
        }

        System.out.println("Positions des pions:");
        for (Pawn pawn : pawns) {
            System.out.println("Pion à la position: (" + pawn.getPosition().getRow() + ", " + pawn.getPosition().getCol() + ")");
        }
    }
}