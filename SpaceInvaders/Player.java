import java.awt.Graphics;
import java.applet.*;

public class Player{
    private int x,y;

    public Player(){
        x = 1980 / 2;
        y = 700;
    }
 
    public void draw(Graphics g){
        g.drawImage(Consts.playerImage, x, y, null);
    }
    
    public void collide(){
        //x = x - 1;
    }
    
    public void move(boolean dir){  
        if(dir == true)//1= heißt Beschreiben; 2== heißt Vergleichen 
        {
            x= x - 5;
        }else {
            x= x + 5;
        }
    }
    
   /* public int getX(){
        
    }
    
    public int getY(){
        
    }*/
}