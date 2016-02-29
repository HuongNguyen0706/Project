import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


/**
 * Created by Admin on 2/29/2016.
 */

public class Shoot extends Frame
{
    private int shootPositionX;
    public int getshootPositionX()
    {
     return this.shootPositionX;
    }
    public void setshootPositionX(int shootPositionX)
    {
        this.shootPositionX = shootPositionX;
    }
    private int shootPositionY;
    public int getshootPositionY(){
        return this.shootPositionY;
    }
    public void setshootPositionY(int shootPositionY){
        this.shootPositionY = shootPositionY;
    }
    private int bulletShoot;
    public int getbulletShoot(){
        return this.bulletShoot;
    }
    public void setbulletShoot(int bulletShoot){
        this.bulletShoot = bulletShoot;
    }

    Plane pl;
    public void Shoot()
    {
        pl = new Plane();
        try
        {
            pl.setDAN(ImageIO.read(new File("Resouces/DAN.png")));
        }
        catch (IOException e)
        {

        }
    }
    public void Bullet(int startPositionX, int startPositionY)
    {
        this.setshootPositionX(startPositionX);
        this.setshootPositionY(startPositionY);
        this.setbulletShoot(4);


    }

    }
