import processing.core.PApplet;

/**
 * Created by Terje on 26.03.2015.
 */

public final class PathManager {
    private static Path roundAbout = new Path();

    public static void startUp(PApplet p){
        roundAbout.circlePath(100,1000, 1368/2, 768/2);
        System.out.println(p.width);
    }

    public static Path getRoundAbout() {
        return roundAbout;
    }
}
