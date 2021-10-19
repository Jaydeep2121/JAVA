/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jaydeep Chauhan
 */
public class Final_register extends Frame implements ActionListener{
    TextField txno,txname,txage,txsal;
    Label l1,l2,l3,l4,l5,l6;
    Button ins,up,del,ser;
    CheckboxGroup g;
    Checkbox male,female;
    Choice dept;
    Connection cn;
    PreparedStatement p;
    ResultSet rs;
    Statement s=null;
    
    Final_register() throws SQLException{
        cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
        s=cn.createStatement();
        l1=new Label("no    :");
        l2=new Label("name  :");
        l3=new Label("gender:");
        l4=new Label("age   :");
        l5=new Label("salary:");
        l6=new Label("depart:");
        txno=new TextField("");
        txname=new TextField("");
        g=new CheckboxGroup();
        male=new Checkbox("male",g,true);
        female=new Checkbox("female",g,false);
        txage=new TextField("");
        txsal=new TextField("");
        ins=new Button("insert");
        up=new Button("update");
        del=new Button("delete");
        ser=new Button("search");
        dept=new Choice();
        dept.add("manufacture");
        dept.add("acccounting");
        dept.add("finance");
        
        l1.setBounds(80, 110, 70, 20);
        l2.setBounds(80, 160, 70, 20);
        l3.setBounds(80, 210, 70, 20);
        l4.setBounds(80, 260, 70, 20);
        l5.setBounds(80, 310, 70, 20);
        l6.setBounds(80, 360, 70, 20);
        txno.setBounds(150,110,190,30);
        txname.setBounds(150,160,190,30);
        txage.setBounds(150,260,190,30);
        male.setBounds(150, 210, 50,20 );
        female.setBounds(200, 210, 60,20 );
        txsal.setBounds(150,310,190,30);
        dept.setBounds(150,360,150,30);
        ins.setBounds(400,110 , 70, 40);
        up.setBounds(400, 160, 70, 40);
        del.setBounds(400, 210, 70, 40);
        ser.setBounds(400, 260, 70, 40);
        
        add(txno);add(txname);add(txage);add(txsal);add(male);add(female);add(dept);
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(ins);add(up);add(del);add(ser);
        ins.addActionListener(this);
        up.addActionListener(this);
        del.addActionListener(this);
        ser.addActionListener(this);
        
        addWindowListener(new WindowAdapter(){@Override
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        
        setLayout(null);setVisible(true);setSize(700,700);
     
    }
       public void actionPerformed(ActionEvent e){
        if(e.getSource()==ins ||e.getSource()==up ){
            try {
                if(e.getSource()==ins){
                    p=cn.prepareStatement("insert into register(rname,rage,rsal,rgender,rdept,rno)values(?,?,?,?,?,?)");
                }else if(e.getSource()==up){
                    p=cn.prepareStatement("update register set rname=?,rage=?,rsal=?,rgender=?,rdept=? where rno=?");
                }
                p.setString(1, txname.getText());
                p.setInt(2, Integer.parseInt(txage.getText()));
                p.setInt(3, Integer.parseInt(txsal.getText()));
                p.setString(4, g.getSelectedCheckbox().getLabel());
                p.setString(5, dept.getSelectedItem());
                p.setInt(6, Integer.parseInt(txno.getText()));
                p.executeUpdate();
                if(e.getSource()==ins){
                    System.out.println("insert success");
                }else if(e.getSource()==up){
                    System.out.println("update success");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(Final_register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==del){
            try {
                p=cn.prepareStatement("delete from register where rno=?");
                p.setInt(1, Integer.parseInt(txno.getText()));
                p.executeUpdate();
                if(e.getSource()==del){
                    JOptionPane.showMessageDialog(del,"deleted....");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Final_register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==ser){
            int cnt=0;
            try{
                p=cn.prepareStatement("select count(*) from register where rno=?");
                p.setInt(1, Integer.parseInt(txno.getText()));
                rs=p.executeQuery();
                rs.next();cnt=rs.getInt(1);
                if(cnt==1){
                    p=cn.prepareStatement("select *from register where rno=?");
                    p.setInt(1, Integer.parseInt(txno.getText()));
                    rs=p.executeQuery();
                    while(rs.next()){
                        txno.setText(rs.getString("rno"));
                        txname.setText(rs.getString("rname"));
                        txage.setText(rs.getString("rage"));
                        txsal.setText(rs.getString("rsal"));
                        dept.select(rs.getString("rdept"));
                        if(rs.getString("rgender").equals("male")){
                            male.setState(true);
                        }else{
                            male.setState(true);
                        }
                    }
                }else{
                    System.out.println("not found...");
                }                
            }catch(SQLException ex){
                Logger.getLogger(Final_register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) throws SQLException {
        new Final_register();
    }
}
