/*
[1] Create an application with three buttons UP, DOWN and RESET. UP will increment the value of
texefield by 1, DOWN will decrement value by 1 and RESET will set the value of textfield by 0. 
 */

/**
 *
 * @author Jaydeep Chauhan
 */
import java.awt.*;
import java.awt.event.*;

public class Inc_Dec extends Frame implements ActionListener{
    TextField tf;
    Button up,dw,cl;
    Label l;
    Inc_Dec(){
        tf=new TextField();
        tf.setBounds(149,120,100,30);
        
        up=new Button("UP");
        up.setBounds(149,181,100,30);
        dw=new Button("DOWN");
        dw.setBounds(300,181,100,30);
        cl=new Button("CLEAR");
        cl.setBounds(450,181,100,30);
        
        Label l = new Label();
        l.setBounds(50,100,100,30);
        
        add(up);
        add(dw);
        add(cl);
        add(tf);
        add(l);
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        up.addActionListener(this);
        dw.addActionListener(this);
        cl.addActionListener(new ActionListener(){  
               public void actionPerformed(ActionEvent e){  
                    tf.setText("0");  
               }  
         });  
        setLayout(null);
        setVisible(true);
        setSize(700,700);
    }
    
    public static void main(String[] args) {
       new Inc_Dec();
    }

    public void actionPerformed(ActionEvent e){
        String s=tf.getText();
        int a=Integer.parseInt(s);
            if(e.getSource()==up){
                a++;
            }else if(e.getSource()==dw){
                a--;
            }
            String s1=String.valueOf(a);
            tf.setText(s1);
    }
}
