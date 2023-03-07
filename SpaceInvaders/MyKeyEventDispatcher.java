import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;


public class MyKeyEventDispatcher implements KeyEventDispatcher 
{
  public boolean dispatchKeyEvent(KeyEvent e) {
    
    if (e.getID() == KeyEvent.KEY_TYPED) {
      
    } else if (e.getID() == KeyEvent.KEY_PRESSED){
      if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
          GameLoop.player.move(true);
          
        }
      if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
          GameLoop.player.move(false);
          
        }
    } else if (e.getID() == KeyEvent.KEY_RELEASED) {
      //main.cam1.release(e.getKeyChar());
    }
    
    return false;
  }
  
}