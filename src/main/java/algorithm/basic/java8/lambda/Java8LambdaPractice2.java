package algorithm.basic.java8.lambda;

import algorithm.basic.java8.lambda.func.Employee;
import algorithm.basic.java8.lambda.func.MyCalculate;
import algorithm.basic.java8.lambda.func.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * Java8 内置的四大核心函数式接口
 * <p>
 * Consumer<T>:消费型接口
 * void accept(T t)
 * <p>
 * Supplier<T>:供给型接口
 * T get()
 * <p>
 * Function<T>:函数型接口，用于计算
 * R get(T t)
 * <p>
 * Predicate<T>:断言型接口，用于判断
 * boolean test(T t)
 */


/**
 * @Author: hypon
 * @Date: 2019/11/18 15:10
 */
public class Java8LambdaPractice2 {


    static List<Employee> employees = Arrays.asList(
            new Employee(18, "hypon", 7000.88),
            new Employee(28, "devil", 6666.0),
            new Employee(38, "sing", 5888.88),
            new Employee(18, "bell", 4888.88),
            new Employee(38, "www", 3888.88),
            new Employee(68, "cn", 2838.88)
    );


    /**
     * 1.定制排序比较两个员工（先按年龄比，再按姓名比）
     * <p>
     * 2.将字符串转换成大写，根据2-4个索引位置截取字符串
     * <p>
     * 3.计算参数的和、乘
     */

    public static void main(String[] args) {

    }
}
