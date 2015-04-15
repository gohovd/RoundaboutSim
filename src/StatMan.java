import java.util.ArrayList;

/**
 * Created by Terje on 09.04.2015.
 */
public final class StatMan {
    private static ArrayList<Long> data = new ArrayList<Long>();
    private static long passedCarsCounter = 0;
    private static int stepsPerDraw = 1000000;
    private static int n = 0;


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
    public static void saveDataAndReset(){
        data.add(passedCarsCounter);
        //System.out.println("test");
        passedCarsCounter = 0;
        n++;
    }
    public static Long getAveragePassedCars(){
        Long total = 0L;
        for(Long carsPassed : data){
            total+=carsPassed;
        }
        if(data.size() == 0){
            return 0L;
        }

        return total/(data.size());
    }

    public static int getN() {
        return n;
    }
}
