package algorithm.basic.java8.lambda.func;

/**
 * @Author: hypon
 * @Date: 2019/11/18 14:45
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
