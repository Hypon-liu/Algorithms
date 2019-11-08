package algorithm.infer.complexity;

/**
 * 平均情况时间复杂度
 *
 * 最好情况时间复杂度(best case time complexity) => O(1)
 * 最坏情况时间复杂度(worst case time complexity) => O(n)
 * 平均情况时间复杂度(average case time complexity) => O(1)
 *
 * @Author: 0230958
 * @Date: 2019/11/7 14:59
 */
public class AverageCaseTimeComplexity {

    /**
     * 在数组中查找一个数据
     *
     * @param array
     * @param n
     * @param x
     * @return
     */
    int find(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for(;i <n; ++i) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
