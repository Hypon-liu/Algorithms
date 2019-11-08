package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 0230958
 * @Date: 2019/5/14 15:14
 */
public class Solution1TwoSum {

    /**
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     */

    /**
     * my Test
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if(i >= 1 && (nums[i]+nums[i-1]) == target){
                return new int[]{i-1,i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * official Test
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * official Test2
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * official Test3
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
