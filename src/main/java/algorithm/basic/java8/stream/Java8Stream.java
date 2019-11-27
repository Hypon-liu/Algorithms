package algorithm.basic.java8.stream;

/**
 * Stream 的三个操作步骤【初始化流 -> 数据转换或提取 -> 数据操作或显示格式】
 * <p>
 * 1.创建Stream
 * 2.中间操作Intermediate：不会执行任何操作
 * 3.终止操作Terminal：一次性执行全部内容，"惰性求值"
 * <p>
 * Intermediate：
 * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
 * <p>
 * Terminal：
 * forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
 * <p>
 * Short-circuiting：
 * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 */

import algorithm.basic.java8.lambda.func.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: hypon
 * @Date: 2019/11/19 11:09
 */
public class Java8Stream {

    static List<Employee> employees = Arrays.asList(
            new Employee(28, "devil", 6666.0),
            new Employee(38, "sing", 5888.88),
            new Employee(18, "hypon", 7000.88),
            new Employee(18, "bell", 4888.88),
            new Employee(38, "www", 3888.88),
            new Employee(38, "www", 3888.88),
            new Employee(38, "www", 3888.88),
            new Employee(68, "cn", 2838.88)
    );

    public static void init() {
        //1.通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流，迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //5.创建无限流，生成
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
    }

    /**
     * 中间操作
     * <p>
     * 筛选与切片
     * filter(Predicate) —— 从流中，根据条件过滤或排除某些元素
     * limit(n) —— 截断流，指定生成数据个数，超过指定个数的数据不会操作
     * skip(n) —— 跳过元素，返回一个跳过了前n 个元素的流，若流中元素不足n个，则返回一个空流，与limit(n) 互补
     * distinct() —— 去重，需要在对象实现，根据元素的hashCode()和equals()，去除重复数据
     * <p>
     * 映射
     * map(Function) —— 映射，将元素转换其他形式或提取信息，并其映射成一个新的元素，相当于list.add(),将添加的集合增加到集合中
     * flatMap —— 映射，将流中的元素提取出连接成一个流，相当于list.addAll(),将添加的集合所有元素增加到集合中
     * <p>
     * 排序
     * sorted(Comparable) —— 自然排序
     * sorted(Comparator) —— 定制排序
     */
    public static void middleOperate() {
        employees.stream().filter(e -> e.getAge() > 35).forEach(System.out::println);
        System.out.println("-------------");
        employees.stream().filter(e -> e.getAge() > 35).limit(4).distinct().forEach(System.out::println);
        System.out.println("-------------");
        employees.stream().filter(e -> e.getAge() > 35).limit(5).skip(1).forEach(System.out::println);

        System.out.println("=============");

        employees.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("-------------");
        List<String> list = Arrays.asList("hypon", "devil");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-------------");

        //{{a,a,a},{b,b,b}}
        Stream<Stream<Character>> stream = list.stream().map(Java8Stream::filterCharacter);
        stream.forEach(sm -> {
            sm.forEach(System.out::println);
        });
        //{a,a,a,b,b,b}
        System.out.println("-------------");

        Stream<Character> stream1 = list.stream().flatMap(Java8Stream::filterCharacter);
        stream1.forEach(System.out::println);

        System.out.println("=============");

        list.stream().sorted().forEach(System.out::println);
        System.out.println("-------------");
        employees.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 查找与匹配,返回值有可能为空则返回Optional
     * allMatch(Predicate) —— 检查是否匹配所有元素
     * anyMatch(Predicate) —— 检查是否至少匹配一个元素
     * noneMatch(Predicate) —— 检查是否没有匹配所有元素
     * findFirst —— 返回第一个元素，Optional
     * findAny —— 返回当前流中的任意元素
     * count —— 返回流中的总个数
     * max —— 返回流中最大值
     * min —— 返回流中最小值
     * <p>
     * 归约
     * reduce(T,BinaryOperator) / reduce(BinaryOperator) —— 可以将流中元素反复结合起来，得到一个值
     * 收集
     * collect(Collector) —— 将流转换为其他形式，接收一个Collection接口的实现，用于给Stream中元素做汇总的方法,插入不同的集合
     */
    public static void breakOperate() {
        boolean allMatch = employees.stream().allMatch(employee -> employee.getAge().equals(18));
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getAge().equals(18));
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getAge().equals(18));
        System.out.println("allMatch-->" + allMatch + ",anyMatch-->" + anyMatch + ",noneMatch-->" + noneMatch);

        Optional<Employee> findFirst = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();
        System.out.println("findFirst-->" + findFirst.get());
        Optional<Employee> findAny = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findAny();
        System.out.println("findAny-->" + findAny.get());
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("min-->" + min.get());
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("max-->" + max.get());

        System.out.println("=============");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //0是起始值，二元运算函数式
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("reduce-->" + sum);
        //获取员工公司总和
        Optional<Double> reduce2 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("reduce2-->" + reduce2.get());

        //获取员工公司总和
        List<Double> collect = employees.stream().map(Employee::getSalary).distinct().collect(Collectors.toList());
        System.out.println("collect-->" + collect);
        //任意集合
        HashSet<Double> collect1 = employees.stream().map(Employee::getSalary).collect(Collectors.toCollection(HashSet::new));
        System.out.println("collect1-->" + collect1);
        //平均数
        Double collect2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("collect2-->" + collect2);
        //多级分组
        Map<Integer, Map<String, List<Employee>>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getAge,
                Collectors.groupingBy(Employee::getName)));
        System.out.println("collect3-->" + collect3);
        //分区
        Map<Boolean, List<Employee>> collect4 = employees.stream().collect(Collectors.partitioningBy((x) -> x.getAge() > 35));
        System.out.println("collect4-->" + collect4);
        //运算
        DoubleSummaryStatistics collect5 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("collect5-->average=" + collect5.getAverage() + ",max=" + collect5.getMax() + ",min=" + collect5.getMin()
                + ",count=" + collect5.getCount() + ",sum=" + collect5.getSum());
        //字符串连接
        String collect6 = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "==", "=="));
        System.out.println("collect6-->" + collect6);

        System.out.println("=============");

        // peek 对每个元素执行操作并返回一个新的 Stream
        List<String> collectPeek = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println("collect+peek-->" + collectPeek);

    }

    private static void optional() {
        String str = null;
        Integer optional1 = Optional.ofNullable(str).map(String::length).orElse(-1);
        System.out.println("str-->" + str + ",optional1-->" + optional1);
        Optional.ofNullable(str).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        //init();
        //middleOperate();
        //breakOperate();
        optional();
    }
}
