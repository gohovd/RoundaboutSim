import processing.core.*;

public class myPApplet extends PApplet {

    //public static void main(String args[]) { PApplet.main(new String[]{"--present", "myPApplet"});
    //}

    public void setup(){
        size(500, 500);
        frameRate(60);
}


    public void draw (){
        textSize(32);
        fill(255, 0, 0, 255);
        text("8======D", width / 2, height / 2);

        rect(80, 65, 90, 30);
        ellipse(60, 60, 50, 50);
        ellipse(60, 90, 50, 50);
        ellipse(170, 80, 40, 40);

    }
}