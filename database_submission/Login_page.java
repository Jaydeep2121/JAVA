/*
 [3] Create an application for login validation. If user is not valid, display an error message.
 */

/**
 *
 * @author Jaydeep Chauhan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Login_page extends Frame implements ActionListener {
    Label l1,l2,mn,err;
    TextField t1,t2;
    Button log;
    Connection cn;
    Statement s=null;
    Login_page() throws SQLException{
        cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
        s = cn.createStatement();
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
        add(log);log.setFont(f);
        err=new Label();
        err.setBounds(100,340,220,15);
        add(err);
        log.addActionListener(this);
        
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
        if(e.getSource()==log && (!"".equals(t1.getText())) && (!"".equals(t2.getText()))){
            ResultSet rs;
            try{
                 rs=s.executeQuery("Select *from student");
                 while(rs.next()){
                        if(t1.getText().equals(rs.getString("user_name")) && t2.getText().equals(rs.getString("password"))){
                            err.setText("Login Success");
                            err.setForeground(Color.GREEN);
                        }else{
                            err.setText("UserName or PassWord Incorrect...");
                            err.setForeground(Color.RED);
                        }
                 }
            }catch(SQLException ex){
                        Logger.getLogger(Login_page.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            err.setText("UserName and PassWord Can't be null...");
            err.setForeground(Color.RED);
        }
    }
    public static void main(String[] args) throws SQLException {
        new Login_page();
    }
}
