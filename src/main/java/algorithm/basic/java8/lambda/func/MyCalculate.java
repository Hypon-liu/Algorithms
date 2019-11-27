package algorithm.basic.java8.lambda.func;

/**
 * @Author: hypon
 * @Date: 2019/11/18 15:42
 */
public interface MyCalculate<T,R> {

    R getValue(T t1,T t2);
}
