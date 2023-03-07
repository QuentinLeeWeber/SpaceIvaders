import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import java.io.File;          
import javax.imageio.ImageIO;    

    public class GameLoop extends JPanel implements Consts{
    
    private JFrame frame = new JFrame();
    public static Player player = new Player();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<Shield> shields = new ArrayList<Shield>();
    Shield testShield = new Shield(200, 400 );
    private Image image2;
    public GameLoop(){

    }
    
    
        public void start(){
        frame.add(this);
        frame.setSize(width, height);
        frame.setTitle("Space Invaders");
        frame.setVisible(true);
        KeyboardFocusManager m = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        MyKeyEventDispatcher dispatcher = new MyKeyEventDispatcher();
        m.addKeyEventDispatcher(dispatcher);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try{
                image2 = ImageIO.read(new File("space2.jpg"));
       
            }catch(Exception e){
        
            }
        while(true){
            frame.repaint();
            //System.out.println("yeet");
        }
    }
    
    private void newGame(){
        shields.clear();
        enemies.clear();
        projectiles.clear();
        
        shields.add(new Shield(200, 400));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.drawImage (image2, 0, 0, null); 
        g.setColor(new Color(255, 0, 0));
        g.fillRect(0, 0, 100, 100);
        player.draw(g);
        testShield.draw(g);
        for(int i = 0; i < shields.size();i++){
            shields.get(i).draw(g);
        }
        for(int i = 0; i < projectiles.size();i++){
            projectiles.get(i).draw(g);
        }
        for(int i = 0; i < enemies.size();i++){
            enemies.get(i).draw(g);
        }
    }
    
    public static void newShoot(int x, int y){
        
    }
    
    public static void newEnemyShoot(int x, int y){
        
    }
}

