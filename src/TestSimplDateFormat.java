import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimplDateFormat {

	/*public static void main(String[] args) throws ExecutionException, InterruptedException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//线程不安全
		//Callable<Date> task = () ->  sdf.parse("2020-06-12");
		*//*Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return sdf.parse("2020-06-12");
			}
		};*//*

		//线程安全
		Callable<Date> task = () -> DateFormatThreadLocal.convert("2020-06-12");

		List<Future<Date>> list = new ArrayList<>();

		ExecutorService pool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			list.add(pool.submit(task));
		}

		for (Future<Date> result : list) {
			System.out.println(result.get());
		}

		pool.shutdown();
	}*/

	public static void main(String[] args) throws ExecutionException, InterruptedException, ParseException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Callable<LocalDate> task = new Callable<LocalDate>() {
		@Override
		public LocalDate call() throws Exception {
			return LocalDate.parse("2020-06-12", dtf);
		}
	};

	List<Future<LocalDate>> list = new ArrayList<>();

	ExecutorService pool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
		list.add(pool.submit(task));
	}

		for (Future<LocalDate> result : list) {
		System.out.println(result.get());
	}

		pool.shutdown();
}

}
