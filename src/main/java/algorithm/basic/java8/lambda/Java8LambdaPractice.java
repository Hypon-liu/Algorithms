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
public class Java8LambdaPractice {


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
    private static void sortEmployee(List<Employee> list) {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
    }

    public static String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    public static void calculateHandler(Integer int1, Integer int2, MyCalculate<Integer, Integer> mc) {
        System.out.println(mc.getValue(int1, int2));
    }

    /**
     * consumer 内置函数使用
     *
     * @param num
     * @param con
     */
    public static void numConsumer(String num, Consumer<String> con) {
        con.accept(num);
    }

    /**
     * supplier  内置函数使用
     *
     * @param num
     * @param sup
     * @return
     */
    public static Integer[] randomSupplier(Integer num, Supplier<Integer> sup) {
        Integer[] random = new Integer[10];
        for (int i = 0; i < 10; i++) {
            random[i] = sup.get();
        }
        return random;
    }

    /**
     * Function 内置函数使用
     *
     * @param str
     * @param fun
     * @return
     */
    public static String strHandlerFunction(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * predicate 断言使用
     *
     * @param list
     * @param pre
     * @return
     */
    private static List<Employee> employeePredicate(List<Employee> list, Predicate<Employee> pre) {
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (pre.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public static void main(String[] args) {
        sortEmployee(employees);
        employees.forEach(System.out::println);
        System.out.println("==================");

        String trimStr = strHandler("\t\t\t哟西", (x) -> x.trim());
        String trimStr2 = strHandler("\t\t\t哟西", String::trim);
        System.out.println("trimStr-->" + trimStr);
        System.out.println("trimStr2-->" + trimStr2);

        String caseStr = strHandler("happy", (x) -> x.toUpperCase());
        String caseStr2 = strHandler("happy", String::toUpperCase);
        System.out.println("caseStr-->" + caseStr);
        System.out.println("caseStr2-->" + caseStr2);

        String splitStr = strHandler("happy", (x) -> x.substring(2, 4));
        System.out.println("splitStr-->" + splitStr);

        System.out.println("==================");

        calculateHandler(100, 200, (x, y) -> (x + y));
        calculateHandler(100, 200, Integer::sum);
        calculateHandler(100, 200, (x, y) -> (x * y));

        System.out.println("----------------------------------------------");

        numConsumer("10000", (m) -> System.out.println("numConsumer-->" + m));

        Integer[] random = randomSupplier(10, () -> (int) (Math.random() * 100));
        System.out.println("randomSupplier-->" + Arrays.toString(random));

        String splitStr2 = strHandlerFunction("happy", (x) -> x.substring(2, 4));
        System.out.println("strHandlerFunction-->" + splitStr2);

        List<Employee> employees = employeePredicate(Java8LambdaPractice.employees, (x) -> x.getAge() > 35);
        System.out.println("employees-->" + employees);
    }
}
