package algorithm.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author: hypon
 * @Date: 2019/11/14 16:55
 */
public class Solution3RemoveElementTest {

    private Solution3RemoveElement solution3RemoveElement;

    @Before
    public void createObj() {
        solution3RemoveElement = new Solution3RemoveElement();
    }

    @Test
    public void removeElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        assertEquals(2, solution3RemoveElement.removeElement(nums, val));
        System.out.println(solution3RemoveElement.printAll(nums));
    }

    @Test
    public void removeElement2() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        assertEquals(2, solution3RemoveElement.removeElement2(nums, val));
        System.out.println(solution3RemoveElement.printAll(nums));
    }

    @Test
    public void removeElement3() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        assertEquals(2, solution3RemoveElement.removeElement3(nums, val));
        System.out.println(solution3RemoveElement.printAll(nums));
    }
}