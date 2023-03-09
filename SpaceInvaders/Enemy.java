import java.awt.Graphics;

public class Enemy implements Consts{
    
    
    int x, y;
    
    public Enemy()
    {

    }
    
    public void draw(Graphics g){
        g.drawImage(GameLoop.enemyImage, x, y, null);
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
}
