/*
 [1]Write the method to display an applet, so that the contents are contained in a
    rectangle around the phrase "Exercise Applet"
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 *
 * @author Jaydeep Chauhan
 */
public class Excercise_Applet extends Applet{
       public void paint(Graphics g){
           Font ft=new Font("Courier", Font.BOLD,21);
           g.setFont(ft);
           g.setColor(Color.BLUE);
           g.drawString("Excercise Applet", 150,90);
           g.drawRect(50,30,400,120);
       }
}       
