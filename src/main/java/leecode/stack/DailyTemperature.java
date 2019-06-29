package leecode.stack;

import java.util.Stack;

/**
 * @Author Huang Guojun
 * @Date 2019/6/29
 * @Discription 当你想操最后一个元素的时候就可以使用
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> nubmers = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!nubmers.isEmpty() && T[i] > T[nubmers.peek()]) {
                Integer s = nubmers.pop();
                res[s] = i - s;
            }
            nubmers.push(i);
        }
        return res;
    }
}
