import java.awt.Graphics;
import java.awt.*;
import java.applet.*;

public class Shield{
    
    private int x, y, width, height;
    private int[][] shieldPixels;
    
    public Shield(int _x, int _y){
        x = _x; y= _y; 
    }
    
    public void draw(Graphics g){
        g.drawImage(Consts.shieldImage, x, y, null);
        x = 200;
        y= 550;
    }
    
    public void collide(){
        
    }
    
   public void move(boolean dir){
        
    }

}
    