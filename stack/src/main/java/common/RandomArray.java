package common;

import java.util.Random;

/**
 * 通用类
 *
 * @author weijianyu
 */
public class RandomArray {

    public static int[] buildRandomArray() {
        Random random = new Random();
        int size = random.nextInt(100);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

}
