import java.util.ArrayList;

public class Tiles_Straight extends Tiles {

    public Position _position;
    public ArrayList<Tiles> _listVoisins; // ex : Tile.position[] (haut , bas , gauche , droite) ex : [(x1 , y1) , (x2, y2) , (NULL , NULL) ,(NULL , NULL)]
    public ArrayList<Boolean> _doorsUnlocked; // ex : this.doorsUnlocked[] (haut , bas , gauche , droite) ex : [TRUE,TRUE,FALSE,FALSE]

    /*
    pr qu'un joueur avance , il faut que la direction qu'il veut soit dans la liste de voisin
    ex : j1 -> gauche
    Tile_Straight_1 -> _listeVoisins[haut , bas , GAUCHE  ? , droite] -> if NOT NULL => j1.newPosition = GAUCHE.position , else "blocked"

    - innit/refresh (design LISTENENR chaques rota/deplacement on refresh voisins) ListeVoisins : en fonction du type de Tile -> foreach doorUnlocked , if Tile2.doorsUnlocked[oppositedirection]=TRUE => Tile1.TilesVoisin[doorUnlocked] = (Tiles2.positions)

    - rotate() : dépend du Tile_Type :
                           *  Straight : 2 modes slmt : (haut , bas , false , false) / (false , false , gauche , droite)
                           * Angles : 4 modes  : (haut , false , gauche , false) / (haut , false , false , droite) // (false , bas , gauche , false) / ( false , bas , false , droite)
                           * T : 4 modes  : (haut , false , gauche , droite) / (false , bas , gauche , droite) // (haut , bas , gauche , false) / ( haut , bas , false , droite)
     */

}
