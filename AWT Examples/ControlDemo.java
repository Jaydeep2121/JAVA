/**
 *
 * @author GargiShah
 */
import java.awt.*;

public class ControlDemo {
    public static void main(String[] args)
    {
        Frame f = new Frame("Control Demo");
        TextField t1,t2;
        
        Label l1 = new Label("Roll No");
        l1.setBounds(50,50,100,30);
        
        t1 =  new TextField("");
        t1.setBounds(150,50,100,30);
        
        Label l2 = new Label("Name");
        l2.setBounds(50,80,100,30);
        
        t2 =  new TextField("");
        t2.setBounds(150,75,100,30);
        
        f.setSize(1000,1000);
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        
        Label l3 = new Label("Introduction");
        l3.setBounds(50,100,100,30);
        
        TextArea area = new TextArea("Introduce Yourself");
        area.setBounds(150,100,150,150);
        f.add(l3);
        f.add(area);
        
        Label l4 = new Label("Subject :");
        l4.setBounds(50,260,100,30);
        f.add(l4);
        
        Checkbox c1 = new Checkbox("Java", true);
        c1.setBounds(150,260,50,50);
        f.add(c1);
        
        Checkbox c2 = new Checkbox("C++") ;
        c2.setBounds(230,260,50,50);
        f.add(c2);
       
        Label l5 = new Label("Gender");
        l5.setBounds(50,300,100,30);
        f.add(l5);
        
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox c3 = new Checkbox("Male", cbg, true);
        c3.setBounds(150,300,50,50);
        
        
        Checkbox c4 = new Checkbox("Female", cbg, false);
        c4.setBounds(200,300,50,50);
        
        f.add(c3);
        f.add(c4);
        
        Label l6 = new Label("Fav Colour");
        l6.setBounds(50,350,100,30);
        f.add(l6);
        
        Choice c = new Choice();
        c.setBounds(150,350,75,75);
        c.add("Red");
        c.add("Black");
        c.add("Blue");
        c.add("white");
        f.add(c);
        
        Label l7 = new Label("State");
        l7.setBounds(50,425,100,30);
        f.add(l7);
        
        List lst1 = new List(4);
        lst1.setBounds(150,425,75,75);
        lst1.add("Gujarat");
        lst1.add("Maharastra");
        lst1.add("Rajasthan");
        lst1.add("Madhya Pradesh");
        f.add(lst1);
        
        Button b = new Button("Submit");
        b.setBounds(75,510,100,30);
        f.add(b);
        
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("File");
        Menu menu1 = new Menu("Help");
        Menu submenu = new Menu("Edit");
        
        MenuItem m1 = new MenuItem("New");
        MenuItem m2 = new MenuItem("Open");
        MenuItem m3 = new MenuItem("Save");
        MenuItem m4 = new MenuItem("Cut");
        MenuItem m5 = new MenuItem("Copy");
        MenuItem m6 = new MenuItem("Paste");
        
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        submenu.add(m4);
        submenu.add(m5);
        submenu.add(m6);
        
        menu.add(submenu);
        mb.add(menu);
        mb.add(menu1);
        f.setMenuBar(mb);
        
        f.setLayout(null);
        f.setVisible(true);
    }
}
