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

    Path curPath;



    public car(PApplet p, float length, float width, float x, float y) {
        this.p = p;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        angle = 2;
        this.findCurrentSector();
        curPath = PathManager.getRoundAbout();
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
        step +=1;
        if(step>=1000){step = 0;}
        x       = curPath.getX(step);
        y       = curPath.getY(step);
        angle   = curPath.getAng(step);

        findCurrentSector();


    }


    public void findCurrentSector(){
        sector = 1;
        if(x < p.width/2){
            if(y < p.height/2){
                sector = 1;
            }else if(y >= p.height/2){
                sector = 2;
            }
        }else if(x >= p.width/2){
            if(y < p.height/2){
                sector = 4;
            }else if(y >= p.height/2){
                sector = 3;
            }
        }


        //Debugging. message when sector changes
        if(sector != lastSector){
            System.out.println("Sector changed");
            System.out.println("Sector: " + sector);
        }


        lastSector = sector;
    }



}
