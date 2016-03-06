import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 3/5/2016.
 */
public class PlaneEnemy1 extends PlaneEnemy {

    private Vector<Bullet> vecBul = new Vector<>();
    //goi phuong thuc khoi tao khong tham so trong PlaneEnemy
    public PlaneEnemy1(){
        super();
    }
    //goi phuong thuc khoi tao co tham so trong PlaneEnemy
    public PlaneEnemy1(int positionX, int positionY, int speed, int planeType) {
        super(positionX, positionY, speed, planeType);
    }
    //phuong thuc ban dan cua may bay bay theo hinh elip
    public void shot(){
        Bullet bullet = new Bullet(positionX+15 ,positionY+59,-5);
        try
        {
            bullet.sprite = ImageIO.read(new File("Resources/DAN1.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    //phuong thuc di chuyen cua may bay dich
    public void moveElip(){
        int x = this.positionX;
        int y = this.positionY;
        this.positionX -= this.speed;
        y=(int)Math.sqrt((3600-(200-x)*(200-x)/16)*5);
        this.positionY = y;

        if(this.positionX <=0){
            this.positionX  =- this.speed;
        }
        if(this.positionX >=400){
            this.positionX =-this.speed;
        }

    }
    //phuong thuc cap nhat trang thai cua may bay dich
    public void update(){
       count++;
        if(count >=120){
            this.shot();
            count = 0;
        }
        for (Bullet bullet : vecBul){
            bullet.update();
        }
        this.moveElip();

    }

    //phuong thuc ve lai may bay dich
    public void draw(Graphics g){
        super.draw(g);
        g.drawImage(sprite,positionX,positionY,null);
        for (Bullet bullet : vecBul){
            bullet.draw(g);
        }
    }


}
