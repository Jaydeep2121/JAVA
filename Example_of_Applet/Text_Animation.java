/*
 [4] Create an applet for text animation using an applet.
 */
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
/**
 *
 * @author Jaydeep Chauhan
 */
public class Text_Animation extends Applet implements Runnable{   
    String msg = "HelloString";
    Thread t;
    public void start(){
        t = new Thread(this,"Animation");
        t.start();
    }
    
    public void run(){
        for(;;){
            try{
                Thread.sleep(2000);
            }catch(InterruptedException ex){}
            
            msg +=msg.charAt(0);
            msg = msg.substring(1,msg.length());
            repaint();
        }
    }
    
    public void stop(){
        t.stop();
    }
    
    public void paint(Graphics g){
        setBackground(Color.CYAN);
        Font f = new Font("Courier", Font.BOLD, 22);
        g.setFont(f);
        g.drawString(msg, 300, 200);
    }
}
