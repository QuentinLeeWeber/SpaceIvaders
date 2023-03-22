import java.awt.Graphics;
public class Projectile{

    private int x = 0;
    private int y = 0;
    private boolean isFriendly;
    private int hitX = 39;
    private int hitY = 75;
    
    public Projectile(int _x, int _y, boolean _isFriendly)
    {
        x = _x;
        y = _y;
        isFriendly = _isFriendly;
    }
    
    public void draw(Graphics g){
        if(isFriendly){
            y -= 10;
            g.drawImage(Consts.projectileImage, x, y, null);
        } else {
            y += 10;
            g.drawImage(Consts.enemyProjectileImage, x, y, null);
        }
    }
    
    public void collide(){
        
    }
    
    public void move(boolean dir){
        
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getHitX(){
        return hitX;
    }
    public int getHitY(){
        return hitY;
    }
}
