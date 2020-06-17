import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: tobi
 * @Date: 2020/5/4 16:07
 **/
public class Practice {

    //调用Collections.sort()方法，通过定制排序比较两个Employee（先按年龄比，年龄相同按姓名比），使用Lambda作为参数传递。
    @Test
    public void test1() {
        List<Employee> list = Arrays.asList(
                new Employee("张三", 26, Employee.Status.FREE),
                new Employee("李四", 24, Employee.Status.FREE),
                new Employee("王五", 23, Employee.Status.FREE),
                new Employee("阿六", 25, Employee.Status.FREE)
        );

        Collections.sort(list, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                //正排
                return x.getAge().compareTo(y.getAge());
                //倒过来排
                //return -x.getAge().compareTo(y.getAge());
            }
        });

        list.forEach(x -> System.out.println(x));
    }



    /**
     * 1.声明一个函数式接口，接口中声明抽象方法 public String getValue(String str)。
     * 2.声明类TestLambda，类中编写方法使用接口作为参数，将一个字符串转换为大写，并作为方法的返回值。
     * 3.再将一个字符串的第2个和第4个索引位置进行截取字串。
     *
     **/
    @Test
    public void test2() {
        System.out.println(strOperational("abcdefg", x -> x.toUpperCase()));
        //TestStr ts = x -> x.toUpperCase();
        //ts.getValue("abcdefg");

        System.out.println(strOperational("abcdefg", x -> x.substring(2, 5)));
    }

    //字符串转大写，截取索引2到4
    public String strOperational(String str, TestStr ts) {
        return ts.getValue(str);
    }

    /**
     * 1.声明一个带两个泛型的函数式接口，泛型类型为 <T, R>，T为参数，R为返回值。
     * 2.接口中声明对应抽象方法。
     * 3.在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和。
     * 4.再计算两个long型参数的乘积
     **/
    @Test
    public void test3() {
        longOperational(10L, 20L, (x, y) -> x + y);
        longOperational(10L, 20L, (x, y) -> x * y);

        //TestLong<Long, Long> tl =  (x, y) -> x + y;
    }

    //计算long的和，乘积
    public void longOperational(Long x, Long y, TestLong<Long, Long> tl) {
        System.out.println(tl.getValue(x, y));
    }
}
