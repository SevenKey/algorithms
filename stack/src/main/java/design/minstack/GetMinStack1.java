package design.minstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个有getMin功能的栈
 * 实现一个特殊的栈,基本功能外返回栈中最小元素
 * <p>
 * 要求
 * pop push getMin时间复杂度 O(1)
 * 可以使用现成的栈结构
 * <p>
 * 这种实现方式插入时稍省空间
 * 弹出时稍费时间
 *
 * @author weijianyu
 */
public class GetMinStack1 {

    /**
     * 实现栈功能
     */
    private Deque<Integer> stackData;
    /**
     * 辅助实现获取最小值
     */
    private Deque<Integer> stackMin;

    public GetMinStack1() {
        this.stackData = new ArrayDeque<>();
        this.stackMin = new ArrayDeque<>();
    }

    public void push(int newNum) {
        stackData.push(newNum);

        if (stackMin.isEmpty() || newNum <= this.getMin()) {
            stackMin.push(newNum);
        }
    }

    public int pop() {

        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }

        int value = stackData.pop();

        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }

        return this.stackMin.peek();
    }

    public int size() {
        return stackData.size();
    }

}
