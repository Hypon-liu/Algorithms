package algorithm.infer.complexity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: 0230958
 * @Date: 2019/11/7 15:20
 */
public class AmortizedTimeComplexityTest {

    public AmortizedTimeComplexity atc;

    @Before
    public void load() throws Exception {
        atc = new AmortizedTimeComplexity();
    }

    @Test
    public void insert() throws Exception {
        atc.insert(5);
        Assert.assertEquals(5, atc.array[0]);
        atc.insert(10);
        Assert.assertEquals(10, atc.array[1]);
        atc.insert(20);
        Assert.assertEquals(15, atc.array[0]);
        Assert.assertEquals(20, atc.array[1]);
    }

    @Test
    public void add() throws Exception {
        atc.add(5);
        Assert.assertEquals(5, atc.arr[0]);
        Assert.assertEquals(2, atc.len);
        atc.add(10);
        Assert.assertEquals(10, atc.arr[1]);
        Assert.assertEquals(2, atc.len);
        atc.add(20);
        Assert.assertEquals(20, atc.arr[2]);
        Assert.assertEquals(4, atc.len);
    }

    @Test
    public void insert2() throws Exception {
        for (int i = 0; i < 1000000000; i++) {
            atc.insert(i);
        }
        System.out.println(Arrays.toString(atc.array));
    }

    @Test
    public void add2() throws Exception {
        for (int i = 0; i < 1000000000; i++) {
            atc.add(i);
        }
        System.out.println(Arrays.toString(atc.arr));
    }

}