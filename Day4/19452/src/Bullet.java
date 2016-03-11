import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class Bullet extends GameObject {

    HealthBars healthBarMouse = new HealthBars();
    private int speed;

    Vector<PlaneEnemy> vectorPE;
    private Bullet() {
        positionX = 0;
        positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        this.positionY -= this.speed;
    }

    public void update(){
        this.move();
        if (checkCollisionMouse()){
            System.out.println("Game Over");
//            healthBarMouse = new HealthBars();

        }
    }
//    public boolean checkCollisionKeyBul(){
//        Rectangle rectBullet = new Rectangle(positionX,positionY,sprite.getWidth()
//                                            ,sprite.getHeight());
//        Rectangle rectPlaneKey =
//                new Rectangle(PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
//                                , PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
//                                , PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
//                                , PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
//        return rectBullet.intersects(rectPlaneKey);
////
//    }
    public boolean checkCollisionMouse(){
        Rectangle rectBullet = new Rectangle(positionX,positionY,sprite.getWidth(),
                                            sprite.getHeight());
        Rectangle rectPlaneMouse =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                            , PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                            , PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                            , PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectBullet.intersects(rectPlaneMouse);
    }
    //Lay toa do cua 2 may bay
    //PlaneManager.getInstance()....


    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
