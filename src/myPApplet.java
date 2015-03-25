import processing.core.*;

public class myPApplet extends PApplet {

    //public static void main(String args[]) { PApplet.main(new String[]{"--present", "myPApplet"});
    //}
    PGraphics bg;
    float roadHeight = 70;
    float roadWidth = 70;
    float h = height;
    float w = width;
    PGraphics pg;
    car testCar;

    public void setup(){
        size(1368, 768);
        frameRate(60);
        bg = createGraphics(1368, 768);
    }
        pg = createGraphics(width,height);
        testCar = new car(this,20,10,width/2,height/2);
    }


    public void draw (){
        background(200);
        pg = createGraphics(width,height);

        textSize(32);
        fill(255, 0, 0, 255);
        text("8======D", width / 2, height / 2);
    public void draw () {
       createBackground();
    }




        testCar.oneStep();
        testCar.drawSelf(pg);
        image(pg,0,0);



    }

    public void setPg(PGraphics pg) {
        this.pg = pg;
    public void createBackground(){
        bg.beginDraw();
        bg.background(240, 240, 240);
        bg.noStroke();
        //Roads
        bg.fill(80);
            //Horisontal
        bg.rect(0, height / 2, width * 2, roadHeight);
            //Vertical
        bg.rect(width/2,0,roadWidth,height*2);
        //Yellow line
        bg.stroke(255,255,0);
        bg.line(0, h/2, w, h/2);
        bg.line(width/2,0,width/2,h);
        bg.line(30, 20, 85, 75);
        //Outercircle
        noStroke();
        bg.fill(80);
        bg.ellipse(width / 2, height / 2, 300, 300);
        bg.fill(255);
        //Innercircle
        bg.ellipse(width / 2, height / 2, 180, 180);
        bg.rectMode(CENTER);
        //End
        bg.endDraw();
        image(bg,0,0);
    }
}