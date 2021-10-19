/*
 create login form with validation and (give one button register on it) registration form with using JDBC 
 also data store (register file)in file with using fileobjectstream object in java
 */

/**
 *
 * @author Jaydeep Chauhan
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class exam1_login extends Frame implements ActionListener {
    private static final SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            Label l1,l2,mn,err;
            TextField t1,t2;
            Button log,reg;
            exam1_login(){
                Font f = new Font("Serif", Font.BOLD, 15);
                mn=new Label("LogIn");
                mn.setFont(f);
                mn.setBounds(280,160,100,20);
                add(mn);
                l1=new Label("UserName");
                l1.setBounds(100, 196, 100, 15);
                add(l1);l1.setFont(f);
                t1=new TextField();
                t1.setBounds(200,190 ,200 ,30 );
                add(t1);
                l2=new Label("PassWord");
                l2.setBounds(100, 250, 100, 15);
                add(l2);l2.setFont(f);
                t2=new TextField();
                t2.setBounds(200,240,200 ,30 );
                add(t2);
                log=new Button("SignIn");
                log.setBounds(100, 290, 300,30 );
                
                reg=new Button("SignUp");
                reg.setBounds(100, 330, 300,30 );
                add(reg);reg.setFont(f);
                add(log);log.setFont(f);
                err=new Label();
                err.setBounds(100,450,220,15);
                add(err);
                log.addActionListener(this);
                reg.addActionListener(this);

                addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e) {  
                        dispose();  
                    }
                });

                setLayout(null);
                setVisible(true);
                setSize(700,700);
            }
                 
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==reg){
                System.out.println("hello");
                dispose();
                new exam1_register();
        }
        if(e.getSource()==log && (!"".equals(t1.getText())) && (!"".equals(t2.getText()))){
            try {
                FileReader fr=new FileReader("login.txt");
                BufferedReader br=new BufferedReader(fr);
                if(br.readLine().equals(t1.getText()) && br.readLine().equals(t2.getText())){
                    System.out.println(t1.getText());
                    System.out.println(t2.getText());
                    err.setText("Login Success");
                    err.setForeground(Color.GREEN);
                    t1.setText("");t2.setText("");    
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp);
                }else{
                    err.setText("UserName and PassWord is incorrect...");
                    err.setForeground(Color.RED);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(exam1_login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(exam1_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            err.setText("UserName and PassWord Can't be null...");
            err.setForeground(Color.RED);
        }
    }
    public static void main(String[] args) {
        new exam1_login();
    }
}
