
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hungtran on 2/26/16.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;

    BufferedImage background;
    Plane planeMoveByKey,planeMoveByMouse;
    //PlaneEnemy planeEnemy;
    Vector<PlaneEnemy> vectorPlaneEnemy = new Vector<PlaneEnemy>();
    int direction = 0;

    //Phuong thuc khoi tao gia tri ban dau cho Plane
    private void initPlane(){

        planeMoveByKey = new Plane(200,200,3,4);
        planeMoveByMouse = new Plane(300,300,1,2);

        vectorPlaneEnemy.add(new PlaneEnemy(200, 200,2, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(100, 100,2, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(120, 150,2, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(150, 120,2, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(300, 90, 2, 1));
//        vectorPlaneEnemy.add(new PlaneEnemy(200, 150, 2, 1));
//        vectorPlaneEnemy.add(new PlaneEnemy(100,100, 3, 1));

    }

    //Ham khoi tao khong co tham so truyen vao
    public GameWindow() {

        initPlane();
        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(400, 640);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //bat su kien di chuyen chuot
        //this.addMouseListener();
        //doan code de bat su kien bam phim
        this.addMouseListener(new MouseListener() {
            //Phuong thuc thuc hien khi an chuot
            @Override
            public void mouseClicked(MouseEvent e) {

                //khi nhan chuot trai thi may bay di chuyen bang chuot ban
                if(e.getModifiers()==InputEvent.BUTTON1_MASK){
                    planeMoveByMouse.shot();

                }
            }
             //phuong thuc thuc hien khi nha chuot
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //goi phuong thuc lang nghe hoat dong cua chuot
        this.addMouseMotionListener(new MouseMotionListener() {
            //Phuong thuc nhan va di chuyen chuot
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            //Phuong thuc thuc hien khi di chuyen chuot thi may bay di chuyen
            @Override
            public void mouseMoved(MouseEvent e) {
                planeMoveByMouse.move(e.getX(),e.getY());
            }
        });
        //goi phuong thuc xu ly ban phim
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {


                if(e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(1);
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(2);
                } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    planeMoveByKey.shot();
                }

            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
    }

    //ham ve
    //ve~ moi. thu o day

    //Phuong thuc an con tro chuot

    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "invisibleCursor");
        setCursor(invisibleCursor);
    }
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    //Ham ve, ve moi.thu o day
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.drawImage(background, 0, 0, null);
        planeMoveByKey.draw(g);
        planeMoveByMouse.draw(g);
        for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
            planeEnemy.draw(g);
        }
        //g.drawLine(0,0, 100, 100);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {


        while(true) {

            planeMoveByKey.update();
            planeMoveByMouse.update();
            for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
                planeEnemy.update();
            }

            repaint();


            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}