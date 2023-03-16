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
        if(dir == true && !(x <= 0))//1= heißt Beschreiben; 2== heißt Vergleichen 
        {
            x= x - 10;
            return;
        } 
        if(dir == false && !(x >= Consts.width - 150)){
            x= x + 10;
            return;
        }
    }
    
   /* public int getX(){
        
    }
    
    public int getY(){
        
    }*/
}