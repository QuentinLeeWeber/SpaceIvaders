import java.awt.Graphics;

public class Enemy implements Consts{
    
    
    int x, y;
    
    public Enemy(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    
    public void draw(Graphics g){
        g.drawImage(GameLoop.enemyImage, x, y, null);
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
}
