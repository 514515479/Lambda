import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java四大核心函数式接口
 * Consumer<T>：消费型接口
 *      void accept(T t);
 *
 * Supplier<T>：供给型接口
 *      T get();
 *
 * Function<T, R>：函数型接口
 *      R apply(T t);
 *
 * Predicate<T>：断言型接口
 *      boolean test(T t);
 *
 **/
public class FourInterface {

    //Consumer<T>：消费型接口
    @Test
    public void test1() {
        Consumer<Double> con = x -> System.out.println(x - 50);
        con.accept(100.00);
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //Supplier<T>：供给型接口
    @Test
    public void test2() {
        //产生100以内的整数
        Supplier<Integer> sup = () -> (int) (Math.random() * 100);
        System.out.println(sup.get());
    }

    //Function<T, R>：函数型接口
    @Test
    public void test3() {
        //处理字符串
        Function<String, String> fun = x -> x.toUpperCase();
        System.out.println(fun.apply("abcdefg"));
    }

    //Predicate<T>：断言型接口
    @Test
    public void test4() {
        //大于10的整数
        Predicate<Integer> pre = x -> x > 10;
        System.out.println(pre.test(2));
        System.out.println(pre.test(20));
    }
}
