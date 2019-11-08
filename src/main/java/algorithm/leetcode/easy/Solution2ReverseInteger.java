package algorithm.leetcode.easy;

/**
 * @Author: 0230958
 * @Date: 2019/6/10 13:49
 */
public class Solution2ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer. The 32-bit signed integer range: [−2^31,  2^31 − 1].

     Example 1:
     Input: 123
     Output: 321

     Example 2:
     Input: -123
     Output: -321

     Example 3:
     Input: 120
     Output: 21
     */


    /**
     *
     */

    /**
     * my Test
     */

    public int reverse(int x) {
        String prev = x < 0 ? "-" : "";

        char[] target = Integer.valueOf(x).toString().toCharArray();
        char[] result = new char[target.length];
        for (int i = 0; i < target.length; i++) {
            char c = target[i];
            for (int j = 1; j < target.length; j++) {
                char c1 = target[j];
                if (c1 > c) {
                    result[i] = target[j];
                    break;
                }
            }
        }

        return Integer.valueOf(prev+result);

        //throw new IllegalArgumentException("No reverse integer solution");
    }

    /**
     * official Test
     */

    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
