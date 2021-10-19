/*
[2]Create an applet that accepts a string in textfield and a button to save. By
click on Save button, write the content of textfield in a file
 */
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jaydeep Chauhan
 */
public class text_contain_file extends Applet implements
ActionListener{
         Button b;
         TextField tf;
         
         @Override
         public void init(){
                tf=new TextField();
                tf.setBounds(80,40,200,30);

                b=new Button("Save");
                b.setBounds(80,90,200,50);
                add(tf);add(b);
                b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                               if(!tf.getText().equals("")){
                                    try{
                                        FileOutputStream fos=new FileOutputStream("Applet_File.txt");
                                        Writer Output = new OutputStreamWriter(fos);
                                        Output.write(tf.getText());Output.close();
                                        JOptionPane.showMessageDialog(b,"Content Saved successfully..");
                                    }catch (FileNotFoundException ex) {
                                        Logger.getLogger(text_contain_file.class.getName()).log(Level.SEVERE, null, ex);
                                    }catch (IOException ex) {
                                        Logger.getLogger(text_contain_file.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else{
                                        JOptionPane.showMessageDialog(b, "TextFiled Can't be blank","Alert",JOptionPane.WARNING_MESSAGE);
                                }  
                        }  
                });
                setLayout(null);
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
