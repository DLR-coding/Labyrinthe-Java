import java.util.ArrayList;
import java.util.Arrays;

public class Tiles_Angle extends Tiles {
    public Tiles_Angle(int orientation, Goal goal) {
        super("Angle",
                orientation,
                goal,
                new ArrayList<>(Arrays.asList(true, true, false, false)));
    }
}
