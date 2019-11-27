package algorithm.leetcode.easy;

/**
 * @Author: hypon
 * @Date: 2019/11/14 16:44
 */
public class Solution3RemoveElement {

    /**
     * Example1:
     * <p>
     * Given nums = [3,2,2,3], val = 3,
     * Your function should return length = 2, with the first two elements of nums being 2.
     * <p>
     * <p>
     * Example2:
     * <p>
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     */

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * official test
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * official test
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


    public String printAll(int[] nums) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int num : nums) stringBuffer.append(num + " ");
        return stringBuffer.toString();
    }
}
