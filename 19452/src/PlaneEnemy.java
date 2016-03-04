import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class PlaneEnemy extends PlaneAbstract{

    private int count = 0;
    public PlaneEnemy(int positionX, int positionY, int speed, int planeType) {
        super(positionX, positionY, speed, planeType);
    }

//    public int getSpeed() {
//        return speed;
//    }
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }

    private Vector<Bullet> vecBul = new Vector<Bullet>();
    private  Vector<Bullet> vecBul1 = new Vector<Bullet>();


    //Phuong thuc ban cua may bay dich
    public void shot(){
        Bullet bullet = new Bullet(positionX+15 ,positionY+59,-5);
        Bullet bullet1 = new Bullet(positionX-15 ,positionY+59, -5);

        try {
            bullet.sprite = ImageIO.read(new File("Resources/DAN1.png"));
            bullet1.sprite = ImageIO.read(new File("Resources/DAN1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        vecBul.add(bullet);
        vecBul1.add(bullet1);
    }

    //Phuong thuc di chuyen may bay dich
    public void moveElip(){
        int x=this.positionX;
        int y=this.positionY;

        this.positionX -= this.speed;
//        y=(int)Math.sqrt((3600-(200-x)*(200-x)/16)*5);
        y = (int)Math.sqrt((100*100)*(1-(x*x)/(200*200)));

        this.positionY = y;
//        this.positionX = x;



        //this.positionX += this.speed;
        if(this.positionX <= 0)
        {
            this.speed =- this.speed;
        }
        if(this.positionX >= 400) {
            this.speed =- this.speed;
        }
    }

    //Phuong thuc cap nhat trang thai
    public void update(){//60 lan 1 giay
        count++;
        if(count >= 120){
            this.shot();
            count=0;
        }
        for(Bullet bul : vecBul){
            bul.update();
        }
        for(Bullet bul1 : vecBul1){
            bul1.update();
        }
        moveElip();
    }

    //Phuong thuc ve may bay dich
    public void draw(Graphics g){
        for (Bullet bul : vecBul){
            bul.draw(g);
        }
        for (Bullet bul1 : vecBul1){
            bul1.draw(g);
        }
        g.drawImage(sprite,positionX,positionY,null);
        g.drawImage(sprite,positionX,positionY,null);
    }
}
