/**
 *
 * @author GargiShah
 */
import java.awt.*;
class AWTAssociation
{
    AWTAssociation()
    {
        Frame f = new Frame();
        Button B = new Button("Click Me");
        B.setBounds(30,100,80,30);    // (x-axis, y-axis, width, height)
        f.add(B);
        f.setLayout(null);            //no layout manager 
        f.setSize(300,300);           // (Frame size = (width, height))
        f.setVisible(true);           // frame will be visible, default is false (Not visible)
        
    }
}
public class AWTAssociationExample {
    public static void main(String[] args)
    {
        AWTAssociation a = new AWTAssociation();
    }
}
