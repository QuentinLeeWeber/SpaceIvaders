import java.awt.Graphics;

public class Projectile implements Consts{

    int x = 0;
    int y = 0;
    
    public Projectile(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    
    public void draw(Graphics g){
        g.drawImage(GameLoop.projectileImage, x, y, null);
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
}
