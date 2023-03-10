import java.awt.Graphics;

public class Enemy{
    
    
    int x, y;
    
    public Enemy(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    
    public void draw(Graphics g){
        g.drawImage(Consts.enemyImage, x, y, null);
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
}
