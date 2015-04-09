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
        bg.ellipse(width / 2, height / 2, 260, 260);
        //yellowlineCircle
        //bg.stroke(255,255,0);
        //bg.ellipse(width/2, height/2,240,240);

        //Innercircle
        bg.noStroke();
        bg.fill(255);
        bg.ellipse(width / 2, height / 2, 180, 180);
        System.out.println(width/2);
        System.out.println(height/2);

        //Vikeplikt
        bg.strokeWeight(3);
        bg.stroke(0);
        //Right
        bg.line(820, 330, 840, 330);
        bg.fill(0,0,255);
        bg.ellipse(820,330,20,20);
        //bg.fill(255);
        //bg.rect(820,330,5,20);
        bg.stroke(255,255,255);
        bg.ellipse(820,330,12,12);

        //Down
        bg.stroke(0);
        bg.line(740,530,740,540);
        bg.fill(0,0,255);
        bg.ellipse(740,520,20,20);
        //bg.fill(255);
        //bg.rect(740,520,20,5);
        bg.stroke(255,255,255);
        bg.ellipse(740,520,12,12);

        //Left
        bg.stroke(0);
        bg.line(540,440,520,440);
        bg.fill(0,0,255);
        bg.ellipse(540,440,20,20);
        //bg.fill(255);
        //bg.rect(540,440,5,20);
        bg.stroke(255,255,255);
        bg.ellipse(540,440,12,12);

        //Up

        bg.stroke(0);
        bg.line(630,240,630,220);
        bg.fill(0,0,255);
        bg.ellipse(630,240,20,20);
        bg.noFill();

        bg.stroke(255,255,255);
        bg.ellipse(630,240,12,12);
        //bg.fill(255);
        //bg.rect(630,240,20,5);
        bg.strokeWeight(1);

        //End
        bg.endDraw();
    }
}