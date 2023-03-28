import java.awt.Graphics;
import java.awt.image.BufferedImage; 

public class Biden{
    
    private static float x = 800;
    private static float y = 800;
    private static int mouseX;
    private static int mouseY;
 
    private static boolean isVisible = false;
    
    public Biden(){
        
    }
    
    public void draw(Graphics g){
        if(isVisible){
            g.drawImage(Consts.bidenImage, (int) (x), (int) (y), null);
            return;
        }
        if(!isVisible){
            if(Math.round(Math.random() * Consts.bidenChance) == 1){
                isVisible = true;
                x = (float) (Math.random() * (Consts.width - 100)) + 50;
                y = (float) (Math.random() * (Consts.height -100)) + 50;
            }
        }
        
        /*if(!isVisible){
            if(Math.round(Math.random() * Consts.bidenChance) == 1){
                isVisible = true;
                x = (float) (Math.random() * Consts.width);
                y = (float) (Math.random() * Consts.height);
                if(flipFlop == false){
                    Player.setAutoFire(240); 
                    flipFlop = true;
                    isVisible = false;
                }
            }
        } else {
            g.drawImage(Consts.bidenImage, (int) (x), (int) (y), null);
            flipFlop = false;
        }*/
    }
    
    public static void click(){
        if(mouseX >= x && mouseX <= x + 60){
            if(mouseX >= x && mouseX <= x + 60){
                isVisible = false;
                Player.setAutoFire(240); 
            }
        }
    }
    
    public static void updateMouse(int _x, int _y){
        mouseX = _x;
        mouseY =_y;
    }
}
