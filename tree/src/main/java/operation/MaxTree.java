package operation;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构建一个数组的MaxTree
 * 数组中无重复元素
 * 二叉树 每一颗子树上最大的节点是头结点
 * <p>
 * 构建方式
 * 每一个数的付节点是它左边第一个比他大的数和右边第一个比他大的数中较小的一个
 * 如果昨天没有比他大的，右边也没有比他大的，这个数是数组中最大的数 为根节点
 * <p>
 * 如何找出每一个数左右第一个比它大的数 利用栈
 *
 * @author weijianyu
 */
public class MaxTree {

    /**
     * 获取最大二叉树
     *
     * @param arr 数组
     * @return 二叉树头结点
     */
    public Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i != arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();

        // 寻找每个树的左最大
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().getValue() < curNode.getValue()) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }

        // 寻找每个树的右最大
        for (int i = nArr.length - 1; i != -1; i--) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().getValue() < curNode.getValue()) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        // 生成一个树
        Node head = null;
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.getLeft() == null) {
                    right.setLeft(curNode);
                } else {
                    right.setRight(curNode);
                }
            } else if (right == null) {
                if (left.getLeft() == null) {
                    left.setLeft(curNode);
                } else {
                    left.setRight(curNode);
                }
            } else {
                Node parent = left.getValue() < right.getValue() ? left : right;
                if (parent.getLeft() == null) {
                    parent.setLeft(curNode);
                } else {
                    parent.setRight(curNode);
                }
            }
        }
        return head;
    }

    private void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }
}
