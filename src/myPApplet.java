import processing.core.PApplet;

public class myPApplet extends PApplet {

    public static void main(String args[]) {
        PApplet.main(new String[]{"--present", "Processing"});
    }

    public void setup(){
        size(500, 500);
        frameRate(60);
}


    public void draw (){
        textSize(32);
        text("8======D", width/2, height/2);

    }
}