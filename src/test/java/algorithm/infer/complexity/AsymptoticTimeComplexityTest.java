package algorithm.infer.complexity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: 0230958
 * @Date: 2019/11/7 16:04
 */
public class AsymptoticTimeComplexityTest {

    public AsymptoticTimeComplexity atc;
    public Integer[] arr;

    @Before
    public void load() throws Exception {
        atc = new AsymptoticTimeComplexity();
        arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    @Test
    public void cal() throws Exception {
        int cal = atc.cal(1000000);
        System.out.println(cal);
    }

    @Test
    public void cal2() throws Exception {
        int cal = atc.cal2(1000000);
        System.out.println(cal);
    }

    @Test
    public void cal3() throws Exception {
        int cal = atc.cal3(1000000);
        System.out.println(cal);
    }

    @Test
    public void cal4() throws Exception {
        int cal = atc.cal4(1000000, 1000000);
        System.out.println(cal);
    }

    @Test
    public void calLog() throws Exception {
        atc.calLog(1000000);
    }

    @Test
    public void binarySearch() {
        Integer find = 8;
        Integer idx = atc.binarySearch(arr, find);
        System.out.println("binarySearch--->" + idx +",arr=" + Arrays.toString(arr) + ",find=" + find);
    }
}