import processing.core.PApplet;

/**
 * Created by Terje on 26.03.2015.
 */

public final class PathManager {
    private static Path roundAbout = new Path();
    private static Path fromDownToCircle = new Path();
    private static Path fromCircleToDown = new Path();
    private static Path fromUpToCircle = new Path();
    private static Path fromCircleToUp = new Path();
    private static Path fromRightToCircle = new Path();
    private static Path fromCircleToRight = new Path();
    private static Path fromLeftToCircle = new Path();
    private static Path fromCircleToLeft = new Path();

    public static void startUp(PApplet p){
        int test;
        roundAbout.circlePath(100,1000, 1368/2, 768/2);
        test = 785;
        fromDownToCircle.linePath(500,roundAbout.getX(test),roundAbout.getY(test)+300,roundAbout.getX(test),roundAbout.getY(test));
        test = 715;
        fromCircleToDown.linePath(500,roundAbout.getX(test),roundAbout.getY(test),roundAbout.getX(test),roundAbout.getY(test)+300);

        test = 35;
        fromRightToCircle.linePath(1000,roundAbout.getX(test)+600,roundAbout.getY(test),roundAbout.getX(test),roundAbout.getY(test));
        test = 965;
        fromCircleToRight.linePath(1000,roundAbout.getX(test),roundAbout.getY(test),roundAbout.getX(test)+600,roundAbout.getY(test));

        test = 285;
        fromUpToCircle.linePath(500,roundAbout.getX(test),roundAbout.getY(test)-300,roundAbout.getX(test),roundAbout.getY(test));
        test = 215;
        fromCircleToUp.linePath(500,roundAbout.getX(test),roundAbout.getY(test),roundAbout.getX(test),roundAbout.getY(test)-300);

        test = 535;
        fromLeftToCircle.linePath(1000,roundAbout.getX(test)-600,roundAbout.getY(test),roundAbout.getX(test),roundAbout.getY(test));
        test = 465;
        fromCircleToLeft.linePath(1000,roundAbout.getX(test),roundAbout.getY(test),roundAbout.getX(test)-600,roundAbout.getY(test));






        System.out.println(p.width);
    }

    public static Path getRoundAbout() {
        return roundAbout;
    }

    public static Path getFromDownToCircle() {
        return fromDownToCircle;
    }

    public static Path getFromCircleToDown() {
        return fromCircleToDown;
    }

    public static Path getFromUpToCircle() {
        return fromUpToCircle;
    }

    public static Path getFromCircleToUp() {
        return fromCircleToUp;
    }

    public static Path getFromRightToCircle() {
        return fromRightToCircle;
    }

    public static Path getFromCircleToRight() {
        return fromCircleToRight;
    }

    public static Path getFromLeftToCircle() {
        return fromLeftToCircle;
    }

    public static Path getFromCircleToLeft() {
        return fromCircleToLeft;
    }
}
