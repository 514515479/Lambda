/**
 * @Author: tobi
 * @Date: 2020/5/3 23:48
 **/

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 一、Lambda表达式基础语法：Java8中引入了一个新的操作符 “->”，该操作符称作为箭头操作符或者是Lambda操作符
 *
 *    箭头操作符讲Lambda表达式拆成两部分：
 *      左侧：Lambda 表达式的参数列表
 *      右侧：Lambda 表达式执行的功能，即Lambda体
 *
 *    语法格式一：无参数，无返回值
 *              () -> System.out.println("Hello Lambda!");
 *
 *    语法格式二：有一个参数，并且无返回值
 **/
public class MyLambda {

    //语法格式一：无参数，无返回值
    @Test
    public void test1() {
        //等于 final int num = 0;
        int num = 0; //jdk1.7以前必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!" + num);
                //不能++，其实默认还是final
                //System.out.println("Hello Lambda!" + num++);
            }
        };
        r.run();
        System.out.println("----------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    //语法格式二：有一个参数，并且无返回值
    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        //把 “Lambda学习”这个参数传过去，打印输出
        con.accept("Lambda学习");
    }
}
