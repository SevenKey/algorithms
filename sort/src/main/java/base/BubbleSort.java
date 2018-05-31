package base;

import utils.ArrayUtil;

/**
 * 冒泡排序
 *
 * @author weijianyu
 */
public class BubbleSort {

    /**
     * 原型
     * <p>
     * 从第一个开始 比较他与他的后一位 如果大就交换 小不做处理
     * 第一次比较N
     * 第二次比较N-1
     * ...
     * 第N-1次比较1
     * <p>
     * 时间复杂度 O(N2)
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    ArrayUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

}
