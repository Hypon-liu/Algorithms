package algorithm.infer.complexity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: 0230958
 * @Date: 2019/11/7 16:04
 */
public class AsymptoticTimeComplexityTest {

    public static AsymptoticTimeComplexity atc;

    @Before
    public void load() throws Exception {
        atc = new AsymptoticTimeComplexity();
    }

    @Test
    public void cal() throws Exception {
        atc.cal(1000000);
    }

    @Test
    public void cal2() throws Exception {
        atc.cal2(1000000);
    }

    @Test
    public void cal3() throws Exception {
        atc.cal3(1000000);
    }

    @Test
    public void cal4() throws Exception {
        atc.cal4(1000000,1000000);
    }

    @Test
    public void calLog() throws Exception {
        atc.calLog(1000000);
    }

}