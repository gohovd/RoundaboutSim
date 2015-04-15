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
    int speed = 5;

    int maxSpeed = 5;
    float actualSpeed = maxSpeed;

    int r = 0;
    int g = 0;
    int b = 0;

    int start = 0;
    int end = 0;

    int blinkCounter = 0;
    int blinkMax = 8;

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
        maxSpeed += Math.round(p.random(2)) -1;
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
            if(sector == 5){
                blinkCounter++;
                if(blinkCounter >= blinkMax/2) {
                    if(blinkCounter == blinkMax){blinkCounter = 0;}
                    pg.fill(255, 102, 0);
                    pg.rect(length / 2 - 4, width / 2, 8, 4);
                }
            }
            pg.endDraw();
        }
    }
    public void oneStep() {
        if (enabled) {
            if (carManager.carAhead(curPathId, step)) { actualSpeed -= 1; }

            //Go round the roundabout
            if (curPathId == 100 && step >= curPath.getLength() * 0.81 && step <= curPath.getLength() * 0.87 && carManager.getSector1() > 0) {
                //step -= speed;
                actualSpeed -= 1;
            }

            if (curPathId == 200 && step >= curPath.getLength() * 0.88 && step <= curPath.getLength() * 0.95 && carManager.getSector2() > 0) {
                //step -= speed;
                actualSpeed -= 1;
            }

            if (curPathId == 300 && step >= curPath.getLength() * 0.81 && step <= curPath.getLength() * 0.87 && carManager.getSector3() > 0) {
                //step -= speed;
                actualSpeed -= 1;
            }

            if (curPathId == 400 && step >= curPath.getLength() * 0.88 && step <= curPath.getLength() * 0.95 && carManager.getSector4() > 0) {
                //step -= speed;
                actualSpeed -= 1;
            }

                //angle += 0.009;
                //x += Math.cos(angle);
                //y += Math.sin(angle);
                actualSpeed += 0.2;
                if(actualSpeed>maxSpeed){actualSpeed = maxSpeed;}
                else if(actualSpeed<0){actualSpeed = 0;}
                speed = Math.round(actualSpeed);

                step += speed;
                //Reaches end of current path



                if (curPathId == 0 && step >= curPath.getLength()) {
                    step = 0;
                } else if (step >= curPath.getLength() | (step >= endStep && step <= endStep + 10 && curPathId == 0)) {
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


    public void findCurrentSector(){
        sector = 0;

        /*if(x<p.width/2+35 && x>p.width/2-135 && y>p.height/2 && y<p.height/2+135 && sector != 5){
            sector = 1;
            if(end == 101) {
                sector = 5;
            }
        }*/
        if(curPathId == 0 && step >= 525 && step < 775){
            sector = 1;
            if(end == 101) {
                sector = 5;
            }
        }
        /*if(x>p.width/2 && x<p.width/2 +135 && y>p.height/2 - 35 && y<p.height/2 + 135 && sector != 5){
            sector = 2;
            if(end == 201) {
                sector = 5;
            }

        }*/
        if(curPathId == 0 && step >= 775 && step < 1001 | curPathId == 0 && step >= 0 && step < 25 ){
            sector = 2;
            if(end == 201) {
                sector = 5;
            }
        }
        /*if(x<p.width/2+135 && x>p.width/2-35 && y<p.height/2 && y>p.height/2-135 && sector != 5){
            sector = 3;
            if(end == 301) {
                sector = 5;
            }
        }*/
        if(curPathId == 0 && step >= 25 && step < 275){
            sector = 3;
            if(end == 301) {
                sector = 5;
            }
        }
        /*if(x<p.width/2 && x>p.width/2-135 && y<p.height/2+35 && y>p.height/2-135 && sector != 5){
            sector = 4;
            if(end == 401) {
                sector = 5;
            }
        }*/
        if(curPathId == 0 && step >= 275 && step < 525){
            sector = 4;
            if(end == 401) {
                sector = 5;
            }
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
