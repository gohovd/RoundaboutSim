import processing.core.*;

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
        testCar = new car(this,20,10,width/2,height/2);
    }


    public void draw (){
        background(200);
        pg = createGraphics(width,height);

        //testBackground.createBackground(bg);
        testCar.oneStep();
        testCar.drawSelf(pg);

        image(bg,0,0);
        image(pg,90,40);
    }


}