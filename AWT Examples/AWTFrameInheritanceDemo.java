/**
 *
 * @author GargiShah
 * 
 */
import java.awt.*;
class FirstAWT extends Frame
{
    FirstAWT()
    {
        Button B = new Button("Click Me");
        B.setBounds(30,100,80,30);    // (x-axis, y-axis, width, height)
        add(B);
        setLayout(null);            //no layout manager 
        setSize(300,300);           // (Frame size = (width, height))
        setVisible(true);           // frame will be visible, default is false (Not visible)
    }
}
public class AWTFrameInheritanceDemo {
    public static void main(String[] args)
    {
        FirstAWT f = new FirstAWT();
        
    }
}
