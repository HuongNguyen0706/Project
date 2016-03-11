import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 3/11/2016.
 */
public class Gift extends GameObject {
    private Vector<PlaneEnemy> vecE = new Vector<>();
    private int speed;
    public Gift(){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public Gift(int x, int y, int speed){
        this.positionX = x;
        this.positionY = y;
        this.speed = speed;
        try{
            this.sprite = ImageIO.read(new File("Resources/gift.jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void move(){
       this.positionY +=this.speed;
//        this.positionX += this.speed;
    }

    public boolean checkCollisionGift(){
        Rectangle rectGift = new Rectangle(positionX,positionY,sprite.getWidth()
                ,sprite.getHeight());
        Rectangle rectPlaneMouse =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                        , PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectGift.intersects(rectPlaneMouse);
//
    }
    public void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }
    public void update(){
        move();
        if(checkCollisionGift()){
            for (PlaneEnemy planeEnemy : vecE){
                PlaneEnemyManager.getInstance().getVectorPlaneEnemy().clear();
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
