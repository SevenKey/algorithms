package sort.bubble;

import com.google.common.collect.Lists;
import common.RandomArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.List;

/**
 * BubbleSort_1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 30, 2018</pre>
 */
public class BubbleSortTest {

    private int[] arr = {4, 4, 6, 2, 7, 1, 8, 9};
    private int[] swapArr = {4, 6, 4, 2, 7, 1, 8, 9};

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 对数器测试法
     * Method: bubbleSort(int[] arr)
     */
    @Test
    public void testBubbleSort1() throws Exception {

        for (int i = 0; i < 500000; i++) {
            int[] array = RandomArray.buildRandomArray();
            int[] bubbleArray = array.clone();

            Arrays.sort(array);
            BubbleSort.bubbleSort1(bubbleArray);
            Assert.assertArrayEquals(array, bubbleArray);
        }
    }

    /**
     * Method: swap(int[] arr, int i, int j)
     */
    @Test
    public void testSwap() throws Exception {
        BubbleSort.swap(arr, 1, 2);
        Assert.assertArrayEquals(swapArr, arr);
    }

} 
