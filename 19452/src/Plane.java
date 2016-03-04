import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hungtran on 3/1/16.
 */
public class Plane extends  PlaneAbstract {

//    private Vector<Bullet> vecBul = new Vector<Bullet>();

    public Plane(int positionX, int positionY,int speed, int planeType)
    {
        super(positionX, positionY, speed, planeType);
    }


    public void shot(){
        Bullet bul = new Bullet(this.positionX + 30, this.positionY, 10);
        try {
            bul.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        vecBul.add(bul);
    }

    public void  move(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }
    public void move(){
        switch (direction){
            case 0:
                //dung im
                break;
            case 1:
                this.positionY += this.speed;
                break;
            case 2:
                this.positionY -= this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }
    public void update(){

        for (Bullet bul : vecBul){
            bul.update();
        }
        this.move();
    }
    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
        for (Bullet bul : vecBul){
            bul.draw(g);
        }
    }

}
