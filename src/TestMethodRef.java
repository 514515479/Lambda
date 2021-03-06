import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用 “方法引用”（可以理解为方法引用是Lambda表达式的另外一种表现形式）
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
 *
 * 二、构造器引用：
 *      ClassName::new
 * 注意：
 *      需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致。
 *
 * 三、数组引用：
 *      Type::new
 *
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

        Employee emp = new Employee("张三", 25, Employee.Status.FREE);
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

    //构造器引用
    @Test
    public void test4() {
        //第一种（无参构造器）
        Supplier<Employee> sup1 = () -> new Employee();
        //第二种（无参构造器）
        Supplier<Employee> sup2 = Employee::new;

        //第一种（有参构造器）
        Function<String, Employee> fun1 = x -> new Employee(x);
        System.out.println(fun1.apply("张三"));
        //第二种（有参构造器）注意：调用哪个构造器取决于函数式接口的参数，这里即Function的apply
        Function<String, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply("张三"));
    }

    //数组引用
    @Test
    public void test5() {
        //第一种
        Function<Integer, String[]> fun1 = x -> new String[x];
        String[] str1 = fun1.apply(10);
        System.out.println(str1.length);
        //第二种
        Function<Integer, String[]> fun2 = String[]::new;
        String[] str2 = fun1.apply(5);
        System.out.println(str2.length);
    }
}
