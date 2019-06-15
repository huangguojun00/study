package leecode.queue;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @Author Huang Guojun
 * @Date 2019/6/1
 * @Discription 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * <p>
 * <p>
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.             广度有优先的思想  依次减去比n小的完全平方数  知道变为0
 */
public class PerfectSquare {
    public static void main(String[] args) {
        int i = numSquares(13);
        System.out.println(i);
    }


    public static int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        // 构建了一个链表
        LinkedList<Node> queue = new LinkedList<>();
        // 在尾部添加了一个 n ,0
        queue.addLast(new Node(n, 0));
        // 是否已访问的记录
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            int num = node.getVal();
            int step = node.getStep();
            if (num == 0) {
                return step;
            }
            for (int i = 0; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) {
                        return step + 1;
                    }
                    queue.addLast(new Node(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return 0;

    }

    static class Node {
        int val;
        int step;

        Node(int val, int step) {
            this.val = val;
            this.step = step;
        }

        int getVal() {
            return val;
        }

        int getStep() {
            return step;
        }
    }

}
