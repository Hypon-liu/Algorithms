package algorithm.infer.complexity;

/**
 * 均摊时间复杂度
 *
 * @Author: 0230958
 * @Date: 2019/11/7 15:00
 */
public class AmortizedTimeComplexity {

    //array 标识一个长度为n的数组
    //代码中的array.length就等于n
    int n = 2;
    int[] array = new int[n];
    int count = 0;

    /**
     * 往数组插入数据
     *
     * 总的时间复杂度：O(1)
     *
     * @param val
     */
    void insert(int val) {
        //当数据满了
        if (count == array.length) {
            int sum = 0;
            //将数组之前的数据遍历数组求和
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }
            //将求和的sum值放在第一个位置，并清空数组
            array[0] = sum;
            count = 1;
        }
        //数据有空闲空间，直接将数据插入数组
        array[count] = val;
        ++count;
    }


    int len = 2;
    int arr[] = new int[len];
    int i = 0;

    /**
     * 往数组中添加一个元素
     *
     * @param ele
     */
    void add(int ele) {
        //数组空间不够了
        if (i >= len) {
            //重新申请一个2倍大小的数组空间
            int new_arr[] = new int[len * 2];
            //把原来arr数组中数据copy到new_arr数组中
            for (int j = 0; j < len; j++) {
                new_arr[j] = arr[j];
            }
            //new_arr复制给arr,arr现在大小是2倍的len了
            arr = new_arr;
            len = 2 * len;
        }
        //将ele放到下标为i的位置，下标+1
        arr[i] = ele;
        ++i;
    }
}
