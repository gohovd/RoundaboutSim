import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * Created by Ole-Martin on 25.03.2015.
 */
public class background extends PApplet{
    PGraphics bg;
    PApplet p;
    float roadHeight = 70;
    float roadWidth = 70;
    float height;
    float width;

    public background(PApplet p) {
        this.p = p;
        this.height = p.height;
        this.width = p.width;

    }

    public void createBackground(PGraphics bg){
        bg.beginDraw();
        bg.background(240, 240, 240);
        bg.noStroke();
        bg.rectMode(CENTER);
        bg.ellipseMode(CENTER);
        //Roads
        bg.fill(80);
        //Horisontal
        bg.rect(0, height / 2, width*2, roadHeight);
        //Vertical
        bg.rect(width/2, 0, roadWidth,height*2);
        //Yellow line
        bg.stroke(255,255,0);
        bg.line(0, height/2, width, height/2);
        bg.line(width/2, 0,width/2,height);
        //Outercircle
        bg.noStroke();
        bg.fill(80);
        bg.ellipse(width / 2, height / 2, 300, 300);

        //yellowlineCircle
        bg.stroke(255,255,0);
        bg.ellipse(width/2, height/2,240,240);

        //Innercircle
        bg.noStroke();
        bg.fill(255);
        bg.ellipse(width / 2, height / 2, 180, 180);


        //End
        bg.endDraw();
    }
}