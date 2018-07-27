package hanoi;

import org.apache.commons.lang3.StringUtils;

/**
 * 汉诺塔递归
 * 一定要经过中间层
 * 解析过程：
 * 中到左右、左右到中 3步骤
 *  1. 1到N-1 左→右
 *  2. N 左→中
 *  3. 1到N-1 右→中
 * 左到右/右到左 5步骤
 *  1. 1到N-1 左→右
 *  2. N 左→中
 *  3. 1到N-1 右→左
 *  4. N 中→右
 *  5. 1到N-1 左→右
 * @author weijianyu
 */
public class HanoiProblem {

    private static final String LEFT = "left";
    private static final String MID = "mid";
    private static final String RIGHT = "right";

    public int resolve1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (StringUtils.equals(MID, from) || StringUtils.equals(MID, to)) {
                System.out.println("move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("move 1 from " + from + " to " + mid);
                System.out.println("move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (StringUtils.equals(MID, from) || StringUtils.equals(MID, to)) {
            String another = (StringUtils.equals(LEFT, from) || StringUtils.equals(LEFT, to)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HanoiProblem().resolve1(10,"mid", "mid","left"));
    }
}
