/**
 *
 * @author GargiShah
 */
import java.awt.*;
import java.awt.event.*;
 
public class EventListenerDemo extends Frame implements ActionListener
{
    TextField t1,t2,t3;
    Button b1,b2,b3;
    TextArea area;
    Label l1,l2;
    EventListenerDemo()
    {
        //Frame f = new Frame();
        t1 = new TextField();
        t1.setBounds(50,50,100,30);
        
        t2 = new TextField();
        t2.setBounds(200,50,100,30);
        
        t3 = new TextField();
        t3.setBounds(100,100,100,30);
        t3.setEditable(false);
        
        b1 = new Button("+");
        b1.setBounds(100,150,50,50);
                
        b2 = new Button("-");
        b2.setBounds(170,150,50,50);
        
        area = new TextArea();
        area.setBounds(50,250,200,200);
        
        l1 = new Label();
        l1.setBounds(100,470,100,30);
        
        l2 = new Label();
        l2.setBounds(220,470,100,30);
        
        b3 = new Button("Count");
        b3.setBounds(150,510,100,30);
        
        add(t1);
        add(t2);
        add(t3);
        add(b1);
        add(b2);
        add(area);
        add(b3);
        add(l1);
        add(l2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setSize(700,700);  
        setLayout(null);  
        setVisible(true);  
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String s1 = t1.getText();
        String s2 = t2.getText();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        
        int c=0;
        
        if(e.getSource() == b1)
        {
            c = a + b;
        }
        else if(e.getSource() == b2)
        {
            c = a - b;
        }
        String result = String.valueOf(c);
        t3.setText(result);
        
        if(e.getSource() ==  b3)
        {
            String text = area.getText();
            String words[] = text.split("\\s");
            
            l1.setText("words :" + words.length);
            l2.setText("Chars : " + text.length());
        }
    }
    public static void main(String[] args)
    {
        EventListenerDemo e1 = new EventListenerDemo();
    }
}
