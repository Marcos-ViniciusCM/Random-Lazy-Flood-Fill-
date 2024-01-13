import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class TileMannager {

    Map map;
    Tiles[] tiles;
    Painel pn;
    int mapTileNum[][];


    public TileMannager(Painel pn) {
        this.pn = pn;
        tiles = new Tiles[3];
        mapTileNum = new int[pn.maxScreenCol][pn.maxScreenRow];
        map = new Map();
        getTileImage();
        loadMap(map.image);


    }

    private void getTileImage() {
        try {
            tiles[0] = new Tiles();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tileImg/grass00.png"));

            tiles[1] = new Tiles();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tileImg/earth.png"));


            tiles[2] = new Tiles();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tileImg/sand.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(int[][] matriz) {
        try {
            int col = 0;
            int row = 0;


            StringBuilder sb = new StringBuilder();
            for (int[] rowArray : matriz) {
                for (int value : rowArray) {
                    sb.append(value).append(" ");
                }
                sb.append("\n");
            }

            BufferedReader br = new BufferedReader(new StringReader(sb.toString()));

            while (row < pn.maxScreenRow) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                String numbers[] = line.split(" ");
                col = 0;
                while (col < pn.maxScreenCol) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < pn.maxScreenCol && row < pn.maxScreenRow) {
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tiles[tileNum].image, x, y, pn.tileSize, pn.tileSize, null);
            col++;
            x += pn.tileSize;

            if (col == pn.maxScreenCol) {
                col = 0;
                row++;
                x = 0;
                y += pn.tileSize;
            }
        }

    }
}

