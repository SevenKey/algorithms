package search;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @author weijianyu
 */
public class DeepSearch extends Search {

    private static final Set<Integer> statusHistory = Sets.newHashSet();
    private static final List<Integer> moveStep = Lists.newArrayList();

    public DeepSearch(int[][] arr) {
        super(arr);
    }

    private boolean moveForward(int direction) {
        if (moveStep.size() > 100) {
            return false;
        }

        if (canMove(direction)) {
            move(direction);
            moveStep.add(direction);

            int status = getStatus();
            if (status == win) {
                return true;
            }

            if (statusHistory.contains(status)) {
                recover(direction);
                moveStep.remove(moveStep.size() - 1);
                return false;
            }
            statusHistory.add(status);
            boolean result = moveForward(RIGHT) || moveForward(DOWN) || moveForward(LEFT) || moveForward(UP);
            if (result) {
                return true;
            } else {
                recover(direction);
                moveStep.remove(moveStep.size() - 1);
                return false;
            }
        }
        return false;
    }

    public boolean solve() {
        printArr();

        int status = getStatus();
        if (status == win) {
            System.out.println("yes");
            printArr();
        }
        statusHistory.add(status);

        return moveForward(RIGHT) || moveForward(DOWN) || moveForward(LEFT) || moveForward(UP);
    }

    public void printRoute() {
        for (int direction : moveStep) {
            switch (direction) {
                case LEFT:
                    System.out.print("← ");
                    break;
                case RIGHT:
                    System.out.print("→ ");
                    break;
                case UP:
                    System.out.print("↑ ");
                    break;
                case DOWN:
                    System.out.print("↓ ");
                    break;
                default:

            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 5, 8}};
        DeepSearch test = new DeepSearch(arr);
        if (test.solve()) {
            test.printRoute();
        }
    }
}
