import java.awt.*;

/**
 * Created by Navee on 10/28/16.
 * This is the circle class that we created in lab.
 */
public class Circle extends Shape {
    private double radius;

    //constructor
    public Circle(int a, int b, int r) {
        super(a, b);
        this.radius = r;
    }

    //this method returns the area of a circle
    public double getArea(int r) {
        return Math.PI*r*r;
    }

    //this is where we draw the circle
    public void draw(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int d = (int)radius*2; //d = diameter

        g.setColor(Color.cyan);
        g.drawOval(x,y,d,d);
    }


    //setter
    public void setRadius(double r) {
        this.radius = r;
    }

    //getter
    public double getRadius() {
        return radius;
    }



}
