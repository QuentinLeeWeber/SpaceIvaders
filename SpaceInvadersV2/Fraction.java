import java.awt.Graphics;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage; 

public class Fraction{
    
    private int x;
    private float y;
    private int rotation = 0;
    private int type;
    private double speedY;
    private double speedX;

    
    private double rotationRequired = Math.toRadians(rotation);
    private double locationX = Consts.fraction1Image.getWidth() / 2;
    private double locationY = Consts.fraction1Image.getHeight() / 2;
    private AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
    private AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

    public Fraction(int _x, int _y, int _type){
        type = _type;
        x = _x;
        y = _y;
        speedX = Math.random() * 20 - 10;
        speedY = Math.random() * 20 - 10;
    }
    
    
    public void draw(Graphics g){
        rotationRequired = Math.toRadians(rotation);
        tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        rotation += 3;
        x += speedX;
        speedY += Consts.fractionAcceleration;
        y = y += speedY;
        switch (type) {
            case 1:
                g.drawImage(op.filter(Consts.fraction1Image, null), x - (int) (locationX), (int) (y) - (int) (locationY), null);
                break;
            case 2:
                g.drawImage(op.filter(Consts.fraction2Image, null), x - (int) (locationX), (int) (y) - (int) (locationY), null);
                break;
            case 3:
                g.drawImage(op.filter(Consts.fraction3Image, null), x - (int) (locationX), (int) (y) - (int) (locationY), null);
                break;
            case 4:
                g.drawImage(op.filter(Consts.fraction4Image, null), x - (int) (locationX), (int) (y) - (int) (locationY), null);
                break;
            case 5:
                g.drawImage(op.filter(Consts.fraction5Image, null), x - (int) (locationX), (int) (y) - (int) (locationY), null);
                break;
        }
    }
    
    public int getY(){
        return (int) (y);
    }
}
