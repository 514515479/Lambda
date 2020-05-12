import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、创建stream
 * 		1.通过Collection集合提供的stream()或parallelStream()
 * 		2.通过Arrays中的静态方法stream()获得数组流
 * 		3.通过Stream类中的静态方法of()
 * 		4.创建无限流
 * 			a.迭代
 * 			b.生成
 *
 * 二、中间操作
 *
 * 		1.筛选与切片
 * 			filter -- 接收Lambda，从流中排除某些元素。
 * 			limit -- 截断流，使其元素不超过给定数量。
 * 			skip(n) -- 跳过元素，返回一个扔掉前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补。
 * 			distinct -- 筛选。通过流所生成元素的hashCode()和equals()去重
 *
 * 		2.映射
 * 			map --接收Lambda，讲元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * 			flatMap -- 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 *
 * 		3.排序
 * 			sorted() -- 自然排序
 * 			sorted(Comparator com) -- 定制排序
 *
 * 三、终止操作（终端操作）
 *		查找与匹配
 *			allMatch -- 检查是否匹配所有元素
 *			andMatch -- 检查是否匹配至少一个元素
 *			noneMatch -- 检查是否没有匹配所有元素
 *			findFirst -- 返回第一个元素
 *			findAny -- 返回当前流中的任意元素
 *			count -- 返回流中元素的总个数
 *			max -- 返回流中的最大值
 *			min -- 返回流中最小值
 *
 * 四、归约
 * 		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) -- 可以将流中元素结合起来，得到一个值。
 *
 * 五、收集
 * 		collect -- 将流转换成其他形式。接收一个Collect接口的实现，用于给stream中元素做汇总的方法。
 **/
public class TestStreamApi {

	List<Employee> empList = new ArrayList<>(Arrays.asList(
			new Employee("张三", 21, Employee.Status.FREE),
			new Employee("李四", 22, Employee.Status.BUSY),
			new Employee("王五", 23, Employee.Status.VOCATION),
			new Employee("阿六", 24, Employee.Status.FREE),
			new Employee("阿六", 24, Employee.Status.BUSY),
			new Employee("阿六", 24, Employee.Status.VOCATION),
			new Employee("阿六", 24, Employee.Status.FREE),
			new Employee("狗蛋", 25, Employee.Status.BUSY),
			new Employee("二愣子", 21, Employee.Status.VOCATION)
	));

	//创建stream
	@Test
	public void test1() {
		// 1.通过Collection集合提供的stream()或parallelStream()
		List<String> list = new ArrayList<>();
		Stream stream1 = list.stream();

		// 2.通过Arrays中的静态方法stream()获得数组流
		Employee[] emps = new Employee[10];
		Stream stream2 = Arrays.stream(emps);

		//3.通过Stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");

		//4.创建无限流
		//迭代
		Stream<Integer> stream4 = Stream.iterate(0, x -> x + 1);
		//从0开始，无限+1
		//stream4.forEach(System.out::println);

		//生成
		//生成5个100以内的随机数
		Stream.generate(() -> (int)(Math.random() * 100))
				.limit(5)
				.forEach(System.out::println);
	}


	//内部迭代：迭代操作由 Stream API完成
	@Test
	public void test2() {
		//返回的是流
		//中间操作：不会执行任何操作，只是定义逻辑。
		Stream<Employee> stream = empList.stream()
										.filter(x -> {

											System.out.println("中间操作");
											return x.getAge() > 23;
										});

		//终止操作：一次性执行全部内容，即“惰性求值”
		stream.forEach(System.out::println);
	}

