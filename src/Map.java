import java.util.Random;

public class Map {

    int[][] image ;

    int seedX;
    int seedY;
    int targetColor;
    int replacementColor;



    public Map(){
        initializeSeed();
        applyLazyFlood();
    }

    public void initializeSeed() {
        Random random = new Random();
        this.seedX = random.nextInt(12);
        this.seedY = random.nextInt(16);
        image = new int[12][16];


    }

    public void applyLazyFlood() {
        LazyFloodFill l = new LazyFloodFill();
        l.lazyFlood(image, seedX, seedY);

    }
}


