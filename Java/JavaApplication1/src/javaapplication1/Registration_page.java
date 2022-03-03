/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
//
//import java.applet.Applet;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import java.sql.DriverManager;
//public class que1 extends Applet implements ActionListener{
//    Label lbl_id,lbl_name,lbl_dob,lbl_add,l;
//    TextField txt_id,txt_name,txt_dob,txt_add;
//    Button btn_insert,btn_update,btn_delete,btn_search,btn_clear;
//    PreparedStatement ps1,ps2;
//    Connection cn;
//    @Override
//    public void init() {
//        try
//        {
//            cn=DriverManager.getConnection("jdbc:ucanaccess://d:/Users/Jaydeep/Documents/NetBeansProjects/assignmet/src/studdb.accdb");
//            ps1=cn.prepareStatement("INSERT INTO stud(id,name,dob,address) VALUES(?,?,?,?)");
//            ps2=cn.prepareStatement("update stud set name=?,dob=?,address=? where id=?");
//        }
//        catch(SQLException ex)
//        {
//            System.out.println(ex);
//        }
//        lbl_id=new Label("Stud ID:");
//        lbl_name=new Label("Stud Name:");
//        lbl_dob=new Label("Stud DOB:");
//        lbl_add=new Label("Stud Address:");
//        l=new Label();
//        txt_id=new TextField();
//        txt_name=new TextField();
//        txt_dob=new TextField();
//        txt_add=new TextField();
//        btn_insert=new Button("Insert");
//        btn_update=new Button("Update");
//        btn_delete=new Button("Delete");
//        btn_search=new Button("Search");
//        btn_clear=new Button("Clear");
//        lbl_id.setBounds(50,50,80,30);
//        lbl_name.setBounds(50,100,80,30);
//        lbl_dob.setBounds(50,150,80,30);
//        lbl_add.setBounds(50,200,80,30);
//        txt_id.setBounds(150,50,200,30);
//        txt_name.setBounds(150,100,200,30);
//        txt_dob.setBounds(150,150,200,30);
//        txt_add.setBounds(150,200,200,30);
//        btn_insert.setBounds(50,250,80,40);
//        btn_insert.addActionListener(this);
//        btn_update.setBounds(150,250,80,40);
//        btn_update.addActionListener(this);
//        btn_delete.setBounds(250,250,80,40);
//        btn_delete.addActionListener(this);
//        btn_search.setBounds(350,250,80,40);
//        btn_search.addActionListener(this);
//        btn_clear.setBounds(450,250,80,40);
//        btn_clear.addActionListener(this);
//        l.setBounds(50,350,200,30);
//        add(lbl_id);
//        add(lbl_name);
//        add(lbl_dob);
//        add(lbl_add);
//        add(txt_id);
//        add(txt_name);
//        add(txt_dob);
//        add(txt_add);
//        add(btn_insert);
//        add(btn_update);
//        add(btn_delete);
//        add(btn_search);
//        add(l);
//        add(btn_clear);
//        setLayout(null);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==btn_insert)
//        {
//            int sid=Integer.parseInt(txt_id.getText());
//            String sname=txt_name.getText();
//            int dob=Integer.parseInt(txt_dob.getText());
//            int sadd=Integer.parseInt(txt_add.getText());
//            try
//            {
//                ps1.setInt(1,sid);
//                ps1.setString(2,sname);
//                ps1.setInt(3,dob);
//                ps1.setInt(4,sadd);
//                ps1.executeUpdate();
//                l.setText("Record Inserted!!");
//            }catch(SQLException ex){l.setText("Error!!");}
//        }
//        if(e.getSource()==btn_search)
//        {
//            int sid=Integer.parseInt(txt_id.getText());
//            String query="Select * from stud where id="+sid;
//            try
//            {
//                cn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Hardik/Documents/NetBeansProjects/assignmet/src/studdb.accdb");
//                Statement s=cn.createStatement();
//                ResultSet rs=s.executeQuery(query);
//                while(rs.next())
//                {
//                    txt_name.setText(rs.getString("name"));
//                    txt_dob.setText(String.valueOf(rs.getInt("dob")));
//                    txt_add.setText(String.valueOf(rs.getInt("address")));
//                }
//                cn.close();
//            }catch(SQLException ex){l.setText("Error!!");}
//        }
//        if(e.getSource()==btn_update)
//        {
//            int sid=Integer.parseInt(txt_id.getText());
//            String sname=txt_name.getText();
//            int dob=Integer.parseInt(txt_dob.getText());
//            int sadd=Integer.parseInt(txt_add.getText());
//            try
//            {
//                cn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Hardik/Documents/NetBeansProjects/assignmet/src/studdb.accdb");
//                Statement s=cn.createStatement();
//                ps2.setString(1,sname);
//                ps2.setInt(2,dob);
//                ps2.setInt(3,sadd);
//                ps2.setInt(4,sid);
//                ps2.executeUpdate();
//                l.setText("Record Updated!!");
//                cn.close();
//                txt_id.setText("");
//                txt_name.setText("");
//                txt_dob.setText("");
//                txt_add.setText("");
//            }catch(SQLException ex){l.setText("Error!!");}
//        }
//        if(e.getSource()==btn_delete)
//        {
//            int sid=Integer.parseInt(txt_id.getText());
//            String query="Delete from stud where id="+sid;
//            try
//            {
//                cn=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Hardik/Documents/NetBeansProjects/assignmet/src/studdb.accdb");
//                Statement s=cn.createStatement();
//                s.executeUpdate(query);
//                l.setText("Record Deleted!!");
//                txt_id.setText("");
//                txt_name.setText("");
//                txt_dob.setText("");
//                txt_add.setText("");
//                cn.close();
//            }
//            catch(SQLException x){System.out.println("Error in Delete"+x);}
//        }
//        if(e.getSource()==btn_clear)
//        {
//            txt_id.setText("");
//            txt_name.setText("");
//            txt_dob.setText("");
//            txt_add.setText("");
//        }
//    }
//}