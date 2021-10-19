/*
[3]Create an applet that performs insert, update, delete and search operation on
ITEM table. ITEM table have fields like Item No, Name of the item, price
and quantity.
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jaydeep Chauhan
 */
public class item_applet extends Applet implements
ActionListener{
         TextField itm_no, itm_name, itm_price, itm_qty;
         Label l1, l2, l3, l4;
         Button ins, up, del,search;
         Connection cn ;
         PreparedStatement p;
         Statement s = null;
         public void init(){
             try {
                cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
                s=cn.createStatement();
             } catch (SQLException ex) {
                 System.out.println("Error at connection time");
                 Logger.getLogger(item_applet.class.getName()).log(Level.SEVERE, null, ex);
             }
            Font f = new Font("Serif", Font.BOLD, 15);
            l1 = new Label("Item_No : ");
            l2 = new Label("Item_Name : ");
            l3 = new Label("Item_Price : ");
            l4 = new Label("Item_Quantity : ");
            l1.setFont(f);l2.setFont(f);
            l3.setFont(f);l4.setFont(f);
            
            itm_no = new TextField("");
            itm_name = new TextField("");
            itm_price = new TextField("");
            itm_qty = new TextField("");
            ins = new Button("Register");
            ins.setFont(f);
            
            ins = new Button("Insert");
            ins.setFont(f);
            up = new Button("Update");
            up.setFont(f);
            del = new Button("Delete");
            del.setFont(f);
            search = new Button("Search");
            search.setFont(f);
            
            ins.addActionListener(this);up.addActionListener(this);
            del.addActionListener(this);search.addActionListener(this);

            l1.setBounds(100, 70, 130, 20);l2.setBounds(100, 120, 130, 20);
            l3.setBounds(100, 170, 130, 20);l4.setBounds(100, 220, 130, 20);
            ins.setBounds(550, 70, 100, 30);up.setBounds(550, 130, 100, 30);
            del.setBounds(550, 190, 100, 30);search.setBounds(550, 250, 100, 30);
            itm_no.setBounds(250, 70, 200, 30);itm_name.setBounds(250, 120, 200, 30);
            itm_price.setBounds(250, 170, 100, 30);itm_qty.setBounds(250, 220, 140, 30);
            
            add(l1);add(l2);add(l3);add(l4);add(ins);add(up);add(del);add(search);
            add(itm_no);add(itm_name);add(itm_price);add(itm_qty);
            setLayout(null);setVisible(true);setSize(700,700);
         }
         @Override
         public void actionPerformed(ActionEvent e){
             if((e.getSource()==up || e.getSource()==ins)){
                if((!"".equals(itm_no.getText())) && (!"".equals(itm_name.getText()))&& (!"".equals(itm_price.getText())) && (!"".equals(itm_qty.getText()))){
                    try{
                           if(e.getSource()==ins){
                               p=cn.prepareStatement("insert into item_tbl (itm_name,itm_price,itm_quantity,itm_no)values(?,?,?,?)");
                           }else if(e.getSource()==up){
                               p=cn.prepareStatement("update item_tbl set itm_name=? ,itm_price=?,itm_quantity=? where itm_no=?");
                           }       
                           p.setString(1,itm_name.getText());
                           p.setInt(2,Integer.parseInt(itm_price.getText()));
                           p.setInt(3,Integer.parseInt(itm_qty.getText()));
                           p.setInt(4, Integer.parseInt(itm_no.getText()));
                           p.executeUpdate();
                           if(e.getSource()==ins){
                               JOptionPane.showMessageDialog(ins,"Data Saved successfully..");
                           }else if(e.getSource()==up){
                               JOptionPane.showMessageDialog(up,"Data Updated successfully..");
                           }
                           p.close();
                           itm_no.setText("");itm_name.setText("");itm_price.setText("");itm_qty.setText("");
                       }catch(SQLException ex){
                           Logger.getLogger(item_applet.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }else if("".equals(itm_no.getText()) || "".equals(itm_name.getText()) || "".equals(itm_price.getText()) || "".equals(itm_qty.getText())){
                            if(e.getSource()==ins){
                                JOptionPane.showMessageDialog(ins, "TextFiled Can't be blank","Alert",JOptionPane.WARNING_MESSAGE);
                            }else if(e.getSource()==up){
                                JOptionPane.showMessageDialog(up, "TextFiled Can't be blank","Alert",JOptionPane.WARNING_MESSAGE);
                            } 
                    }
                }else if(e.getSource()==del){
                    try {
                        p=cn.prepareStatement("delete from item_tbl where itm_no=?");
                        p.setInt(1,Integer.parseInt(itm_no.getText()));
                        p.executeUpdate();
                        JOptionPane.showMessageDialog(del, "Record deleted....!","Alert",JOptionPane.WARNING_MESSAGE);
                        itm_no.setText("");itm_name.setText("");itm_price.setText("");itm_qty.setText("");
                        p.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(item_applet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(e.getSource()==search){
                int cnt=0;
                int sno=Integer.parseInt(itm_no.getText());
                Resultset rs;
                try {
                    p=cn.prepareStatement("select count(*) from item_tbl where itm_no=?");
                    p.setInt(1, sno);
                    rs=p.executeQuery();
                    rs.next();cnt = rs.getInt(1);
                    p=cn.prepareStatement("select * from item_tbl where itm_no=?");
                    p.setInt(1, sno);
                    rs= p.executeQuery();
                    while(rs.next()){
                        if(cnt==1){
                            itm_no.setText(rs.getInt("itm_no"));
                            itm_name.setText(rs.getString("itm_name"));
                            itm_price.setText(rs.getString("itm_price"));
                            itm_qty.setText(rs.getInt("itm_quantity"));
                        }
                    }
                    if(cnt==0){JOptionPane.showMessageDialog(search, "No Record Found.....!","Alert",JOptionPane.WARNING_MESSAGE);itm_no.setText("");itm_name.setText("");itm_price.setText("");itm_qty.setText("");}
                } catch (SQLException ex) {
                    Logger.getLogger(item_applet.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
}
