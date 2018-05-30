package design.stack;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * ReverseStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 29, 2018</pre>
 */
public class ReverseStackTest {

    private Deque<Integer> stack = new ArrayDeque<>();

    private List<Integer> testList = Lists.newArrayList(1, 2, 3);

    @Before
    public void before() throws Exception {
        for (int value : testList) {
            stack.push(value);
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getAndRemoveLastElement(Deque<Integer> stack)
     */
    @Test(expected = RuntimeException.class)
    public void testGetAndRemoveLastElement() throws Exception {

        int last = ReverseStack.getAndRemoveLastElement(stack);
        int first = testList.get(0);
        Assert.assertEquals(first, last);
        testList.remove(0);

        for (int i = testList.size() - 1; i >= 0; i--) {
            Assert.assertEquals(testList.get(i), stack.pop());
        }

        ReverseStack.getAndRemoveLastElement(new ArrayDeque<>());
        Assert.fail();
    }

    @Test
    public void testReverse() {
        ReverseStack.reverse(stack);
        for (int value : testList) {
            int top = stack.pop();
            Assert.assertEquals(value, top);
        }
    }
} 
