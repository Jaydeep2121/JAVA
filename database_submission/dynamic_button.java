/*
    create dynamic button rowwise and columnwise
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Jaydeep Chauhan
 */
public class dynamic_button extends Frame implements ActionListener{
    Button[][] b1;
    Connection cn;
    String r,c;
    PreparedStatement p;
    Statement s=null;
    JFrame f=new JFrame();
    Button b;
    dynamic_button() throws SQLException{
            cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
            s=cn.createStatement();
            r=JOptionPane.showInputDialog(f,"Enter row");
            c=JOptionPane.showInputDialog(f,"Enter column");
            int top=110,left=110,cnt=1,st=0;
            for(int i=0;i<Integer.parseInt(r);i++){
                for(int j=0;j<Integer.parseInt(c);j++){
                    try{
                        b=new Button();
                        if(cnt==1){
                            b.setBounds(110, top, 60, 60);
                        }else{
                            if(j==0){
                                b1[i][j]=new Button();
                                st=b1[i-1][j].getLocation().x+50;
                                b.setBounds(left,st, 60, 60);
                            }else{
                                b1[i][j]=new Button();
                                st=b1[i][j-1].getLocation().y+50;
                                b.setBounds(st,left , 60, 60);
                            }
                        }
                        cnt+=1;
                        b1[i][j]=b;
                        add(b1[i][j]);
                        b1[i][j].addActionListener(this);
                    }catch(NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            addWindowListener(new WindowAdapter(){@Override
                public void windowClosing(WindowEvent e) {  
                    dispose();  
                }
            });
           setLayout(null);setVisible(true);setSize(700,700);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            System.out.println("hello");
        }
    }
    
    public static void main(String[] args) throws SQLException {
        new dynamic_button();
    }
}
