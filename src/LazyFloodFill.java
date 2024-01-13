import java.util.Random;
import java.util.Stack;

import static java.lang.Math.random;

public class LazyFloodFill {
    Painel pn;


    public void lazyFlood(int[][] image,int seedX,int seedY){

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{seedX, seedY});

        int chance =  100;
        int preenchido = 1;
        double decay = 0.99999;
        Random random = new Random();
        int[][] grid = new int[image.length][image[0].length];


        while(!stack.isEmpty()){
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];


            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length ) {

                image[x][y] = preenchido;
                if(chance >= random.nextInt(10) ) {
                    stack.push(new int[]{x + 1, y});
                    stack.push(new int[]{x, y + 1});
                    stack.push(new int[]{x - 1, y});
                    stack.push(new int[]{x, y - 1});
                    chance *= decay;
                }
            }
        }



    }
}
