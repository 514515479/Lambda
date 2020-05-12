import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamPractice {

	/**
	 *
	 * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表？
	 * 给定{1, 2, 3, 4, 5}，返回{1, 4, 9, 16, 25}
	 *
	 **/
	@Test
	public void test1() {
		Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
		Arrays.stream(nums)
				.map(x -> x * x)
				.forEach(System.out::println);
	}

	/**
	 *
	 * 2.用map和reduce方法数一数流中有多少个Employee
	 *
	 **/
	@Test
	public void test2() {
		List<Employee> emps = new ArrayList<>(Arrays.asList(
				new Employee("张三", 21, Employee.Status.FREE),
				new Employee("李四", 22, Employee.Status.BUSY),
				new Employee("王五", 23, Employee.Status.VOCATION),
				new Employee("阿六", 24, Employee.Status.FREE),
				new Employee("狗蛋", 25, Employee.Status.BUSY),
				new Employee("二愣子", 21, Employee.Status.VOCATION)
		));
		Optional<Integer> op = emps.stream()
				.map(x -> 1)
				.reduce(Integer::sum);
		System.out.println(op.get());
	}
}
