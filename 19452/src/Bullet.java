import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class Bullet extends GameObject{

    private int speed;
    private int speed1;
    private int positionX1;
    private int positionY1;

    //Constructor khong tham so truyen vao
    private Bullet() {
        positionX = 0;
        positionY = 0;
        positionX1 = 0;
        positionX1 = 0;

    }
    //Constructor co tham so truyen vao
    public Bullet(int positionX, int positionY, int speed) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
//        try {
//            this.sprite = ImageIO.read(new File("Resources/DAN1.png"));
//            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
//    public Bullet(int positionX1, int positionY1){
//        this.positionX1 = positionY1;
//        this.positionY1 = positionY1;
//
//    }

    //Phuong thuc di chuyen dan
    public void move(){

        this.positionY -= this.speed;
//        this.positionX +=this.speed;

    }
    public void moveE(){
//        this.positionX1 -=this.speed1;
        this.positionY1 -=this.speed1;
    }


    //Phuong thuc cap nhat trang thai di chuyen vien dan
    public void update(){
        this.move();
        this.moveE();

    }

    //Phuong thuc ve dan
    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
        g.drawImage(sprite,positionX1,positionY1,null);
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
    public int getPositionX1() {
        return positionX1;
    }

    public void setPositionX1(int positionX1) {
        this.positionX1 = positionX1;
    }

    public int getPositionY1() {
        return positionY1;
    }

    public void setPositionY1(int positionY1) {
        this.positionY1 = positionY1;
    }

    public int getSpeed1(){return speed1;}
    public void setSpeed1(int speed1){this.speed1 = speed1;}

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
