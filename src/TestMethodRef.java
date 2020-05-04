import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用 “方法引用”（可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法格式：
 *      1.对象::实例方法名
 *      2.类::静态方法名
 *      3.类::实例方法名
 *
 * 注意：
 *      1.Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致。
 *      2.若Lambda参数列表中的第一个参数是实例方法的调用者，第二个参数是实例方法的参数时，可以使用 ClassName::method,如：
 *          BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
 *          第一个参数x为调用者，第二个参数y为equals方法的参数，则可以写成
 *          BiPredicate<String, String> bp2 = String::equals;
 **/
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test1() {
        //第一种
        PrintStream ps1 = System.out;
        Consumer<String> con1 = x -> ps1.println(x);
        con1.accept("abc");
        //第二种
        PrintStream ps2 = System.out;
        Consumer<String> con2 = ps2::println;
        con2.accept("abc");

        System.out.println("---------------------------------------");

        Employee emp = new Employee("张三", 25);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    //类::静态方法名
    @Test
    public void test2() {
        //第一种
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(1, 2));
        //第二种
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 2));
    }

    //类::实例方法名
    @Test
    public void test3() {
        //第一种
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("abcd", "abc"));
        //第二种
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abcd", "abcd"));
    }
}
