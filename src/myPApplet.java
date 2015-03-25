import processing.core.*;

public class myPApplet extends PApplet {

    //public static void main(String args[]) { PApplet.main(new String[]{"--present", "myPApplet"});
    //}
    PGraphics pg;
    car testCar;

    public void setup(){
        size(500, 500);
        frameRate(60);
        pg = createGraphics(width,height);
        testCar = new car(this,20,10,width/2,height/2);
    }


    public void draw (){
        background(200);
        pg = createGraphics(width,height);

        textSize(32);
        fill(255, 0, 0, 255);
        text("8======D", width / 2, height / 2);

        rect(80, 65, 90, 30);
        ellipse(60, 60, 50, 50);
        ellipse(60, 90, 50, 50);
        ellipse(170, 80, 40, 40);



        testCar.oneStep();
        testCar.drawSelf(pg);
        image(pg,0,0);



    }

    public void setPg(PGraphics pg) {
        this.pg = pg;
    }
}