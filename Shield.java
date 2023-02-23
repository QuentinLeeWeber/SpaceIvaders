import java.awt.Graphics;
import java.awt.*;
import java.applet.*;
import java.io.File;
import javax.imageio.ImageIO;



public class Shield implements Consts
{
        private int x, y, width, height;
        private int[][] shieldPixels;
        private Image image;
        public Shield(int _x, int _y)
    {
            x = _x; y= _y; 
        try{
       image = ImageIO.read(new File("H:/Informatik/SpaceInvaders/ShieldTrek2.png"));
       
    }catch(Exception e){
        
    }
    }
    
    public void draw(Graphics g){
    
        g.drawImage(image, x, y, null);
    }
    
    public void collide(){
        
    }
    
   public void move(boolean dir){
        
    }

}
    