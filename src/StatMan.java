/**
 * Created by Terje on 09.04.2015.
 */
public final class StatMan {
    private static long passedCarsCounter = 0;
    private static int stepsPerDraw = 10;


    public static void incCounter(){
        passedCarsCounter++;
    }
    public static long getPassedCarsCounter(){
        return passedCarsCounter;
    }
    public static int getStepsPerDraw(){
        return stepsPerDraw;
    }
    public static void incStepsPerDraw(){
        stepsPerDraw++;
    }
    public static void decStepsPerDraw(){
        stepsPerDraw--;
        if(stepsPerDraw<=1){
            stepsPerDraw=1;
        }
    }
}
