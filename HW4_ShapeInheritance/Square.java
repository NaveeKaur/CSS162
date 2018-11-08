/**
 * Created by Navee on 10/28/16.
 * This is another shape I created in lab.
 */

import java.awt.*;

public class Square extends Shape {

    private int length;
    private Color col;

    //constructor; can initialize color here for NewDriver
    public Square(int a, int b, int l) {
        super(a, b);
        this.length = l;
    }

    //gets the area of the square
    public double getArea() {
        return length*length;
    }

    //sets the color of the square
    public void setColor(Color c) {
        this.col = c;
    }

    //draws out the square
    public void draw (Graphics g) {
        int x = super.getX();
        int y = super.getY();
        int d = (int)length;

        g.setColor(col);
        g.drawRect(x,y,length,length);
    }
}
