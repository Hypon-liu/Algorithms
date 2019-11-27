package algorithm.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * assertArrayEquals(expecteds, actuals)	查看两个数组是否相等。
 * assertEquals(expected, actual)	查看两个对象是否相等。类似于字符串比较使用的equals()方法
 * assertNotEquals(first, second)	查看两个对象是否不相等。
 * assertNull(object)	查看对象是否为空。
 * assertNotNull(object)	查看对象是否不为空。
 * assertSame(expected, actual)	查看两个对象的引用是否相等。类似于使用“==”比较两个对象
 * assertNotSame(unexpected, actual)	查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象
 * assertTrue(condition)	查看运行结果是否为true。
 * assertFalse(condition)	查看运行结果是否为false。
 * assertThat(actual, matcher)	查看实际值是否满足指定的条件
 * fail()	让测试失败
 *
 * @Before 初始化方法
 * @After 释放资源
 * @Test 测试方法，在这里可以测试期望异常和超时时间 excepted属性[@Test (expected = Exception.class)] timeout属性[@Test (timeout = 1000)]
 * @Ignore 忽略的测试方法
 * @BeforeClass 针对所有测试，只执行一次，且必须为static void
 * @AfterClass 针对所有测试，只执行一次，且必须为static void
 * @RunWith 指定测试类使用某个运行器
 * @Parameters 指定测试类的测试数据集合
 * @Rule 允许灵活添加或重新定义测试类中的每个测试方法的行为
 * @FixMethodOrder 指定测试方法的执行顺序 一个测试类单元测试的执行顺序为：
 * @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 * <p>
 * 每一个测试方法的调用顺序为：
 * @Before –> @Test –> @After
 */


/**
 * @Author: 0230958
 * @Date: 2019/5/14 15:23
 */
public class Solution1TwoSumTest {

    private Solution1TwoSum solution1TwoSum;

    @Before
    public void create() {
        solution1TwoSum = new Solution1TwoSum();
    }


    //查看两个数组是否相等
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] result = new int[]{0, 1};
    /*int[] nums = new int[]{0,4,3,2,3};
    int target = 9;
    int[] result = new int[]{1,3};*/

    @Test
    public void twoSum() throws Exception {
        assertArrayEquals(result, solution1TwoSum.twoSum(nums, target));
    }

    @Test
    public void twoSum1() throws Exception {
        assertArrayEquals(result, solution1TwoSum.twoSum1(nums, target));
    }

    @Test
    public void twoSum2() throws Exception {
        assertArrayEquals(result, solution1TwoSum.twoSum2(nums, target));
    }

    @Test
    public void twoSum3() throws Exception {
        assertArrayEquals(result, solution1TwoSum.twoSum3(nums, target));
    }

}