	//外部迭代：
	@Test
	public void test3() {
		Iterator<Employee> it = empList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	//筛选和切片
	@Test
	public void test4() {
		empList.stream()
				.filter(x -> {
					//找到结果后，后续就不再执行。和 && || 类似 （单个& | 是全部条件都执行）
					System.out.println("短路");
					return x.getAge() > 21;
				})
				.limit(1)
				.forEach(System.out::println);

		System.out.println("----------------------------------------");

		empList.stream()
				.filter(x -> x.getAge() > 21)
				//.skip(2)
				.distinct()
				.forEach(System.out::println);
	}

	//映射
	@Test
	public void test5() {
		List<String> strList = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee"));

		strList.stream()
				.map(x -> x.toUpperCase())
				.forEach(System.out::println);

		System.out.println("----------------------------------------");

		empList.stream()
				.map(Employee::getName)
				.forEach(System.out::println);

		System.out.println("----------------------------------------");

		Stream<Stream<Character>> stream = strList.stream()
				.map(TestStreamApi::filterCharacter); //{{a,a,a},{b,b,b}}

		stream.forEach(sm -> {
			sm.forEach(System.out::println);
		});

		System.out.println("----------------------------------------");

		strList.stream()
				.flatMap(TestStreamApi::filterCharacter) //{a,a,a,b,b,b}
				.forEach(System.out::println);
	}

	public static Stream<Character> filterCharacter(String str) {
		List<Character> charList = new ArrayList<>();
		for (Character ch : str.toCharArray()) {
			charList.add(ch);
		}
		return charList.stream();
	}

	//排序
	@Test
	public void test6() {
		List<String> strList = new ArrayList<>(Arrays.asList("ccc", "aaa", "ddd", "bbb"));
		//自然排序
		strList.stream()
				.sorted()
				.forEach(System.out::println);

		//定制排序
		//先按年龄排，如果年龄一样再按姓名排
		empList.stream()
				.sorted((x, y) -> {
					if (x.getAge().equals(y.getAge())) {
						return x.getName().compareTo(y.getName());
					} else {
						return x.getAge().compareTo(y.getAge());
					}
				})
				.forEach(System.out::println);
	}

	@Test
	public void test7() {
		//检查是否 所有状态都是BUSY
		Boolean flag1 = empList.stream()
				.allMatch(x -> Employee.Status.BUSY.equals(x.getStatus()));
		System.out.println(flag1);

		//检查是否 部分状态都是BUSY
		Boolean flag2 = empList.stream()
				.anyMatch(x -> Employee.Status.BUSY.equals(x.getStatus()));
		System.out.println(flag2);

		//检查是否 不是所有的状态都是BUSY
		Boolean flag3 = empList.stream()
				.anyMatch(x -> Employee.Status.BUSY.equals(x.getStatus()));
		System.out.println(flag3);

		//返回第一个/任意一个
		/**
		 * 可以看到findAny()操作，返回的元素是不确定的，对于同一个列表多次调用findAny()有可能会返回不同的值。使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
		 **/
		Optional<Employee> op = empList.stream() //并行.parallelStream() 多个线程去找，谁先找到就返回谁的
											//.sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
											.filter(x -> x.getAge() > 20 && x.getAge() < 26)
											//.findFirst();
											.findAny();
		//如果op中的对象为空，就可以搞个替代的对象，返回的是对应的类型
		System.out.println(op.orElse(new Employee("零", 0, Employee.Status.FREE)));
		System.out.println(op.get());
	}

	@Test
	public void test8() {
		//总共几个元素
		Long count = empList.stream()
				.count();
		System.out.println(count);

		//年龄最大的
		Optional<Employee> op1 = empList.stream()
				.max((x,y) -> Integer.compare(x.getAge(), y.getAge()));
		System.out.println(op1.get());

		Optional<Integer> op2 = empList.stream()
				.map(Employee::getAge)
				.min(Integer::compareTo);
		System.out.println(op2.get());
	}

	//归约
	@Test
	public void test9() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//累加（这里的reduce有起始值0，所有返回结果是Integer）
		Integer sum = list.stream()
				.reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		//累加（这里的reduce没有起始值，所有返回结果是Optional）
		Optional<Integer> op = empList.stream()
				.map(Employee::getAge)
				.reduce(Integer::sum);
		System.out.println(op.get());

	}

	//收集（collect）
	@Test
	public void test10(){
		List<String> list = empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
		list.forEach(System.out::println);

		System.out.println("----------------------------------------");

		Set<String> set = empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());
		set.forEach(System.out::println);

		System.out.println("----------------------------------------");

		//放到一些特殊的集合中
		HashSet<String> hashSet = empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
		hashSet.forEach(System.out::println);

		System.out.println("----------------------------------------");

		//总数
		Long count = empList.stream()
				.collect(Collectors.counting()); //等于 empList.stream().count();
		System.out.println("总数=" + count);

		System.out.println("----------------------------------------");

		//平均值,总和
		Double avg = empList.stream()
				.collect(Collectors.averagingInt(Employee::getAge));
		Double sum = empList.stream()
				.collect(Collectors.summingDouble(Employee::getAge));
		System.out.println("平均值=" + avg + ",总和=" + sum);

		System.out.println("----------------------------------------");

		//最大值，最小值
		Optional<Employee> op1 = empList.stream()
				.collect(Collectors.maxBy((x, y) -> Integer.compare(x.getAge(), y.getAge())));
		Optional<Employee> op2 = empList.stream()
				.collect(Collectors.minBy((x, y) -> Integer.compare(x.getAge(), y.getAge())));
		System.out.println("最大值=" + op1.get() + ",最小值=" + op2.get());

		System.out.println("----------------------------------------");

		//分组
		Map<Employee.Status, List<Employee>> map1 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map1);

		System.out.println("----------------------------------------");

		//多级分组（先按状态分，然后按年龄分）
		Map<Employee.Status, Map<String, List<Employee>>> map2 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(x -> {
					if (x.getAge() < 35) {
						return "青年";
					} else {
						return "中老年";
					}
				})));
		System.out.println(map2);

		System.out.println("----------------------------------------");

		//分区
		Map<Boolean, List<Employee>> map3 = empList.stream()
				.collect(Collectors.partitioningBy(x -> x.getAge() > 23));
		System.out.println(map3);

		System.out.println("----------------------------------------");

		//加逗号
		String str = empList.stream()
				.map(Employee::getName)
				//.collect(Collectors.joining(","));
				.collect(Collectors.joining(",", "===", "===")); //参数：中间，首，尾
		System.out.println(str);
	}
}
