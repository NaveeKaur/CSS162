import java.awt.*;

/**
 * Created by Navee on 11/1/16.
 * This class creates a Pacman shape! I will be using this shape for the HW.
 */
public class pacMan extends Shape {
    private double radius;

        //constructor
        public pacMan(int a, int b, int r) {
            super(a, b);
            this.radius = r;
        }

        //gets the area of Pacman (circle).
        public double getArea(int r) {
            return Math.PI*r*r;
        }

        //raws Pacman out, including yellow colour and arc shape for mouth
        public void draw(Graphics g) {
            int x = super.getX();
            int y = super.getY();
            int d = (int)radius*2; //d = diameter

            g.setColor(Color.yellow);
            g.fillArc(0, 0, 150, 150, 30, 300);
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
