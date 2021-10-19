/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*; 
/**
 *
 * @author Jaydeep Chauhan
 */
public class EventhandlingApplet extends Applet implements
        ActionListener
        {
         Button b;
         TextField tf;
         
         @Override
         public void init() {
                tf=new TextField();
                tf.setBounds(30,40,150,20);

                b=new Button("Click");
                b.setBounds(80,150,60,50);

                add(b);add(tf);
                b.addActionListener(this);

                setLayout(null);
                setBackground(Color.red);
                // TODO start asynchronous download of heavy resources
         }
         // TODO overwrite start(), stop() and destroy() methods
         @Override
         public void actionPerformed(ActionEvent ae) {
                tf.setText("Welcome");
         }
}
