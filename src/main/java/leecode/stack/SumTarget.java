package leecode.stack;

import lombok.Data;

import java.util.HashMap;

/**
 * @Author Huang Guojun
 * @Date 2019/7/21
 * @Discription
 */
public class SumTarget {
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums==null||nums.length==0){
            return 0;
        }
        return helper(nums,0,0,S,new HashMap<>(16));

    }

    private static int helper(int[] nums, int index, int sum, int S, HashMap<String, Integer> map) {
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum==S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index+1, sum-curNum, S, map);
        int minus = helper(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString,add+minus);
        return add+minus;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        int targetSumWays = findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }


}
