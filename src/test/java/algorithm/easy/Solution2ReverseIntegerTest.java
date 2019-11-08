package algorithm.easy;

import algorithm.leetcode.easy.Solution2ReverseInteger;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: 0230958
 * @Date: 2019/6/10 13:53
 */
public class Solution2ReverseIntegerTest {

    @Test
    public void reverse() throws Exception {
        assertEquals(321, new Solution2ReverseInteger().reverse(123));
        assertEquals(-321, new Solution2ReverseInteger().reverse(-123));
        assertEquals(21, new Solution2ReverseInteger().reverse(120));
    }


    @Test
    public void reverse1() throws Exception {
        assertEquals(321, new Solution2ReverseInteger().reverse1(123));
        assertEquals(-321, new Solution2ReverseInteger().reverse1(-123));
        assertEquals(21, new Solution2ReverseInteger().reverse1(120));
        assertEquals(765, new Solution2ReverseInteger().reverse1(756));

    }

    @Test
    public void test() throws Exception {
        System.out.println(new BigDecimal(2.0e-6));
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
        System.out.println(true && false || true && false);
    }


}