import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;

/**
 * Created by Terje on 08.04.2015.
 */
public final class carManager {
    private static ArrayList<car> carList = new ArrayList<car>();

    public static void generateCar(PApplet p){
        car newCar = new car(p,20,10,400,401);
        carList.add(newCar);

    }
    public  static void drawCars(PGraphics pg){
        for(car curCar : carList){
            curCar.drawSelf(pg);

        }
    }

    public static ArrayList<car> getCarList() {
        return carList;
    }
}
