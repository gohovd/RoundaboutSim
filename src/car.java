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
    int step = 0;
    float angle;

    int pathSize = 1000;
    float[][] path = new float[2][pathSize];

    public car(PApplet p, float length, float width, float x, float y) {
        this.p = p;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        this.pg = pg;
        angle = 2;
        testGeneratePath();
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

        //angle += 0.009;
        //x += Math.cos(angle);
        //y += Math.sin(angle);
        step += 1;
        x = 0;
        y = 0;
        x = path[0][step];
        y = path[1][step];


    }

    public void testGeneratePath(){
        for(int i = 0; i<1000; i++){
            path[0][i] += p.width/2 + Math.cos(i*PApplet.TAU/pathSize)*100;
            path[1][i] += p.height/2 + Math.sin(i*PApplet.TAU/pathSize)*100;

        }
    }



}
