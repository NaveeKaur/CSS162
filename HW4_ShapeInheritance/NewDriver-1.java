//i created a new main for myself

import javax.swing.*;
import java.awt.*;

/**
 * Created by Navee on 10/28/16.
 * This is the main I created to test out the child classes, except for Circle
 * class (because Circle was done in lab). 
 */
public class NewDriver extends JFrame{
    public static void main(String[] args) {
        NewDriver myApp = new NewDriver();
    }

    //just some windowing stuff that must happen for all Frames
    public NewDriver() {
        getContentPane().add(new JPanel() );
        setSize( 500,500 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    //graphics for GUI
    public void paint( Graphics g ) {
        super.paint(g);  //don't remove - required for GUI widgets to draw correctly

        //Square mySquare = new Square(7,30, 9, Color.DARK_GRAY);
        //mySquare.draw(g);
        //mySquare = new Square(8, 20, 9, Color.GREEN);
        //mySquare.draw(g);

        //pacMan pc = new pacMan(0, 0, 0);
        //pc.draw(g);

        //DeathlyHallows dh = new DeathlyHallows(10, 10,10);
        //dh.draw(g);

        Face newFace = new Face(10,10,10);
        newFace.draw(g);


    }


}
