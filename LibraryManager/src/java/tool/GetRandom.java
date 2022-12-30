package tool;

import java.util.Random;

public class GetRandom {
    public static int getRandom(int min, int max){
        Random rd = new Random();
        return min + rd.nextInt(max - min + 1);
    }
}
