package algorithm.basic.java8.lambda;

/**
 * 一、方法引用：若lambda体中的内容有方法已经实现，我们可以使用"方法引用"
 * <p>
 * 对象::实力方法名
 * 类::静态方法名
 * 类::实例方法名
 * <p>
 * 注意：
 * 1.Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 2.若Lambda 参数列表中第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * <p>
 * <p>
 * 二、构造器引用
 * 格式：　ClassName::new
 * 注意：需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致
 * <p>
 * 三、数组引用
 * 格式： Type[]::new
 */

import algorithm.basic.java8.lambda.func.Employee;

import java.util.Comparator;
import java.util.function.*;

/**
 * @Author: hypon
 * @Date: 2019/11/19 10:00
 */
public class Java8MethodRef {

    /**
     * objectRef  对象::实力方法名
     */
    private static void objectRef() {
        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con2 = System.out::println;

        con.accept("objectRef--old-->" + "hello");
        con2.accept("objectRef--new-->" + "hello");

        Employee emp = new Employee();
        emp.setName("hypon");
        Supplier<String> sup = () -> emp.getName();
        Supplier<String> sup2 = emp::getName;

        System.out.println("objectRef--old-->" + sup.get());
        System.out.println("objectRef--new-->" + sup2.get());
    }

    /**
     * classStaticRef  类::静态方法名
     */
    private static void classStaticRef() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com2 = Integer::compare;

        System.out.println("classStaticRef--old-->" + com.compare(10, 5));
        System.out.println("classStaticRef--new-->" + com2.compare(10, 5));
    }

    /**
     * classRef  类::实例方法名
     */
    private static void classRef() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;

        System.out.println("classRef--old-->" + bp.test("hypon", "hypon"));
        System.out.println("classRef--new-->" + bp2.test("hypon", "hypon"));
    }

    /**
     * constructRef 构造器引用
     */
    private static void constructRef() {
        //无参构造器
        Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup2 = Employee::new;

        System.out.println("constructRef--old-->" + sup.get());
        System.out.println("constructRef--new-->" + sup.get());

        //有一个参构造器
        Function<String, Employee> fun = (x) -> new Employee(x);
        Function<String, Employee> fun2 = Employee::new;
        BiFunction<Integer, String, Employee> biFun = Employee::new;

        System.out.println("constructRef--old-->" + fun.apply("hypon"));
        System.out.println("constructRef--new-->" + fun2.apply("hypon"));
        System.out.println("constructRef--new-->" + biFun.apply(18, "hypon"));
    }

    private static void arrayRef() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        Function<Integer, String[]> fun2 = String[]::new;

        System.out.println("arrayRef--old-->" + fun.apply(10).length);
        System.out.println("arrayRef--new-->" + fun2.apply(10).length);
    }

    public static void main(String[] args) {
        objectRef();
        classStaticRef();
        classRef();
        constructRef();
        arrayRef();
    }
}
