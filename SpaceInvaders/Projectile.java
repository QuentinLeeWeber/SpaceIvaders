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
        g.drawImage(GameLoop.image2, x, y, null);
        System.out.println("hi");
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
}
