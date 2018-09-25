package search;

import com.google.common.collect.Lists;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author weijianyu
 */
public class WideSearch extends Search {
    private static final List<Node> queue = new LinkedList<>();

    public WideSearch(int[][] arr) {
        super(arr);
    }

    public void solve() {
        int status = getStatus();
        if(status == win){

        }
        Node start = new Node(0, getStatus(), null);
//        queue.
//        for (:){
//
//        }
    }

    class Node {
        private int direction;
        private int status;
        private Node parent;

        public Node(int direction, int status, Node parent) {
            this.direction = direction;
            this.status = status;
            this.parent = parent;
        }
    }
}
