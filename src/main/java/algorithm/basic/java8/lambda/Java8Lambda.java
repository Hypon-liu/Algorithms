package algorithm.basic.java8.lambda;

import algorithm.basic.java8.lambda.func.Employee;
import algorithm.basic.java8.lambda.func.FilterEmployeeByAge;
import algorithm.basic.java8.lambda.func.FilterEmployeeBySalary;
import algorithm.basic.java8.lambda.func.MyPredicate;

import java.util.*;

/**
 * @Author: hypon
 * @Date: 2019/11/18 13:57
 */
public class Java8Lambda {

    static List<Employee> employees = Arrays.asList(
            new Employee(18, "hypon", 7000.88),
            new Employee(28, "devil", 6666.0),
            new Employee(38, "sing", 5888.88),
            new Employee(18, "bell", 4888.88),
            new Employee(38, "www", 3888.88),
            new Employee(68, "cn", 2838.88)
    );

    //需求:获取当前公司员工年龄大于35的员工信息
    private static List<Employee> filterEmployee(List<Employee> list) {
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }

        return emps;
    }

    private static List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public static void main(String[] args) {
        List<Employee> emps = filterEmployee(employees);
        System.out.println("emps==>" + emps);

        //优化一
        List<Employee> newEmps = filterEmployee(employees, new FilterEmployeeByAge());
        System.out.println("newEmps==>" + newEmps);

        List<Employee> newEmps2 = filterEmployee(employees, new FilterEmployeeBySalary());
        System.out.println("newEmps2==>" + newEmps2);

        //优化二
        List<Employee> newEmps3 = filterEmployee(Java8Lambda.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        System.out.println("newEmps3==>" + newEmps3);

        //优化三 lambda
        List<Employee> newEmps4 = filterEmployee(Java8Lambda.employees, (e) -> e.getSalary() <= 5000);
        newEmps4.forEach(System.out::println);

        //优化四 stream API
        employees.stream().filter((e) -> e.getSalary() <= 5000).forEach(System.out::println);
        employees.stream().map(Employee::getName).limit(2).forEach(System.err::println);
    }


}
