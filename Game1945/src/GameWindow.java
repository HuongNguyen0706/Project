import com.sun.java.swing.plaf.motif.MotifInternalFrameUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





/**
 * Created by Admin on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseMotionListener, Runnable
{
    //start/////////////////////////////////////////////////////////
    Graphics seconds;
    Image image;

    ///////////////////////////////////////////////////////////////
//    BufferedImage bg;
//    BufferedImage PLANE2;
//    int positionX1;
//    int positionY1;
//    int direction = 0;
    Plane plane; //tham chieu (dia chi)



    public GameWindow()
    {
        plane = new Plane(); //tao doi tuong moi
        plane.setPositionX(100);
        plane.setPositionY(200);
        plane.setpositionX1(100);
        plane.setpositionY1(100);
        plane.setspeed(3);
        this.setTitle("Game1945");
        this.setSize(400,640);
        this.setVisible(true);//de chay cua so window
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try
        {
            plane.setPLANE2(ImageIO.read(new File("Resouces/PLANE2.png")));
            plane.setbackground(ImageIO.read(new File("Resouces/Background.png")));
            plane.setsprite(ImageIO.read(new File("Resouces/PLANE1.png")));


        }
        catch(IOException e)
        {

        }

        this.addKeyListener(this); //an phim de cac su kien hoat dong
        this.addMouseMotionListener(this);

        repaint();//Ve lai
        blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(plane.getPLANE2(), new Point(0, 0), "blank cursor");
    }
    //khong dong vao nua//////////////////////////////////////////////////////////////////////
    @Override
    public void update(Graphics g)
    {
        if(image == null) {
            image = createImage(this.getWidth(),this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g)
    {
//        g.drawImage(bg,0,0,null);
//        g.drawImage(PLANE2,positionX1,positionY1,null);
        plane.draw(g);
    }
    Cursor blankCursor;

    public void mouseMoved(MouseEvent me)
    {
        plane.setpositionX1( me.getX());
        plane.setpositionY1(me.getY());
        setCursor(blankCursor);
    }

    public void mouseDragged(MouseEvent me){}

    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("Ban vua bam phim " +e.getKeyChar());//lay phim minh vua bam ra:e.getKeyChar()

    }

    @Override
    public void keyPressed(KeyEvent e) { //nhan phim


        if(e.getKeyChar()=='w')
        {
            plane.setdirection(1);
        }
        else if(e.getKeyChar()=='s')
        {
            plane.setdirection(2);
        }
        else if(e.getKeyChar()=='d')
        {
            plane.setdirection(3);
        }
        else if(e.getKeyChar()=='a')
        {
            plane.setdirection(4);
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {//tha phim ra
        plane.setdirection(0);
    }


    @Override
    public void run()
    {


        while(true){

            plane.update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
