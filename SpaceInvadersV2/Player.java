import java.awt.Graphics;
import java.applet.*;
import java.awt.Color;

public class Player{
    private int x,y;
    private int cooldown = 0;
    private int hitX = 150;
    private int hitY = 277;
    private int health = 3;
    private int score = -5;
    private boolean dead = false;
    private static int autoFire = 0;

    public Player(){
        x = 1980 / 2;
        y = 700;
    }
 
    public void draw(Graphics g){
        cooldown--;
        g.drawImage(Consts.playerImage, x, y, null);
        for(int i = 0;i < health;i++){
            g.drawImage(Consts.woickImage, i * 120, 920, null);
        }
        if(health == 0){
            score = 0;
            dead = true;
            GameLoop.pause();
        }
        g.setFont(g.getFont().deriveFont(30f));
        g.setColor(new Color(12, 109, 162));
        g.drawString("Score: " + String.valueOf(score), 10, 100);
        if(dead){
            g.drawImage(Consts.schabernackImage, 0, 0, null);
        }
        if(autoFire != 0){
            autoFire--;
            if(autoFire % 5 == 0){
                forceShoot();
            }
        }
    }
    
    public void shoot(){
        if(cooldown <= 0){
            cooldown = 20;
            GameLoop.newShoot(x, y);
        }
    }
    
    private void forceShoot(){
        GameLoop.newShoot(x, y);
    }
    
    public void collide(){
        health--;
    }
    
    public void move(boolean dir){  
        if(dir == true && !(x <= 0)){
            x= x - 10;
            return;
        } 
        if(dir == false && !(x >= Consts.width - 150)){
            x= x + 10;
            return;
        }
    }
    
    public void pressW(){
        if(dead){
            GameLoop.newGame();
            heal();
            dead = false;
        }
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
    public void heal(){
        health = 3;
    }
    public void addScore(int add){
        score = score + add;
    }
    public static void setAutoFire(int _v){
        autoFire = _v;
    }
}