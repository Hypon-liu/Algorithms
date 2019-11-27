package algorithm.basic.java8.lambda.func;

/**
 * @Author: hypon
 * @Date: 2019/11/18 14:39
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
