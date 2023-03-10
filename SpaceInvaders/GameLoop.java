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
import java.awt.image.BufferedImage; 

    public class GameLoop extends JPanel{
    
    private JFrame frame = new JFrame();
    public static Player player = new Player();
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private static ArrayList<Shield> shields = new ArrayList<Shield>();
    Shield testShield = new Shield(200, 400 );
    public GameLoop(){

    }
    
    public void start(){
        frame.add(this);
        frame.setSize(Consts.width, Consts.height);
        frame.setTitle("Space Invaders");
        frame.setVisible(true);
        KeyboardFocusManager m = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        MyKeyEventDispatcher dispatcher = new MyKeyEventDispatcher();
        m.addKeyEventDispatcher(dispatcher);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            Consts.backgroundImage = ImageIO.read(new File("tex/space.jpg"));
            Consts.projectileImage = ImageIO.read(new File("tex/shot.png"));
            Consts.enemyImage = ImageIO.read(new File("tex/enemy.png"));
            Consts.playerImage = ImageIO.read(new File("tex/Enterprise TopDown sniped.png"));
            Consts.shieldImage = ImageIO.read(new File("tex/ShieldTrek2.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        newGame();
        while(true){
            frame.repaint();
        }
    }
    
    private void newGame(){
        shields.clear();
        enemies.clear();
        projectiles.clear();
        projectiles.add(new Projectile(100, 100));
        shields.add(new Shield(200, 400));
        enemies.add(new Enemy(500, 500));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        MyKeyEventDispatcher.update();
        g.drawImage(Consts.backgroundImage, 0, 0, null); 
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
        projectiles.add(new Projectile(x, y));
    }
    
    public static void newEnemyShoot(int x, int y){
        
    }
}

