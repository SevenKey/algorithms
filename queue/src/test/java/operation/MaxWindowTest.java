package operation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * MaxWindow Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 8, 2018</pre>
 */
public class MaxWindowTest {

    private int[] arr;
    private int[] result;
    private int w;

    @Before
    public void before() throws Exception {
        this.arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        this.w = 3;
        this.result = new int[]{5, 5, 5, 4, 6, 7};
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getMaxWindow(int[] arr, int w)
     */
    @Test
    public void testGetMaxWindow() throws Exception {
        int[] res = new MaxWindow().getMaxWindow(arr, w);
        Assert.assertArrayEquals(res, result);
    }

} 
