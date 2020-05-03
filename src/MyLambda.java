/**
 * @Author: tobi
 * @Date: 2020/5/3 23:48
 **/

import org.junit.Test;

import java.util.Comparator;
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
 *    语法格式二：有一个参数，并且无返回值（如果只有一个参数，那么小括号可以省略不写）
 *              x -> System.out.println("Hello Lambda!");
 *               或
 *              (x) -> System.out.println("Hello Lambda!");
 *
 *    语法格式三：有两个以上参数，有返回值，并且Lambda体中有多条语句
 *              (x, y) -> {
 *                  do something...
 *                  do something...
 *              };
 *    语法格式四：如果Lambda体中只有一条语句，那么return和大括号都可以省略不写
 *              (x, y) ->  Integer.compare(x, y);
 *
 *    语法格式五：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
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

    //语法格式三：有两个以上参数，有返回值，并且Lambda体中有多条语句
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("Hello Lambda!");
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(8,6));
    }

    //语法格式四：如果Lambda体中只有一条语句，那么return和大括号都可以省略不写
    //语法格式五：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) ->  Integer.compare(x, y);
        //或 Comparator<Integer> com = (Integer x, Integer y) ->  Integer.compare(x, y);
        System.out.println(com.compare(8,6));
    }
}
