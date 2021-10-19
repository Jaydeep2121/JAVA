/*
    Create Java application or an Applet, for registering the product with Prod
 ID, Name, Price and Quantity. Also allow search operation to search for specific
 product based on product ID. The customer may buy a product, while buying a
 product check whether product with enough quantity is available or not. If yes,
 allow customer to buy the product and accordingly update the quantity of the
 product in database. If not, throw the custom exception
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jaydeep Chauhan
 */
public class internal_exam extends Frame implements ActionListener{
    TextField p_id, p_name, p_price, p_qty;
    Label l1, l2, l3, l4;
    Button ins, buy, search;
    Connection cn;
    PreparedStatement p;
    Statement s = null;
    internal_exam() throws SQLException{
        cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
        s=cn.createStatement();
        Font f = new Font("Serif", Font.BOLD, 15);
        l1 = new Label("product no : ");
        l2 = new Label("product name : ");
        l3 = new Label("product price : ");
        l4 = new Label("product quantity :");
        l1.setFont(f);l2.setFont(f);
        l3.setFont(f);l4.setFont(f);
        
        p_id = new TextField("");
        p_name = new TextField("");
        p_price = new TextField("");
        p_qty = new TextField("");
        
        ins = new Button("Insert");
        ins.setFont(f);
        buy = new Button("Buy");
        buy.setFont(f);
        search = new Button("Search");
        search.setFont(f);
        
        ins.addActionListener(this);buy.addActionListener(this);
        search.addActionListener(this);
        
        l1.setBounds(100, 70, 130, 20);l2.setBounds(100, 120, 130, 20);
        l3.setBounds(100, 170, 130, 20);l4.setBounds(100, 220, 130, 20);
        
        p_id.setBounds(250, 70, 200, 30);p_name.setBounds(250, 120, 200, 30);
        p_price.setBounds(250, 170, 100, 30);p_qty.setBounds(250, 220, 140, 30);
        
        ins.setBounds(550, 70, 100, 30);buy.setBounds(550, 130, 100, 30);
        search.setBounds(550, 190, 100, 30);
        
        add(l1);add(l2);add(l3);add(l4);add(ins);add(buy);add(search);
        add(p_id);add(p_name);add(p_price);add(p_qty);
        
        addWindowListener(new WindowAdapter(){@Override
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        
        setLayout(null);setVisible(true);setSize(700,700);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ResultSet rs;
        if(e.getSource()==ins){
                    if((!"".equals(p_id.getText())) && (!"".equals(p_name.getText()))&& (!"".equals(p_qty.getText())) && (!"".equals(p_price.getText()))){
                        try{
                           if(e.getSource()==ins){
                               p=cn.prepareStatement("insert into product_tbl (prod_name,prod_price,prod_quantity,prod_id)values(?,?,?,?)");
                           }       
                           p.setString(1,p_name.getText());
                           p.setInt(2,Integer.parseInt(p_price.getText()));
                           p.setInt(3,Integer.parseInt(p_qty.getText()));
                           p.setInt(4, Integer.parseInt(p_id.getText()));
                           p.executeUpdate();
                           if(e.getSource()==ins){
                               JOptionPane.showMessageDialog(ins,"data inserted successfully.....");
                           }
                           p.close();
                           p_id.setText("");p_name.setText("");p_qty.setText("");p_price.setText("");
                       }catch(SQLException ex){
                           Logger.getLogger(Login_page.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }else if("".equals(p_id.getText()) || "".equals(p_name.getText()) || "".equals(p_qty.getText()) || "".equals(p_price.getText())){
                            System.out.println("All Fields required to be filled...");
                    }
        }else if(e.getSource()==search){
                int cnt=0;
                try {
                    p=cn.prepareStatement("select count(*) from product_tbl where prod_id=?");
                    p.setInt(1, Integer.parseInt(p_id.getText()));
                    rs=p.executeQuery();
                    rs.next();cnt = rs.getInt(1);
                    p=cn.prepareStatement("select * from product_tbl where prod_id=?");
                    p.setInt(1, Integer.parseInt(p_id.getText()));
                    rs=p.executeQuery();
                    while(rs.next()){
                        if(cnt==1){
                            p_id.setText(rs.getString("prod_id"));
                            p_name.setText(rs.getString("prod_name"));
                            p_price.setText(rs.getString("prod_price"));
                            p_qty.setText(rs.getString("prod_quantity"));
                        }
                    }
                    if(cnt==0){JOptionPane.showMessageDialog(search, "No Record Found.....!","Alert",JOptionPane.WARNING_MESSAGE);p_id.setText("");p_name.setText("");p_qty.setText("");p_price.setText("");}
                } catch (SQLException ex) {
                    Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource()==buy){
                int cnt=0;
                try{
                        p=cn.prepareStatement("select count(*) from product_tbl where prod_name=? and prod_quantity>0");
                        p.setString(1,p_name.getText());
                        rs=p.executeQuery();
                        rs.next();cnt=rs.getInt(1);
                        if(cnt==1){
                            p=cn.prepareStatement("update product_tbl set prod_quantity=(prod_quantity-1) where prod_name=?");
                            p.setString(1, p_name.getText());
                            p.executeUpdate();
                            p=cn.prepareStatement("select prod_quantity from product_tbl where prod_name=?");
                            p.setString(1, p_name.getText());
                            rs=p.executeQuery();
                            rs.next();
                            JOptionPane.showMessageDialog(buy, "1 product purchased by customer "+ rs.getString("prod_quantity")+ " Left");
                        }else{
                            if(cnt==0){JOptionPane.showMessageDialog(search, "No Record Found.....!","Alert",JOptionPane.WARNING_MESSAGE);}
                        }
                }catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                }
            }
    }
    public static void main(String[] args) throws SQLException{
            new internal_exam();
    }
}
