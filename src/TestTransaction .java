import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestTransaction {

	List<Transaction> transactions = null;

	@Before
	public void before() {
		Trader t1 = new Trader("张三", "莆田");
		Trader t2 = new Trader("李四", "福州");
		Trader t3 = new Trader("王五", "厦门");
		Trader t4 = new Trader("阿六", "安徽");
		Trader t5 = new Trader("狗蛋", "深圳");
		Trader t6 = new Trader("二愣子", "北京");
		Trader t7 = new Trader("狗栓", "北京");

		transactions = new ArrayList<>(Arrays.asList(
				new Transaction(t1, 2011, 300),
				new Transaction(t2, 2012, 1000),
				new Transaction(t3, 2012, 500),
				new Transaction(t4, 2012, 800),
				new Transaction(t5, 2011, 700),
				new Transaction(t6, 2012, 800),
				new Transaction(t7, 2011, 1500)
		));
	}

	//1.找出2011年的所有交易，并按交易额排序
	@Test
	public void test1(){
		transactions.stream()
				.filter(x -> x.getYear() == 2011)
				.sorted((x, y) -> Integer.compare(x.getValue(), y.getValue()))
				.forEach(System.out::println);
	}
	//2.交易员都在哪些不同的城市工作过
	@Test
	public void test2() {
		transactions.stream()
				.map(x -> x.getTrade().getCity())
				.distinct()
				.forEach(System.out::println);
	}
	//3.查找来自北京的交易员，按照姓名排序
	@Test
	public void test3() {
		transactions.stream()
				.map(Transaction::getTrade)
				.filter(x -> "北京".equals(x.getCity()))
				.sorted((x, y) -> x.getName().compareTo(y.getName()))
				.forEach(System.out::println);
	}
	//4.返回所有交易员姓名，按字母顺序排序
	@Test
	public void test4() {
		transactions.stream()
				.map(x -> x.getTrade().getName())
				.sorted()
				.forEach(System.out::println);
	}
	//5.有没有交易员是在深圳工作的
	@Test
	public void test5() {
		boolean flag = transactions.stream()
				.anyMatch(x -> "深圳".equals(x.getTrade().getCity()));
		System.out.println(flag);
	}
	//6.打印在北京的交易员的所有交易额
	@Test
	public void test6() {
		Optional<Integer> op = transactions.stream()
				.filter(x -> "北京".equals(x.getTrade().getCity()))
				.map(Transaction::getValue)
				.reduce(Integer::sum);
		System.out.println(op.get());
	}
	//7.所有交易中，最高交易额是多少
	@Test
	public void test7() {
		Optional<Integer> op = transactions.stream()
				.map(x -> x.getValue())
				.max((x, y) -> Integer.compare(x, y));
		System.out.println(op.get());
	}
	//8.找到交易额最小的交易
	@Test
	public void test8() {
		Optional<Integer> op = transactions.stream()
				.map(x -> x.getValue())
				.min((x, y) -> Integer.compare(x, y));
		System.out.println(op.get());
	}
}
