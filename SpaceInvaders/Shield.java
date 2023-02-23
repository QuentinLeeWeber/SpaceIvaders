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
        public Shield(int x, int y)
    {
        try{
       image = ImageIO.read(new File("index.jpeg"));
       
    }catch(Exception e){
        
    }
    }
    
    public void draw(Graphics g){
    
        g.drawImage(image, 0, 0, null);
    }
    
    public void collide(){
        
    }
    
   public void move(boolean dir){
        
    }

}
    