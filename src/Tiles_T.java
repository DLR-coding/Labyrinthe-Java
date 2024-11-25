import java.util.ArrayList;
import java.util.Arrays;

public class Tiles_T extends Tiles{
    public Tiles_T(int orientation, Goal goal) {
        super("T",
                orientation,
                goal,
                new ArrayList<>(Arrays.asList(true, true, true, false)));
    }
}
