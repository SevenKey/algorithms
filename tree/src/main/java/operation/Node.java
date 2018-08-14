package operation;

import com.google.common.base.MoreObjects;

/**
 * 二叉树节点
 *
 * @author weijianyu
 */
public class Node {
    private int value;

    private Node left;

    private Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .add("left", left)
                .add("right", right)
                .toString();
    }
}
