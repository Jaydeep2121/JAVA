/*
 [3] Create an application for login validation. If user is not valid, display an error message.
 */

/**
 *
 * @author TS_Security
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;
//import java.sql.DriverManager;
import java.awt.*;
//import java.awt.event.*;
public class login_db extends Frame /*implements ActionListener*/{
    Label l1,l2,mn;
    TextField t1,t2;
    Button log;
    login_db(){
        /*
        mn=new Label("LogIn");
        mn.setBounds(280,160,100,20);
        add(mn);
        l1=new Label("UserName");
        l1.setBounds(100, 196, 100, 10);
        add(l1);
        t1=new TextField();
        t1.setBounds(200,190 ,200 ,30 );
        add(t1);
        l2=new Label("PassWord");
        l2.setBounds(100, 250, 100, 10);
        add(l2);
        t2=new TextField();
        t2.setBounds(200,240,200 ,30 );
        add(t2);
        log=new Button("SignIn");
        log.setBounds(100, 290, 300,30 );
        add(log);
        
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        setLayout(null);
        setVisible(true);
        setSize(700,700);
        */
    }
    /*public void actionPerformed(ActionEvent e){
         
    }*/
    public static void main(String[] args){
        login_db l=new login_db();
        try{
                //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection con;
                con=DriverManager.getConnection("‪jdbc:ucanaccess://D:/Codes/Java/stud.accdb");
                //-DUCANACCESS_HOME=/home/gord/Downloads/JDBC/UCanAccess-3.0.1-bin
            try{
                Statement s=con.createStatement();
                System.out.println("connected.....");
                ResultSet rs=s.executeQuery("select *from stud");
                while(rs.next()){
                    System.out.println("username : "+rs.getInt(1)+"password :"+rs.getString(2));
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
