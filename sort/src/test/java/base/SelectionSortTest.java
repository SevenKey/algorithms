package base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ArrayUtil;

import java.util.Arrays;

/**
 * SelectionSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 31, 2018</pre>
 */
public class SelectionSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 50万次随机测试 选择排序法
     * Method: selectionSort1(int[] arr)
     */
    @Test(expected = RuntimeException.class)
    public void testSelectionSort1() throws Exception {
        for (int i = 0; i < 500000; i++) {
            int[] array = ArrayUtil.buildRandomArray();
            int[] arrayCopy = array.clone();

            Arrays.sort(array);
            SelectionSort.selectionSort1(arrayCopy);

            Assert.assertArrayEquals(array, arrayCopy);
        }

    }

} 
