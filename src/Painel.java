import javax.swing.*;
import java.awt.*;

public class Painel extends JPanel implements Runnable {

final int tileSize = 48;
final int maxScreenRow = 12;
final int maxScreenCol = 16;
public final int screenWidth = tileSize * maxScreenCol;
public final int screenHeigth = tileSize *  maxScreenRow;
Thread gameThread;
int FPS = 60;
boolean neighborVisited = false;
TileMannager tileM = new TileMannager(this);

public Painel(){
    this.setPreferredSize(new Dimension(screenWidth,screenHeigth));
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true);
    this.setFocusable(true);
}

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }




    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) /drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if(delta >= 1){
                update();
                delta--;
                drawCount++;
            }

        }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        g2.dispose();

    }
}
