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
        if(stepsPerDraw == 1){
            stepsPerDraw = 0;
        }
        stepsPerDraw+=10;
    }
    public static void decStepsPerDraw(){

        stepsPerDraw-=10;
        if(stepsPerDraw<=1){
            stepsPerDraw=1;
        }
    }
}
