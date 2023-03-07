import java.awt.Graphics;
import java.applet.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player implements Consts
{
    private int x,y;
    
    static Image image;

    public Player(){
        try {
        image = ImageIO.read (new File ("Enterprise TopDown sniped.png"));
    }    catch(Exception e) {
    }
    }
 
    public void draw(Graphics g){
        g.fillRect(x, 200, 50, 50);
        x = x + 1;
        g.drawImage(image, 0, 0, null);
    }
    public void collide(){
        //x = x - 1;
    }
    
    public void move(boolean dir){
        
    }
    //700x 400
   /* public int getX(){
        
    }
    
    public int getY(){
        
    }*/
}