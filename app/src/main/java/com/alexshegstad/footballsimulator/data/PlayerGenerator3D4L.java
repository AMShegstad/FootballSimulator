import java.util.*;

public class PlayerGenerator3D4L {
    
    private static final Random rand = new Random();

    private static final Map<Postion, Integer> rosterComposition = Map.of(
        Position.QB, 3,
        Position.HB, 4,
        Position.FB, 1,
        Position.WR, 5,
        Position.TE, 3,
        Position.LT, 2,
        Positiion.LG, 2,
        Position.C, 2,
        Position.RG, 2,
        Position.RT, 2,
        Position.MLB, 3,
        Position.LOLB, 3,
        Position.ROLB, 3,
        Position.DT, 4,
        Position.SS, 2,
        Position.FS, 3,
        Position.CB, 5,
        Position.LS, 1,
        Position.K, 1,
        Position.P, 1
    );
}
