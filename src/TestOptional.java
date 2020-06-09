import org.junit.Test;

import java.util.Optional;

/**
 *
 *	Optional容器类的常用方法：
 * 	Optional.of(T t) ：创建一个Optional实例
 * 	Optional.empty() ：创建一个空的Optional实例
 * 	Optional.ofNullable(T t) ：若t不为null，创建Optional实例，否则创建空实例
 *	isPresent() ：判断是否包含值
 *	orElse(T t) ：如果调用对象包含值，返回该值，否则返回t
 *	orElseGet(Suppiler s) ：如果调用对象包含值，返回该值，否则返回s获取的值
 *	map(Function f) ：如果有值，对其处理，返回处理后的Optional，否则返回Optional.empty()
 *	flatMap(Function mapper) ：与map类似，要求返回值必须是Optional
 *
 **/
public class TestOptional {

	@Test
	public void test1() {
		Optional<Employee> op = Optional.of(new Employee());  //为null时会抛出空指针异常
		Employee emp = op.get();
		System.out.println(emp);
	}

	@Test
	public void test2() {
		Optional<Employee> op = Optional.empty();  //抛出NoSuchElementException异常: No value present
		System.out.println(op.get());
	}

	@Test
	public void test3() {
		Optional<Employee> op = Optional.ofNullable(null);  //为null时会抛出NoSuchElementException异常: No value present
		if (op.isPresent()) {  //如果有值就获取
			System.out.println(op.get());
		}

		Employee emp = op.orElse(new Employee("123",123, Employee.Status.FREE));
		System.out.println(emp);
	}
}
