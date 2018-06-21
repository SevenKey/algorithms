package design.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * SortStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 21, 2018</pre>
 */
public class SortStackTest {
    private int[] array;
    private SortStack sortStack;

    @Before
    public void before() throws Exception {
        array = ArrayUtils.buildRandomArray();
        sortStack = new SortStack();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : array) {
            stack.push(i);
        }
        sortStack.setStack(stack);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sort()
     */
    @Test
    public void testSort() throws Exception {
        Deque<Integer> sort = sortStack.sort();
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            int j = sort.pop();
            Assert.assertEquals(array[i], j);
        }
    }
} 
