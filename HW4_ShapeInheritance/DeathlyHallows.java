import java.awt.*;
import java.awt.Polygon;

/**
 * Created by Navee on 11/3/16.
 * This is also one of the shapes I will be using for the HW (my favorite!).
 */
public class DeathlyHallows extends Shape {

    private double radius;

    //constructor
    public DeathlyHallows(int a, int b,int r) {
        super(a, b);
        radius=r;
    }

    //gets the area of the circle inside triangle
    public double getArea(int r) {
        return Math.PI*r*r;
    }

    //draw the circle, triangle, and line here
    public void draw(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int d = (int)radius*2; //d = diameter
        g.setColor(Color.BLACK);
        g.drawOval(265/2,235,265,265);
        g.drawLine(265, 115, 265, 500);

        int [ ] x2 = {27, 500, 265}; //lets work on that line?
        int [ ] y2 = {500, 500, 115};
        g.setColor(Color.black);
        g.drawPolygon(x2, y2, 3);

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
