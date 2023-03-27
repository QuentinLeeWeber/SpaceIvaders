import java.awt.Graphics;

public class Enemy{
    
    private int time;
    private boolean dir = true;
    private int x, y;
    private int hitX = 150;
    private int hitY = 150;
    
    public Enemy(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    
    public void draw(Graphics g){
        g.drawImage(Consts.enemyImage, x, y, null);
    }
    
    public void update(){
        time++;
        if(time % (530 / 2)  == 0){
            dir = !dir;
            y += 25;
        }
        if(dir){
            x += 2;
        } else {
            x -= 2;
        }
        if(Math.round(Math.random() * 1500f - Start.getGame().getRounds() * 30) == 1){
            GameLoop.newEnemyShoot(x + 75, y);
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
