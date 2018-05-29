package design.minstack;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GetMinStackTest {

    private GetMinStack2 stack = new GetMinStack2();

    private List<Integer> testList = Lists.newArrayList(3, 4, 5, 1, 2, 1);

    @Before
    public void ready() {
        for (Integer value : testList) {
            stack.push(value);
        }
    }

    @Test
    public void testPush() {
        Assert.assertEquals(testList.size(), stack.size());
    }

    @Test
    public void testPop() {
        int index = testList.size() - 1;
        while (stack.size() != 0) {
            int value = stack.pop();
            int source = testList.get(index);
            Assert.assertEquals(value, source);
            index--;
        }
    }

    @Test(expected = RuntimeException.class)
    public void testGetMin() throws RuntimeException {
        Assert.assertEquals(1, stack.getMin());

        stack.pop();
        Assert.assertEquals(1, stack.getMin());

        stack.pop();
        Assert.assertEquals(1, stack.getMin());

        stack.pop();
        Assert.assertEquals(3, stack.getMin());

        stack.pop();
        Assert.assertEquals(3, stack.getMin());

        stack.pop();
        Assert.assertEquals(3, stack.getMin());

        stack.pop();
        stack.getMin();
        Assert.fail();
    }

}
