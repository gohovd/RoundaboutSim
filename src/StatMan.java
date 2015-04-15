import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Terje on 09.04.2015.
 */
public final class StatMan {
    private static ArrayList<Long> data = new ArrayList<Long>();
    private static long passedCarsCounter = 0;
    private static int stepsPerDraw = 1;
    //1000000
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
        stepsPerDraw+=100000;
    }
    public static void decStepsPerDraw(){

        stepsPerDraw-=100000;
        if(stepsPerDraw<=1){
            stepsPerDraw=1;
        }
    }
    public static void saveDataAndReset(){
        data.add(passedCarsCounter);
        //System.out.println("test");
        passedCarsCounter = 0;
        n++;
        if(n==100){
            writeFile();
        }
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

    public static synchronized void writeFile(){
        try
        {
            String filename = "stats" + Randomizer.getSeed() + ".txt";

            File file = new File(filename);
            FileWriter writer = new FileWriter(file);

            writer.append("n");
            writer.append(',');
            writer.append("CarsPassed");
            writer.append(System.lineSeparator());

            for(Integer i = 0; i<n; i++){

                writer.append(i.toString());
                writer.append(',');
                writer.append(data.get(i).toString());
                writer.append(System.lineSeparator());
            }


            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
