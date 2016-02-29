import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 2/28/2016.
 */
public class Plane
{
    private int PositionX;
    public int getPositionX()
    {
        return this.PositionX;
    }
    public void setPositionX(int PositionX)
    {
        this.PositionX = PositionX;
    }
    private int PositionY;
    public int getPositionY()
    {
        return this.PositionY;
    }
    public void setPositionY(int PositionY)
    {
        this.PositionY = PositionY;
    }

    private int positionX1;
    public int getpositionX1()
    {
        return this.positionX1;
    }
    public void setpositionX1(int positionX1)
    {
        this.positionX1 = positionX1;
    }
    private int positionY1;
    public int getpositionY1()
    {
        return this.positionY1;
    }
    public void setpositionY1(int positionY1)
    {
        this.positionY1 = positionY1;
    }
    private int speed;
    public int getspeed()
    {
        return this.speed;
    }
    public void setspeed(int speed)
    {
        this.speed = speed;
    }
    private int health;
    public int gethealth()
    {
        return this.health;
    }
    public void sethealth(int health
    ){
        this.health = health;
    }
    private int damage;
    public int getdamage()
    {
        return this.damage;
    }
    public void setdamage(int damage)
    {
        this.damage = damage;
    }
    private int planType;
    public int getplanType()
    {
        return this.planType;
    }
    public void setplanType(int planType)
    {
        this.planType = planType;
    }
    private BufferedImage sprite;
    public BufferedImage getsprite()
    {
        return this.sprite;
    }
    public void setsprite(BufferedImage sprite)
    {
        this.sprite = sprite;
    }
    private BufferedImage background;
    public BufferedImage getbackground()
    {
        return this.background;
    }
    public void setbackground(BufferedImage background)
    {
        this.background = background;
    }
    private BufferedImage PLANE2;
    public BufferedImage getPLANE2()
    {
        return this.PLANE2;
    }
    public void setPLANE2(BufferedImage PLANE2)
    {
        this.PLANE2 = PLANE2;
    }
    private BufferedImage DAN;
    public BufferedImage getDAN(){
        return this.DAN;
    }
    public void setDAN(BufferedImage DAN){
        this.DAN = DAN;
    }
    private int direction;
    public int getdirection()
    {
        return this.direction;
    }
    public void setdirection(int direction)
    {
        this.direction = direction;
    }
    private void move ()
    {
            if (direction == 1)
            {
                this.PositionY -= this.speed;
            } else if (direction == 2)
            {
                this.PositionY += this.speed;
            } else if (direction == 3)
            {
                this.PositionX -= this.speed;
            } else if (direction == 4)
            {
                this.PositionX += this.speed;

            }

    }
    public void update()
    {
        move();
    }
    public void draw(Graphics g)
    {
        g.drawImage(background,0,0,null);
        g.drawImage(PLANE2,positionX1,positionY1,null);
        g.drawImage(sprite,PositionX,PositionY,null);
    }

}

