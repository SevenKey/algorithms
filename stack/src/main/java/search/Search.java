package search;

/**
 * @author weijianyu
 */
public class Search {
    /**
     * 坐标
     */
    private int x;
    private int y;

    /**
     * 棋盘
     */
    private int[][] arr;

    /**
     * 方向
     */
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;

    /**
     * 辅助移动位置
     */
    private static final int[][] moveHelp = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    static final int win = 123456780;

    public Search(int[][] arr) {
        this.arr = arr;
        findZero();
    }

    /**
     * 寻找0坐标
     */
    void findZero() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
    }

    /**
     * 是否可以意向移动
     *
     * @param direction 方向
     * @return 可以 不可以
     */
    boolean canMove(int direction) {
        switch (direction) {
            case LEFT:
                return y > 0;
            case RIGHT:
                return y < 2;
            case UP:
                return x > 0;
            case DOWN:
                return x < 2;
            default:
                return false;
        }
    }

    /**
     * 移动
     *
     * @param direction 方向
     */
    void move(int direction) {
        arr[x][y] = arr[x + moveHelp[direction][0]][y + moveHelp[direction][1]];
        arr[x + moveHelp[direction][0]][y + moveHelp[direction][1]] = 0;
        x = x + moveHelp[direction][0];
        y = y + moveHelp[direction][1];
    }

    /**
     * 恢复
     *
     * @param direction 方向
     */
    void recover(int direction) {
        move(recoverDirection(direction));
    }

    /**
     * 回滚方向
     *
     * @param direction 方向
     * @return 反方向
     */
    int recoverDirection(int direction) {
        switch (direction) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                return 0;
        }
    }

    int getStatus() {
        int status = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                status = status * 10 + arr[i][j];
            }
        }
        return status;
    }

    void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
