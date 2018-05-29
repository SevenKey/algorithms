package design.minstack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 实现一个特殊的栈,基本功能外返回栈中最小元素
 * <p>
 * 要求
 * pop push getMin时间复杂度 O(1)
 * 可以使用现成的栈结构
 *
 * @author weijianyu
 */
public class GetMinStack1 {

    /**
     * 实现栈功能
     */
    private Stack<Integer> stackData;
    /**
     * 辅助实现获取最小值
     */
    private Stack<Integer> stackMin;

    public GetMinStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
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
