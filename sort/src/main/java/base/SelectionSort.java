package base;

import utils.ArrayUtil;

/**
 * 选择排序
 *
 * @author weijianyu
 */
public class SelectionSort {

    /**
     * 原型
     * <p>
     * 从带排序中选出一个最小的 放到0上
     * 从带排序中选出一个最小的 放到1上
     * ...
     * 从带排序中选出一个最小的 放到N-1上
     *
     * @param arr
     */
    public static void selectionSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                ArrayUtil.swap(arr, i, min);
            }
        }
    }
}
