package leecode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huang Guojun
 * @Date 2019/6/15
 * @Discription 设计一个最小栈
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private List<Integer> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        isEmpty();
        data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        isEmpty();
        int a = data.get(0);
        for (int i = 0; i < data.size(); i++) {
            if (a > data.get(i)) {
                a = data.get(i);
            }
        }
        return a;
    }

    public void isEmpty() {
        if (data.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
    }
}
