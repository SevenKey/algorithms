package design.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用一个栈实现另一个栈的排序 顶到底 大到小
 * 排序栈stack 辅助栈help
 * stack pop cur 如果cur大于help  help逐一pop push进stack 然后cur push help
 * stack pop cur 如果cur小于help  help push cur
 *
 * @author weijianyu
 */
public class SortStack {
    private Deque<Integer> stack;
    private Deque<Integer> help;

    public SortStack() {
        this.stack = new ArrayDeque<>();
        this.help = new ArrayDeque<>();
    }

    public Deque<Integer> sort() {
        if (stack.isEmpty() || stack.size() == 1) {
            return stack;
        }

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (help.isEmpty() || cur <= help.peek()) {
                help.push(cur);
            } else {
                while (!help.isEmpty()) {
                    stack.push(help.pop());
                }
                help.push(cur);
            }
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return stack;
    }

    public Deque<Integer> getStack() {
        return stack;
    }

    public void setStack(Deque<Integer> stack) {
        this.stack = stack;
    }

    public Deque<Integer> getHelp() {
        return help;
    }

    public void setHelp(Deque<Integer> help) {
        this.help = help;
    }

}
