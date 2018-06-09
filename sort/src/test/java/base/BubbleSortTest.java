package base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.Arrays;

/**
 * BubbleSort_1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 30, 2018</pre>
 */
public class BubbleSortTest {

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
            int[] array = ArrayUtils.buildRandomArray();
            int[] bubbleArray = array.clone();

            Arrays.sort(array);
            BubbleSort.bubbleSort1(bubbleArray);
            Assert.assertArrayEquals(array, bubbleArray);
        }
    }

} 
