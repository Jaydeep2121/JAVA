/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.awt.*;
/**
 *
 * @author Jaydeep Chauhan
 */
public class ImageApplet extends Applet {
    Image picture;
    public void init() 
    {
        picture = getImage(getDocumentBase(),"tense.png");
        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g)
    {
        g.drawImage(picture, 10,10, this);
    }
 // TODO overwrite start(), stop() and destroy() methods
}
