import processing.core.*;

/**
 * Created by Terje on 25.03.2015.
 */
public class car {
    PApplet p;
    float length;
    float width;
    float weight;
    float x;
    float y;
    int sector;
    int lastSector;
    int step = 0;
    float angle;


    //Testing
    //Bare til testing
    int pathSize = 1000;
    int curPath = 1;
    float[][] path = new float[3][pathSize];
    float[][] path2 = new float[3][pathSize];

    public car(PApplet p, float length, float width, float x, float y) {
        this.p = p;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        angle = 2;
        this.testGeneratePath();
        this.testGeneratePath2();
        this.findCurrentSector();
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
        if(step>=1000 && curPath == 1){step = 800; curPath = 0;}
        if(step>=1000 && curPath == 0){ step = 0;}
        if(curPath == 0) {
            x = path[0][step];
            y = path[1][step];
            angle = path[2][step];
        }else if(curPath == 1){
            x = path2[0][step];
            y = path2[1][step];
            angle = path2[2][step];
        }


    }

    public void testGeneratePath(){
        for(int i = 0; i<1000; i++){
            int inv = 999 - i;
            int use = inv;
            path[0][use] += p.width/2 + Math.cos(i*(PApplet.TAU/pathSize))*100;
            path[1][use] += p.height/2 + Math.sin(i*(PApplet.TAU/pathSize))*100;
            System.out.println(Math.cos(i*(PApplet.TAU/pathSize)));
            path[2][use] += (PApplet.TAU/pathSize)*i + PApplet.PI/2;

        }
    }
    public void testGeneratePath2(){
        float last = 765;
        float inc = 0.27F;
        for(int i = 0; i<1000; i++){

            path2[0][i] = 700;
            path2[1][i] = last - inc;
            last = path2[1][i];
            path2[2][i] = PApplet.PI/2;

        }
    }

    public void findCurrentSector(){
        sector = 1;


        //Debugging. message when sector changes
        if(sector != lastSector){
            System.out.println("Sector changed");
            System.out.println("Sector: " + sector);
        }


        lastSector = sector;
    }



}
