package design.queue;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * TwoStackQueue Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 29, 2018</pre>
 */
public class TwoStackQueueTest {

    private TwoStackQueue queue = new TwoStackQueue();

    private List<Integer> firstList = Lists.newArrayList(1, 3, 5, 8, 4, 6);
    private List<Integer> secondList = Lists.newArrayList(9, 4, 6);

    @Before
    public void before() throws Exception {
        for (int value : firstList) {
            queue.add(value);
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(int newNum)
     */
    @Test
    public void testAdd() throws Exception {
        Assert.assertEquals(queue.size(), firstList.size());
        for (int value : secondList) {
            queue.add(value);
        }
        Assert.assertEquals(queue.size(), firstList.size() + secondList.size());
    }

    /**
     * Method: poll()
     */
    @Test(expected = RuntimeException.class)
    public void testPoll() throws Exception {
        for (int value : firstList) {
            Assert.assertEquals(queue.poll(), value);
        }
        for (int value : secondList) {
            queue.add(value);
        }
        for (int value : secondList) {
            Assert.assertEquals(queue.poll(), value);
        }
        queue.poll();
        Assert.fail();
    }

    /**
     * Method: peek()
     */
    @Test(expected = RuntimeException.class)
    public void testPeek() throws Exception {
        for (int value : firstList) {
            Assert.assertEquals(queue.peek(), value);
            queue.poll();
        }
        for (int value : secondList) {
            queue.add(value);
        }
        for (int value : secondList) {
            Assert.assertEquals(queue.peek(), value);
            queue.poll();
        }
        queue.peek();
        Assert.fail();
    }

} 
