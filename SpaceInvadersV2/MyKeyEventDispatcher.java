import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
public class MyKeyEventDispatcher implements KeyEventDispatcher {
    
    public static boolean w;
    public static boolean a;
    public static boolean d;
    
    public static void update(){
        if(w){
            
        }
        if(a){
            GameLoop.player.move(true);
        }
        if(d){
            GameLoop.player.move(false);
        }
    }
    
    public boolean dispatchKeyEvent(KeyEvent e) { 
        if(e.getID() == KeyEvent.KEY_PRESSED){
            if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                a = true;   
            }
            if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                d = true;   
            }
            if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W'){
                GameLoop.player.pressW();
                w = true;   
            }
            if(e.getKeyChar() == KeyEvent.VK_SPACE){
                GameLoop.player.shoot();
            }
            return false;
        }
        
        if(e.getID() == KeyEvent.KEY_RELEASED){
            if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
                a = false;   
            }
            if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                d = false;   
            }
            if(e.getKeyChar() == 'w' || e.getKeyChar() == 'W'){
                w = false;   
            }
            return false;
        }
        return false;
      }
}