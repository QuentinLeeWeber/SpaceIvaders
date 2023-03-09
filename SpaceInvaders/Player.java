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
    x = 1980 / 2;
        y = 700;
    }
 
    public void draw(Graphics g){
        
        g.drawImage(image, x, y, null);
        
    }
    public void collide(){
        //x = x - 1;
    }
    
    public void move(boolean dir){  
      if(dir == true)//1= heißt Beschreiben; 2== heißt Vergleichen 
      {
          x= x- 20;
        }else {
 
          x= x+ 20;
        }
    }
    
   /* public int getX(){
        
    }
    
    public int getY(){
        
    }*/
}