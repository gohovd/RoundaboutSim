import processing.core.*;

/**
 * Created by Terje on 25.03.2015.
 */
public class car {
    PApplet p;
    PGraphics pg;
    float length;
    float width;
    float weight;
    float x;
    float y;
    int sector;
    float angle;

    public car(PApplet p, float length, float width, float x, float y) {
        this.p = p;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        this.pg = pg;
        angle = 2;
    }

    public void drawSelf(PGraphics pg){
        pg.beginDraw();
        pg.rectMode(PApplet.CENTER);
        pg.translate(x,y);
        pg.rotate(angle);
        pg.fill(0,255,0);
        pg.rect(0, 0, length, width);
        pg.endDraw();
    }
    public void oneStep(){

        angle += 0.01;
        x += Math.cos(angle);
        y += Math.sin(angle);


    }



}
