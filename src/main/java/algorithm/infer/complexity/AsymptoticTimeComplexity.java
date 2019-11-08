package algorithm.infer.complexity;

/**
 * 渐进时间复杂度，简称时间复杂度，是代码执行时间随着数据规模增长的变化趋势
 * <p>
 * 算法的执行时间与每行代码的执行次数成正比，用T(n) = O(f(n))表示，其中T(n)表示算法执行总时间，f(n)表示每行代码执行总次数，而n往往表示数据的规模。
 * <p>
 * 关系：表示算法的执行时间与数据规模之间的增长关系
 * <p>
 * 常用的复杂度：
 * 1.多项式阶：随着数据规模的增长，算法的执行时间和空间占用，按照多项式的比例增长
 * O(1) (常数阶)、 O(logn) (对数阶)、O(n) (线性阶) 、O(nlogn) (线性对数阶)、O(n²) (平方阶)、O(n³) (立方阶)
 * <p>
 * 2.非多项式阶：随着数据规模增长，算法的执行时间和空间占用暴增，这类算法性能极差
 * O(2^n) (指数阶)、O(n!) (阶乘阶)
 *
 * @Author: 0230958
 * @Date: 2019/11/7 14:21
 */
public class AsymptoticTimeComplexity {

    /**
     * 单段代码看高频：比如循环
     * <p>
     * 总的时间复杂度：O(n)
     *
     * @param n
     * @return
     */
    int cal(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 多段代码取最大：比如一段大妈中有单循环或者多重循环，取多重循环的复杂度
     * <p>
     * 总的时间复杂度：O(max(f(n),g(n)))
     *
     * @param n
     * @return
     */
    int cal2(int n) {
        int sum_1 = 0;
        int p = 1;
        for (; p < 100; ++p) {
            sum_1 = sum_1 + p;
        }

        int sum_2 = 0;
        int q = 1;
        for (; q < n; ++q) {
            sum_2 = sum_2 + q;
        }

        int sum_3 = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum_3 = sum_3 + i * j;
            }
        }
        return sum_1 + sum_2 + sum_3;
    }

    /**
     * 嵌套代码求乘积：比如递归、多重循环
     * <p>
     * 总的时间复杂度：O(n²)
     *
     * @param n
     * @return
     */
    int cal3(int n) {
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum = sum + i * j;
            }
        }
        return sum;
    }

    /**
     * 多个规模求加法：比如方法有两个参数控制两个循环的次数吗，取两个复杂度相加
     * <p>
     * 总的时间复杂度：O(m+n) => O(f(m) * f(n))
     *
     * @param n
     * @param m
     * @return
     */
    int cal4(int n, int m) {
        int sum_1 = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum_1 = sum_1 + i;
        }

        int sum_2 = 0;
        int j = 1;
        for (; j <= m; ++j) {
            sum_2 = sum_2 + j;
        }
        return sum_1 + sum_2;
    }

    /**
     * 对数复杂度：O(logn)
     *
     * @param n
     * @return
     */
    void calLog(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
    }
}
