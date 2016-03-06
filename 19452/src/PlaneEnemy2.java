import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 3/5/2016.
 */
public class PlaneEnemy2 extends PlaneEnemy{

//    private Vector<Bullet> vecBul = new Vector<>();

    public PlaneEnemy2(){
        super();
    }
    public PlaneEnemy2(int positionX, int positionY, int speed, int planeType) {
        super(positionX, positionY, speed, planeType);
    }
    public void shot(){
        Bullet bullet1  = new Bullet(positionX + 15, positionY +59, -5);
        Bullet bullet = new Bullet(positionX -15,positionY +59, -5);
        try{
            bullet.sprite = ImageIO.read(new File("Resources/DAN1.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void move(){
        this.positionX += this.speed;
        if(this.positionX <=0){
            this.speed =-this.speed;
        }
        if(this.positionX >=400){
            this.speed =-this.speed;
        }
    }
    public void update(){
        count++;
        if(count>=120){
            this.shot();
            count=0;
        }
        for (Bullet bullet : vecBul){
            bullet.update();
        }
        for (Bullet bullet1 : vecBul){
            bullet1.update();
        }
        this.move();
    }



    public void draw(Graphics g){
//        g.drawImage(sprite,positionX,positionY,null);
        super.draw(g);
    }
}
