package design.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现队列 支持队列的基本操作
 * add poll peek
 * <p>
 * 一个栈用于push
 * 一个栈用来pop
 * 注意push栈数据流入pop栈的世纪和条件
 *
 * @author weijianyu
 */
public class TwoStackQueue {
    /**
     * 负责入队
     */
    private Deque<Integer> stackPush;
    /**
     * 负责出队
     */
    private Deque<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new ArrayDeque<>();
        this.stackPop = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    public void add(int newNum) {
        stackPush.push(newNum);
    }

    public int poll() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        if (stackPop.isEmpty()) {
            while (stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        if (stackPop.isEmpty()) {
            while (stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public int size() {
        return stackPush.size() + stackPop.size();
    }

}
