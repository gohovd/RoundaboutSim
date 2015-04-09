import processing.core.*;

import java.util.ArrayList;

public class myPApplet extends PApplet {

    //public static void main(String args[]) { PApplet.main(new String[]{"--present", "myPApplet"});
    //}

    float h = height;
    float w = width;
    PGraphics pg;
    PGraphics bg;
    car testCar;
    background testBackground;

    public void setup(){
        size(1368, 768);
        frameRate(60);


        pg = createGraphics(width,height);
        bg = createGraphics(width,height);
        testBackground = new background(this);
        testBackground.createBackground(bg);
        //testCar = new car(this,20,10,width/2,height/2+50);
    }


    public void draw (){
        if(millis()>1000) {
            background(200);
            pg = createGraphics(width, height);

            //testBackground.createBackground(bg);
            //testCar.oneStep();
            //testCar.drawSelf(pg);


            image(bg, 0, 0);
            pg.beginDraw();
            pg.fill(240, 240, 240);
            pg.stroke(240, 240, 240);
            pg.rect(1, 1, 1, 1);
            pg.endDraw();
            //carManager.drawCars(pg);

            for(int i = 0; i<StatMan.getStepsPerDraw(); i++) {
                if(Randomizer.getRng().nextInt(100)>98){
                    carManager.generateCar(this);
                }
                carManager.oneStep();
                ArrayList<car> cars = carManager.getCarList();

                for (car curCar : cars) {
                    curCar.oneStep();
                    //curCar.drawSelf(pg);
                    //System.out.println("test");
                }
            }
            ArrayList<car> cars = carManager.getCarList();
            for (car curCar : cars) {
                //curCar.oneStep();
                curCar.drawSelf(pg);
                //System.out.println("test");
            }
            String infoString = "Count: " + StatMan.getPassedCarsCounter();

            image(pg, 0, 0);
            stroke(0);
            fill(0);
            textSize(30);
            text(infoString,50,50);
        }
    }

    public void mousePressed(){
        System.out.println("X: " + mouseX + " Y: " +mouseY);
    }


}