import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

	/**
	 * 测试fork/join
	 *
	 **/
	@Test
	public void test1() {
		Instant start = Instant.now();

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(1, 10000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);

		Instant end = Instant.now();

		System.out.println("耗费时间（毫秒）：" + Duration.between(start, end).toMillis());
	}

	/**
	 * 普通for循环
	 *
	 **/
	@Test
	public void test2() {
		Instant start = Instant.now();

		long sum = 0L;
		for (int i = 0; i < 10000000000L; i++) {
			sum += i;
		}

		Instant end = Instant.now();

		System.out.println("耗费时间（毫秒）：" + Duration.between(start, end).toMillis());
	}

	/**
	 * java8 并行流
	 *
	 **/
	@Test
	public void test3() {
		Instant start = Instant.now();

		Long sum = LongStream.rangeClosed(1, 10000000000L)
				.parallel()  //并行流
				//.sequential()   //串行流
				.reduce(0, Long::sum);

		Instant end = Instant.now();

		System.out.println("耗费时间（毫秒）：" + Duration.between(start, end).toMillis());
	}
}
