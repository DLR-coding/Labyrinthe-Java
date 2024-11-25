import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Tiles>> tiles;
    private Tiles extraTile;

    public Board() {
        this.tiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Tiles> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null); // or initialize with a Tiles object if needed
            }
            tiles.add(row);
        }
    }

    public Tiles getTile(Position position) {
        return tiles.get(position.getX()).get(position.getY());
    }

    public void setTile(Position position, Tiles tile) {
        tiles.get(position.getX()).set(position.getY(), tile);
        System.out.println("Tuile placée en (" + position.getX() + ", " + position.getY() + ").");
    }

    public void moveRowOrColumn(Move move) {
        // Implémentation du déplacement de ligne ou colonne
    }

    // Autres méthodes pour générer et placer les tuiles, déplacer les lignes/colonnes, etc.
}