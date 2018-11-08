import java.awt.*;
import java.awt.geom.Path2D;
/**
 * Created by Navee on 11/1/16.
 * This is another shape for the HW.
 */
public class Face extends Shape {
    private int circleRadius;

    //constructor
    public Face(int a, int b, int r){
        super(a,b);
        circleRadius=r;
    }

    //this draws the shape of the "face" using circles as eyes and face
    //and a line for mouth.
    public void draw(Graphics g){
        int x = super.getX();
        int y = super.getY();
        int d = circleRadius*2;
        g.setColor(Color.black);
        g.drawOval(x,y,d,d);

        int eye1x= x+x/2;
        int eye1y= y+y/3;
        int eye1d = d/6;
        g.drawOval(eye1x,eye1y,eye1d,eye1d);


        int eye2x= x+x+x/5;
        int eye2y= y+y/3;
        int eye2d = d/6;
        g.drawOval(eye2x,eye2y,eye2d,eye2d);


        g.drawLine(d-50,d+50,d+50,d+50);


        }

    }

