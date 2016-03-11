import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 3/10/2016.
 */
public class HealthBars extends GameObject{
    private int dam;
    Color color;
    private int width;
    private int height;
    private int typeBar;
    public HealthBars(){
        this.positionX = this.positionX;
        this.positionY = this.positionY;
        this.width = this.width;
        this.height = this.height;
    }
    public HealthBars(int x, int y, int width, int height,int typeBar, Color color){
        this.color = color;
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;
        this.typeBar = typeBar;
        try{
            switch (typeBar){
                case 0:
                    this.sprite = ImageIO.read(new File("Resources/healthBar.jpg"));
                    break;
                case 1:
                    this.sprite = ImageIO.read(new File("Resources/healthBar1.jpg"));
                    break;
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, this.width, this.height, null);
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getdam() {
        return dam;
    }

    public void setdam(int dam) {
        this.dam = dam;
    }
}
