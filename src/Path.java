import processing.core.PApplet;

/**
 * Created by Terje on 26.03.2015.
 */
public class Path {
    float[][] array;
    //0 x
    //1 y
    //2 angle(in radian)
    int length;

    public Path() {
    }


    public void linePath(int amountOfSteps, float xStart,float yStart,float xEnd ,float yEnd){
        array = new float[3][amountOfSteps];
        float yDif = (yEnd-yStart);
        float xDif = (xEnd-xStart);
        float yInc = yDif/amountOfSteps;
        float xInc = xDif/amountOfSteps;

        double direction = Math.atan2(yDif,xDif);
        for(int i = 0; i<amountOfSteps; i++){
            if(i == 0) {
                array[0][i] = xStart;
                array[1][i] = yStart;
            }else{
                array[0][i] = array[0][i-1] + xInc;
                array[1][i] = array[1][i-1] + yInc;
            }
            array[2][i] = (float)direction;
        }
    }

    public void circlePath(float r, int amountOfSteps, float x, float y){

        array = new float[3][amountOfSteps];
        length = amountOfSteps;
        for(int i = 0; i<amountOfSteps; i++){
            array[0][amountOfSteps-1-i] += x + Math.cos(i*(PApplet.TAU/amountOfSteps))*r;
            array[1][amountOfSteps-1-i] += y + Math.sin(i*(PApplet.TAU/amountOfSteps))*r;
            System.out.println(Math.cos(i*(PApplet.TAU/amountOfSteps)));
            array[2][amountOfSteps-1-i] += (PApplet.TAU/amountOfSteps)*i + PApplet.PI/2;
        }

    }

    public float getX(int i){
        return array[0][i];
    }
    public float getY(int i){
        return array[1][i];
    }
    public float getAng(int i){
        return array[2][i];
    }
}
