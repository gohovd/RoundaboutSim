import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;

/**
 * Created by Terje on 08.04.2015.
 */
public final class carManager {
    private static ArrayList<car> carList = new ArrayList<car>();
    private static int sector1 = 0;
    private static int sector2 = 0;
    private static int sector3 = 0;
    private static int sector4 = 0;
    private static float averageSpeed = 0;

    public static void generateCar(PApplet p){
        int start = (1+Randomizer.getRng().nextInt(4))*100;
        int end = (1+Randomizer.getRng().nextInt(4))*100+1;
        if(!carAhead(start,0)) {


            car newCar = new car(p, 20, 10, start, end);
            carList.add(newCar);
        }

    }

    public static void oneStep(){
        sector1 = 0;
        sector2 = 0;
        sector3 = 0;
        sector4 = 0;
        float totalSpeed = 0;
        float totalAmountOfCars = 0;
        ArrayList<car> carsToRemove = new ArrayList<car>();

        for(car curCar : carList){
            if(curCar.isEnabled()) {
                totalSpeed +=curCar.getSpeed();
                totalAmountOfCars+=1;
                if (curCar.getSector() == 1) {
                    sector1 += 1;
                } else if (curCar.getSector() == 2) {
                    sector2 += 1;
                } else if (curCar.getSector() == 3) {
                    sector3 += 1;
                } else if (curCar.getSector() == 4) {
                    sector4 += 1;
                }
            }else{
                carsToRemove.add(curCar);
            }
        }
        for(car curCar: carsToRemove){
            carList.remove(curCar);
            StatMan.incCounter();
            //System.out.println("Removed");
        }
        averageSpeed = totalSpeed/totalAmountOfCars;
    }

    public static boolean carAhead(int curPathId, int myStep){
        for(car curCar : carList){
            if(curCar.isEnabled()) {
                if (curCar.getCurPathId() == curPathId) {
                    /*

                    int dif = curCar.getStep() - myStep;
                    int dif2 = curCar.getStep()+1000 - myStep;
                    if((dif < 100 && dif > 0) | (dif2 < 100 && dif2 > 0 && myStep>900)){
                        return true;
                    }*/
                    if (curCar.getStep() < myStep + 100 && curCar.getStep() > myStep) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static ArrayList<car> getCarList() {
        return carList;
    }

    public static float getAverageSpeed() {
        return averageSpeed;
    }

    public static int getSector1() {
        return sector1;
    }

    public static int getSector2() {
        return sector2;
    }

    public static int getSector3() {
        return sector3;
    }

    public static int getSector4() {
        return sector4;
    }
}
