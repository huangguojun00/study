package leecode.queueandstatck;

import java.util.*;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription 打开转盘锁问题 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 */
public class OpenLock {
    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        int i = openLock(deadends, target);
        System.out.println(i);


    }


    public static int openLock(String[] deadends, String target) {
        // 去重
        Set<String> dds = new HashSet<>(Arrays.asList(deadends));
        // 初始化开始状态
        String init = "0000";
        // 判断极端特例
        if (dds.contains(init) || dds.contains(target)) {
            return -1;
        }
        if (init.equals(target)) {
            return 0;
        }
        int result = 0;
        // 创建一个访问过的集合
        Set<String> visited = new HashSet<>();
        // 创建一个队列
        Queue<String> q = new LinkedList<>();
        q.add(init);
        // 只要队列中不是空就一直循环  如果全部循环没有目标 返回失败
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            // 循环队列
            for (int i = 0; i < size; i++) {
                // 将队列中头部的元素移除 并返回 如果为空返回null
                String curStr = q.poll();
                if (curStr==null){
                    return -1;
                }
                // 循环每个字符
                for (int j = 0; j < 4; j++) {
                    // 开始为1 dif<=9, 间隔 8
                    for (int dif = 1; dif <=9 ;dif+=8) {
                        char[] ca = curStr.toCharArray();
                        ca[j] = (char) ((ca[j]-'0'+dif)%10+'0');
                        String s = new String(ca);
                        // 如果目标包含s  则查询成功
                        if (target.equals(s)){
                            return result;
                        }
                        // 如果 没有死亡列表里没有 并且还没有 遍历过  加入队列 并标记为已访问
                        if (!dds.contains(s)&&!visited.contains(s)){
                            q.add(s);
                            visited.add(s);
                        }
                    }

                }

            }

        }
        return -1;

    }
}
