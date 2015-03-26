import java.util.Random;

/**
 * Created by Terje on 26.03.2015.
 */
public final class Randomizer {
    private static final long SEED = 1234;
    private static final Random rng = new Random;



    public Random getRng(){
        return rng;
    }

    public static void reset(){
        rng.setSeed(SEED);
    }
}
