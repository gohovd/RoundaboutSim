import processing.core.*;

import java.util.ArrayList;

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

    int r = 0;
    int g = 0;
    int b = 0;

    int start = 0;
    int end = 0;

    Path curPath;
    int curPathId;
    int endStep = 0;
    int startStep = 0;
    boolean enabled = true;



    public car(PApplet p, float length, float width, int start, int end) {
        this.p = p;
        this.length = length;
        this.width = width;
        this.x = 0;
        this.y = 0;
        angle = 2;
        this.findCurrentSector();
        this.start = start;
        this.end = end;
        if(start == 100){startStep = 785;}
        if(end == 101){endStep = 715;}
        if(start == 200){startStep = 35;}
        if(end == 201){endStep = 965;}
        if(start == 300){startStep = 285;}
        if(end == 301){endStep = 215;}
        if(start == 400){startStep = 535;}
        if(end == 401){endStep = 465;}

        setPath(start);

        r = Randomizer.getRng().nextInt(256);
        g = Randomizer.getRng().nextInt(256);
        b = Randomizer.getRng().nextInt(256);
    }

    public void drawSelf(PGraphics pg){
        if(enabled) {
            pg.beginDraw();
            pg.rectMode(PApplet.CENTER);
            pg.translate(x, y);
            pg.rotate(angle);
            pg.fill(r,g,b);
            pg.stroke(0);
            pg.rect(0, 0, length, width);
            pg.endDraw();
        }
    }
    public void oneStep() {
        if (enabled) {
            if (!carManager.carAhead(curPathId, step)) {

                //angle += 0.009;
                //x += Math.cos(angle);
                //y += Math.sin(angle);

                step += 1;
                //Reaches end of current path

                //Go round the roundabout
                if (curPathId == 100 && step == curPath.getLength() * 0.85 && carManager.getSector1() > 0) {
                    step -= 1;
                }

                if (curPathId == 200 && step == curPath.getLength() * 0.93 && carManager.getSector2() > 0) {
                    step -= 1;
                }

                if (curPathId == 300 && step == curPath.getLength() * 0.85 && carManager.getSector3() > 0) {
                    step -= 1;
                }

                if (curPathId == 400 && step == curPath.getLength() * 0.93 && carManager.getSector4() > 0) {
                    step -= 1;
                }

                if (curPathId == 0 && step >= curPath.getLength()) {
                    step = 0;
                } else if (step >= curPath.getLength() | (step == endStep && curPathId == 0)) {
                    if (curPathId == end) {
                        enabled = false;
                    }
                    if (curPathId == start) {
                        setPath(0);
                    } else if (curPathId == 0) {
                        setPath(end);
                    }
                }
                if (enabled) {


                    x = curPath.getX(step);
                    y = curPath.getY(step);
                    angle = curPath.getAng(step);

                    findCurrentSector();
                }


            }
        }
    }


    public void findCurrentSector(){
        sector = 0;
        if(x<p.width/2+35 && x>p.width/2-135 && y>p.height/2 && y<p.height/2+135){
            sector = 1;
        }
        if(x>p.width/2 && x<p.width/2 +135 && y>p.height/2 - 35 && y<p.height/2 + 135){
            sector = 2;
        }
        if(x<p.width/2+135 && x>p.width/2-35 && y<p.height/2 && y>p.height/2-135){
            sector = 3;
        }
        if(x<p.width/2 && x>p.width/2-135 && y<p.height/2+35 && y>p.height/2-135){
            sector = 4;
        }


        //Debugging. message when sector changes
        if(sector != lastSector){
            //System.out.println("Sector changed");
            //System.out.println("Sector: " + sector);
        }


        lastSector = sector;
    }
    public void setPath(int a){
        //Paths in
        if(a == 100) {
            curPath = PathManager.getFromDownToCircle();
            curPathId = 100;
            step = 0;
        }
        if(a == 200) {
            curPath = PathManager.getFromRightToCircle();
            curPathId = 200;
            step = 0;
        }
        if(a == 300) {
            curPath = PathManager.getFromUpToCircle();
            curPathId = 300;
            step = 0;
        }
        if(a == 400) {
            curPath = PathManager.getFromLeftToCircle();
            curPathId = 400;
            step = 0;
        }


        //Paths out
        if(a == 101){
            curPath = PathManager.getFromCircleToDown();
            curPathId = 101;
            step = 0;
        }
        if(a == 201){
            curPath = PathManager.getFromCircleToRight();
            curPathId = 201;
            step = 0;
        }
        if(a == 301){
            curPath = PathManager.getFromCircleToUp();
            curPathId = 301;
            step = 0;
        }
        if(a == 401){
            curPath = PathManager.getFromCircleToLeft();
            curPathId = 401;
            step = 0;
        }




        //RoundAbout

        if(a == 0) {
            curPath = PathManager.getRoundAbout();
            curPathId = 0;
            step = startStep;
        }

    }

    public int getSector() {
        if(enabled) {
            return sector;
        }else{
            return 0;
        }
    }

    public int getStep() {
        return step;
    }

    public int getCurPathId() {
        return curPathId;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
