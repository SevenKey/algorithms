package sort.bubble;

/**
 * 原型
 * 冒泡排序算法
 * <p>
 * 从第一个开始 比较他与他的后一位 如果大就交换 小不做处理
 * 第一次比较N
 * 第二次比较N-1
 * ...
 * 第N-1次比较1
 * <p>
 * 时间复杂度 O(N2)
 *
 * @author weijianyu
 */
public class BubbleSort {

    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
