package algorithm.basic.java8.stream;

import algorithm.basic.java8.lambda.func.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: hypon
 * @Date: 2019/11/19 18:17
 */
public class Java8StreamPractice2 {

    static List<Employee> employees = Arrays.asList(
            new Employee(28, "devil", 6666.0),
            new Employee(38, "sing", 5888.88),
            new Employee(18, "hypon", 7000.88),
            new Employee(18, "bell", 4888.88),
            new Employee(38, "www", 3888.88),
            new Employee(38, "www", 3888.88),
            new Employee(38, "www", 9888.88),
            new Employee(68, "cn", 2838.88)
    );

    //1.给定一个数字列表，如何返回一个由每个书的平方构成的列表呢？request:[1,2,3,4,5],return:[1,4,9,16,25]
    private static Integer[] numSquareByArray(Integer[] nums) {
        return Arrays.stream(nums).map(x -> x * x).toArray(Integer[]::new);
    }

    private static List<Integer> numSquareByList(List<Integer> nums) {
        return nums.stream().map(x -> x * x).collect(Collectors.toList());
    }

    // 1.怎样用map和reduce方法统计流中由多少个Employee
    // 2.定制排序比较两个员工（先按年龄比，再按姓名比）
    // 3.将字符串转换成大写，根据2-4个索引位置截取字符串
    // 4.计算参数的和、乘
    // 5.找出38岁的员工并工资从低到高排序
    private static void employeeCalculate() {
        Optional<Integer> count = employees.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println("count--->" + count.get());

        List<Employee> sortedEmps = employees.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).collect(Collectors.toList());
        System.out.println("sortedEmps--->" + sortedEmps);

        List<String> upperCase = employees.stream().filter(x -> x.getName().length() > 4)
                .map(x -> x.getName().toUpperCase().substring(2, 4)).collect(Collectors.toList());
        System.out.println("upperCase--->" + upperCase);

        int sum = employees.stream().mapToInt(Employee::getAge).sum();
        int multiply = employees.stream().mapToInt(Employee::getAge).map(x -> x * x).sum();
        System.out.println("sum--->" + sum + ",multiply--->" + multiply);

        List<Employee> filterEmps = employees.stream().filter(x -> x.getAge().equals(38))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("filterEmps--->" + filterEmps);

        Map<Double, List<Employee>> groupByList = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("groupByList--->" + groupByList);

    }


    public static void main(String[] args) {
        Integer[] initArr = new Integer[]{1, 2, 3, 4, 5};
        Integer[] squareArr = numSquareByArray(initArr);
        System.out.println(Arrays.toString(initArr) + "----numSquareByArray----" + Arrays.toString(squareArr));
        List<Integer> initList = Arrays.asList(initArr);
        List<Integer> squareList = numSquareByList(initList);
        System.out.println(initList + "----numSquareByList----" + squareList);

        employeeCalculate();
    }
}
