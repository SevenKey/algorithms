package utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ArrayUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 31, 2018</pre>
 */
public class ArrayUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: buildRandomArray()
     */
    @Test
    public void testBuildRandomArray() throws Exception {
    }

    /**
     * Method: swap(int[] arr, int i, int j)
     */
    @Test(expected = RuntimeException.class)
    public void testSwap() throws Exception {
        int[] arr = ArrayUtil.buildRandomArray();
        int[] copyArr = arr.clone();
        if (arr.length > 1) {
            ArrayUtil.swap(arr, 0, 1);
            int temp = copyArr[0];
            copyArr[0] = copyArr[1];
            copyArr[1] = temp;
            Assert.assertArrayEquals(arr, copyArr);
        }

        int[] array = new int[1];
        array[0] = 0;
        ArrayUtil.swap(array, 0, 1);
        Assert.fail();
    }

} 
