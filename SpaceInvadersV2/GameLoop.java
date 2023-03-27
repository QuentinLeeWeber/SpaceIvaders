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
import java.util.Iterator;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

    public class GameLoop extends JPanel{
    
    private JFrame frame = new JFrame();
    public static Player player = new Player();
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private static ArrayList<Projectile> enemyProjectiles = new ArrayList<Projectile>();
    private static ArrayList<Fraction> fractions = new ArrayList<Fraction>();
    private int loops = 0;
    private static boolean paused = false;
    private static int rounds = 0;
    private Biden biden = new Biden();
    private MyMouseMotionListener MML = new MyMouseMotionListener();
    private MyMouseListener ML = new MyMouseListener();
    
    //private JLabel explosionLabel;
    
    public GameLoop(){}
    
    public void start(){
        frame.add(this);
        frame.setSize(Consts.width, Consts.height);
        frame.setTitle("Space Invaders");
        frame.setVisible(true);
        frame.addMouseMotionListener(MML);
        frame.addMouseListener(ML);
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
            Consts.enemyProjectileImage = ImageIO.read(new File("tex/enemyShot.png"));
            Consts.woickImage = ImageIO.read(new File("tex/woick.png"));
            Consts.schabernackImage = ImageIO.read(new File("tex/schabernack.png"));
            Consts.fraction1Image = ImageIO.read(new File("tex/fraction1.png"));
            Consts.fraction2Image = ImageIO.read(new File("tex/fraction2.png"));
            Consts.fraction3Image = ImageIO.read(new File("tex/fraction3.png"));
            Consts.fraction4Image = ImageIO.read(new File("tex/fraction4.png"));
            Consts.fraction5Image = ImageIO.read(new File("tex/fraction5.png"));
            Consts.bidenImage = ImageIO.read(new File("tex/biden.png"));
            //URL url = this.getClass().getResource("tex/explosion.gif");
            //Consts.explosionGif = new ImageIcon(url);
            //frame.setContentPane(new JLabel(Consts.explosionGif));
        }catch(Exception e){
            e.printStackTrace();
        }
        newGame();
        final int TICKS_PER_SECOND = Consts.tps;
        final int MAX_FRAMESKIP = 5;
        final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
        double next_game_tick = System.currentTimeMillis();
        int loops;
        while (true) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP) {
                frame.repaint();
                next_game_tick += SKIP_TICKS;
                loops++;
            }
        }
    }
    
    public static void newGame(){
        enemies.clear();
        projectiles.clear();
        enemyProjectiles.clear();
        for(int x = 0;x < 7;x++){
            for(int y = 0;y < 3;y++){
                enemies.add(new Enemy(x * 200, y * 150));
            }
        }
        rounds++;
        paused = false;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        MyKeyEventDispatcher.update();
        calcPhysic();
        g.drawImage(Consts.backgroundImage, 0, 0, null); 
        for(Iterator<Projectile> iter = projectiles.iterator(); iter.hasNext();) {
            Projectile element = iter.next();
            if(element.getY() <= -40) {
            iter.remove();
            }
            element.draw(g);
        }
        for(Iterator<Projectile> iter = enemyProjectiles.iterator(); iter.hasNext();) {
            Projectile element = iter.next();
            if(element.getY() <= -40) {
            iter.remove();
            }
            element.draw(g);
        }
        for(int i = 0; i < enemies.size();i++){
            enemies.get(i).draw(g);
            if(!paused){
                enemies.get(i).update();
            }
        }
        for(Iterator<Fraction> iter = fractions.iterator(); iter.hasNext();) {
            Fraction element = iter.next();
            if(element.getY() >= Consts.height + 20) {
                iter.remove();
            }
            element.draw(g);
        }
        player.draw(g);
        biden.draw(g);
        if(enemies.size() == 0){
            newGame();
            player.addScore(5);
        }
    }
    
    public void calcPhysic(){
        for(Iterator<Projectile> pIter = projectiles.iterator(); pIter.hasNext();) {
            Projectile projectile = pIter.next();
            for(Iterator<Enemy> eIter = enemies.iterator(); eIter.hasNext();) {
                Enemy enemy = eIter.next();
                if(projectile.getX() <= enemy.getX() + enemy.getHitX() && projectile.getX() >= enemy.getX() - projectile.getHitX()){
                    if(projectile.getY() <= enemy.getY() + enemy.getHitY() && projectile.getY() >= enemy.getY() - projectile.getHitY()){
                        
                        //f1 = new Fraction(100, 100, 1);
                        //f2 = new Fraction(145, 100, 2);
                        //f3 = new Fraction(145, 141, 3);
                        //f4 = new Fraction(100, 141, 4);
                        //f5 = new Fraction(122, 190, 5);
                        
                        
                        fractions.add(new Fraction(enemy.getX() + 30, enemy.getY() + 10, 1));
                        fractions.add(new Fraction(enemy.getX() + 45 + 30, enemy.getY() + 10, 2));
                        fractions.add(new Fraction(enemy.getX() + 45 + 30, enemy.getY() + 41 + 10, 3));
                        fractions.add(new Fraction(enemy.getX() + 30, enemy.getY() + 41 + 10, 4));
                        fractions.add(new Fraction(enemy.getX() + 22 + 30, enemy.getY() + 90 + 10, 5));
                        pIter.remove();
                        eIter.remove();
                        player.addScore(1);
                    }  
                }
            }
        }
        for(Iterator<Projectile> pIter = enemyProjectiles.iterator(); pIter.hasNext();) {
            Projectile projectile = pIter.next();
            if(projectile.getX() <= player.getX() + player.getHitX() && projectile.getX() >= player.getX() - projectile.getHitX()){
                if(projectile.getY() <= player.getY() + player.getHitY() && projectile.getY() >= player.getY() - projectile.getHitY()){
                    pIter.remove();
                    player.collide();
                }
            }
        }
    }
    
    public static void newShoot(int x, int y){
        projectiles.add(new Projectile(x, y, true));
    }
    public static void newEnemyShoot(int x, int y){
        enemyProjectiles.add(new Projectile(x, y, false));
    }
    public static void pause(){
        paused = true;        
    }
    public int getRounds(){
        return rounds;
    }
}

