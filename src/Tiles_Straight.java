import java.util.ArrayList;
import java.util.Arrays;

public class Tiles_Straight extends Tiles {
    public Tiles_Straight(int orientation, Goal goal) {
        super("Straight",
                orientation,
                goal,
                new ArrayList<>(Arrays.asList(false, true, false, true))); // default horizontal -
        for (int i = 0; i < orientation; i++) {
            this.rotate();
        }
    }
    
    
}