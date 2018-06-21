package utils;

import java.util.Random;

/**
 * 通用类
 *
 * @author weijianyu
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * 随机获取随机长度随机元素的一个数组
     *
     * @return
     */
    public static int[] buildRandomArray() {
        Random random = new Random();
        int size = random.nextInt(100);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    /**
     * 数组元素交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        if (j >= arr.length) {
            throw new RuntimeException("arr size to small!");
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
