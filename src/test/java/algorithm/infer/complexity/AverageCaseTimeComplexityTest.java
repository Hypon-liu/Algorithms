package algorithm.infer.complexity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: 0230958
 * @Date: 2019/11/7 15:29
 */
public class AverageCaseTimeComplexityTest {

    public static AverageCaseTimeComplexity atc;

    @Before
    public void load() throws Exception {
        atc = new AverageCaseTimeComplexity();
    }

    @Test
    public void find() throws Exception {
        int x = 5;
        int[] arr_1 = new int[]{2, 3, 4, 5};
        int pos_1 = atc.find(arr_1, arr_1.length, x);
        Assert.assertEquals(3, pos_1);

        int[] arr_2 = new int[]{2, 3, 4};
        int pos_2 = atc.find(arr_2, arr_2.length, 5);
        Assert.assertEquals(-1, pos_2);
    }

}