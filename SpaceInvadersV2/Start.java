public class Start{
    
    private static GameLoop gameLoop;
    
    public Start(){}
    
    public static void main(/*String[] args*/) {
        System.out.println("start...");
        gameLoop = new GameLoop();
        gameLoop.start();
    }
    
    public static GameLoop getGame(){
        return gameLoop;
    }
}