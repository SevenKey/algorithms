package operation;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * 窗口长度为w
 * 数组arr
 * 每次窗口移动一格 每次会得出窗口中的最大值
 * 一共会有 arr.length - w + 1 个最大值
 * <p>
 * 思路
 * 遍历数组
 * 双端队列 放入逻辑 空 或者 数组值>last
 * 双对队列 弹出逻辑 数组值<last 过期
 * <p>
 * 用一个数组 记录双端队列头
 *
 * @author weijianyu
 */
public class MaxWindow {

    int[] getMaxWindow(int[] arr, int w) {
        if (null == arr || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qMax = Lists.newLinkedList();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (qMax.isEmpty() && arr[qMax.peek()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() < i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }

        return res;
    }
}
