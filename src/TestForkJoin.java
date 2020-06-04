import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoin {

	@Test
	public void test1() {
		Instant start = Instant.now();

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(1, 100000000L);
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
		for (int i = 0; i < 100000000L; i++) {
			sum += i;
		}

		Instant end = Instant.now();

		System.out.println("耗费时间（毫秒）：" + Duration.between(start, end).toMillis());
	}
}
