
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Jaydeep Chauhan
 */
public class ThreadAppletDemo extends Applet implements Runnable{
 Thread t1,t2,t3;
 int k=30, j=30;
    public void init() {
        setBackground( Color.green);
    }
    public void start() {
        t1 = new Thread( this );
        t2 = new Thread (this);
        t3 = new Thread(this);

        t1.start();
        t2.start();
        t3.start();
    }
    public void run()
    {
        Graphics g=getGraphics();

        for(int i=1;i<=5;i++)
        {
            g.drawString(String.valueOf(i), k, j);
            k=k+10;
            j=j+10;
        }
    }
}
