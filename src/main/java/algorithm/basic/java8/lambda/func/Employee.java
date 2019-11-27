package algorithm.basic.java8.lambda.func;

import java.util.Objects;

/**
 * @Author: hypon
 * @Date: 2019/11/18 14:10
 */
public class Employee {
    private Integer age;
    private String name;
    private Double salary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Employee(Integer age, String name, Double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getAge(), employee.getAge()) &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
