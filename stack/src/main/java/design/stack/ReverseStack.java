package design.stack;

import java.util.Deque;

/**
 * 递归实现栈逆序
 *
 * @author weijianyu
 */
public class ReverseStack {

    /**
     * 获取栈底元素 并pop
     *
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(value);
        return last;
    }

    /**
     * 递归 逆序栈
     *
     * @param stack
     */
    public static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    private ReverseStack() {
    }
}
