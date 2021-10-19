/*
[4] Create an application for employee registration with fields employee number, name, gander (Radio
button), age, department (choice box), basic salary. While registering an employee number should not
be black and age should be between 25 to 40. If not throw custom exception. Also provide operations
to perform reset, delete, update and search on basis of employee number. Provide navigation buttons
for first, next, last and previous.
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
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Registration_page extends Frame implements ActionListener{
    TextField e_no, e_name, age, sal;
    CheckboxGroup gen;
    Checkbox Male, Female;
    Label l1, l2, l3, l4, l5, l6, msg;
    Button ins, up, del, reset, first, next, prev, last, search;
    Choice dept;
    Connection cn;
    PreparedStatement p;
    Statement s = null;
    
    Registration_page() throws SQLException{
        cn=DriverManager.getConnection("jdbc:ucanaccess://D:/Codes/Java/database.accdb");
        s=cn.createStatement();
        Font f = new Font("Serif", Font.BOLD, 15);
        l1 = new Label("Emp_No : ");
        l2 = new Label("Emp_Name : ");
        l3 = new Label("Gender : ");
        l4 = new Label("Age");
        l5 = new Label("Salary : ");
        l6 = new Label("Department : ");
        msg = new Label();
        l1.setFont(f);l2.setFont(f);
        l3.setFont(f);l4.setFont(f);
        l5.setFont(f);l6.setFont(f);
        msg.setFont(f);

        e_no = new TextField("");
        e_name = new TextField("");
        age = new TextField("");
        sal = new TextField("");
        gen = new CheckboxGroup();
        Male = new Checkbox("Male", gen, true);
        Male.setFont(f);
        Female = new Checkbox("Female", gen, false);
        Female.setFont(f);

        dept = new Choice();
        dept.add("Purchase");
        dept.add("Manufacturing");
        dept.add("sale");
        dept.add("Collection");
        dept.setBounds(250, 320, 100, 30);
        dept.setFont(f);add(dept);

        ins = new Button("Insert");
        ins.setFont(f);
        up = new Button("Update");
        up.setFont(f);
        del = new Button("Delete");
        del.setFont(f);
        reset = new Button("Reset");
        reset.setFont(f);
        search = new Button("Search");
        search.setFont(f);

        first = new Button("<<  First");
        first.setFont(f);
        last = new Button("Last  >>");
        last.setFont(f);
        next = new Button("Next >");
        next.setFont(f);
        prev = new Button("< Prev ");
        prev.setFont(f);

        ins.addActionListener(this);up.addActionListener(this);
        del.addActionListener(this);reset.addActionListener(this);
        search.addActionListener(this);first.addActionListener(this);
        prev.addActionListener(this);next.addActionListener(this);
        last.addActionListener(this);

        l1.setBounds(100, 70, 130, 20);l2.setBounds(100, 120, 130, 20);
        l3.setBounds(100, 170, 130, 20);l4.setBounds(100, 220, 130, 20);
        l5.setBounds(100, 270, 130, 20);l6.setBounds(100, 320, 130, 20);
        msg.setBounds(350, 30, 210, 30);

        e_no.setBounds(250, 70, 200, 30);e_name.setBounds(250, 120, 200, 30);
        Male.setBounds(250, 170, 80, 30);Female.setBounds(330, 170, 120, 30);
        age.setBounds(250, 220, 100, 30);sal.setBounds(250, 270, 140, 30);
        
        ins.setBounds(550, 70, 100, 30);up.setBounds(550, 130, 100, 30);
        del.setBounds(550, 190, 100, 30);reset.setBounds(550, 250, 100, 30);
        search.setBounds(550, 310, 100, 30);
        first.setBounds(100, 400, 100, 30);prev.setBounds(220, 400, 100, 30);
        next.setBounds(340, 400, 100, 30);last.setBounds(460, 400, 100, 30);

        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(msg);
        add(e_no);add(e_name);add(Male);add(Female);add(age);add(sal);
        add(ins);add(up);add(del);add(reset);
        add(search);add(first);add(prev);add(next);add(last);

        addWindowListener(new WindowAdapter(){@Override
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
        });
        
        setLayout(null);setVisible(true);setSize(700,700);
    }
    public void show(ResultSet rr) throws SQLException{
            System.out.println(rr.getString("emp_no"));
            e_no.setText(rr.getString("emp_no"));
            e_name.setText(rr.getString("emp_name"));
            dept.select(rr.getString("emp_dept"));
            sal.setText(rr.getString("emp_salary"));
            age.setText(rr.getString("emp_age"));
            if (rr.getString("emp_gender").equals("Male")) {
                Male.setState(true);
            } else {
                Female.setState(true);
            }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        ResultSet rs;
        if((e.getSource()==up || e.getSource()==ins)){
                    if((!"".equals(e_no.getText())) && (!"".equals(e_name.getText()))&& (!"".equals(age.getText())) && (!"".equals(sal.getText())) &&(Integer.parseInt(age.getText())>25 && Integer.parseInt(age.getText())<40)){
                       try{
                           if(e.getSource()==ins){
                               p=cn.prepareStatement("insert into emp (emp_name,emp_gender,emp_age,emp_dept,emp_salary,emp_no)values(?,?,?,?,?,?)");
                           }else if(e.getSource()==up){
                               p=cn.prepareStatement("update emp set emp_name=? ,emp_gender=?,emp_age=?,emp_dept=?,emp_salary=? where emp_no=?");
                           }       
                           p.setString(1,e_name.getText());
                           p.setString(2,gen.getSelectedCheckbox().getLabel());
                           p.setInt(3,Integer.parseInt(age.getText()));
                           p.setString(4,dept.getSelectedItem());
                           p.setInt(5,Integer.parseInt(sal.getText()));
                           p.setInt(6, Integer.parseInt(e_no.getText()));
                           p.executeUpdate();
                           if(e.getSource()==ins){
                               msg.setText("Insert Successfully.....");
                           }else if(e.getSource()==up){
                               msg.setText("Update Successfully.....");
                           }
                           p.close();
                           e_no.setText("");e_name.setText("");age.setText("");sal.setText("");
                           msg.setForeground(Color.GREEN);
                       }catch(SQLException ex){
                           Logger.getLogger(Login_page.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }else if("".equals(e_no.getText()) || "".equals(e_name.getText()) || "".equals(age.getText()) || "".equals(sal.getText())){
                            msg.setText("All Fields required to be filled...");msg.setForeground(Color.RED);
                    }else if((Integer.parseInt(age.getText())<25 || Integer.parseInt(age.getText())>40)){
                                msg.setText("Age must be 25 to 40");msg.setForeground(Color.RED);
                    }   
            }else if(e.getSource()==reset){
                e_no.setText("");e_name.setText("");age.setText("");sal.setText("");
            }else if(e.getSource()==del){
                try {
                    p=cn.prepareStatement("delete from emp where emp_no=?");
                    p.setInt(1,Integer.parseInt(e_no.getText()));
                    p.executeUpdate();
                    msg.setText("record deleted...");
                    msg.setForeground(Color.GREEN);
                    e_no.setText("");e_name.setText("");age.setText("");sal.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource()==search){
                int cnt=0;
                try {
                    p=cn.prepareStatement("select count(*) from emp where emp_no=?");
                    p.setInt(1, Integer.parseInt(e_no.getText()));
                    rs=p.executeQuery();
                    rs.next();cnt = rs.getInt(1);
                    p=cn.prepareStatement("select * from emp where emp_no=?");
                    p.setInt(1, Integer.parseInt(e_no.getText()));
                    rs=p.executeQuery();
                    while(rs.next()){
                        if(cnt==1){
                            e_no.setText(rs.getString("emp_no"));
                            e_name.setText(rs.getString("emp_name"));
                            age.setText(rs.getString("emp_age"));
                            dept.select(rs.getString("emp_dept"));
                            sal.setText(rs.getString("emp_salary"));
                            if (rs.getString("emp_gender").equals("Male")) {
                                Male.setState(true);
                            } else {
                                Female.setState(true);
                            }
                        }
                    }
                    if(cnt==0){msg.setText("No Record Found.....!");msg.setForeground(Color.red);e_no.setText("");e_name.setText("");age.setText("");sal.setText("");}
                } catch (SQLException ex) {
                    Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource()==first){
                try {
                    rs=s.executeQuery("select * from emp order by emp_no asc limit 1");
                    rs.next();
                    show(rs);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == prev) {
                try {
                        p = cn.prepareStatement("select * from emp where emp_no=?");
                        p.setInt(1, Integer.parseInt(e_no.getText())-1);
                        rs=p.executeQuery();
                        rs.next();
                        show(rs);
                } catch (SQLException ex) {
                        Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
        } else if (e.getSource() == next) {
            try {
                p = cn.prepareStatement("select * from emp where emp_no=?");
                p.setInt(1, Integer.parseInt(e_no.getText())+1);
                rs=p.executeQuery();
                rs.next();
                show(rs);
            } catch (SQLException ex) {
                Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == last) {
                try {
                    rs=s.executeQuery("select * from emp order by emp_no desc limit 1");
                    rs.next();
                    show(rs);
                } catch (SQLException ex) {
                    Logger.getLogger(Registration_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        public static void main(String[] args) throws SQLException {
            new Registration_page();
        }
    }
