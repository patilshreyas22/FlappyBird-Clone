import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener{
    int boardWidth = 360;
    int boardHeight = 640;

    //Images

    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //Bird 
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird{
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    //game logic

    Bird bird;

    Timer gameLoop;


    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth , boardHeight));
        //setBackground(Color.BLUE);

        //load images

        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();
        
        //bird
        bird = new Bird(birdImg);

        //game timer
        gameLoop = new Timer(1000/60 , this); //1000/60 = 16.6
        //gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){

        System.out.println("draw");
        //background

         g.drawImage(backgroundImg , 0 , 0 , boardWidth , boardHeight , null);

         //bird
         g.drawImage(bird.img, bird.x, bird.y, bird.width , bird.height , null );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    
}