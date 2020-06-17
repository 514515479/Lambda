import org.junit.Test;

import java.time.*;

/**
 * @Author: tobi
 * @Date: 2020/6/17 17:03
 **/
public class TestLocalDateTime {

    //  1. 日期：LocalDate  时间：LocalTime  日期和时间：LocalDateTime
    @Test
    public void test1() {
        //获取系统当前时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //获取指定时间
        LocalDateTime ldt2 = LocalDateTime.of(2020, 6, 17, 17, 13, 30);
        System.out.println(ldt2);

        //时间运算
        LocalDateTime ldt3 = ldt2.plusDays(5);
        //减
        ldt3 = ldt2.plusDays(-5);
        // 或 ldt3 = ldt2.minusDays(5);
        System.out.println(ldt3);
        System.out.println(ldt3.getYear());   //年
        System.out.println(ldt3.getMonth());  //返回Month对象
        System.out.println(ldt3.getMonthValue());  //返回int值
        System.out.println(ldt3.getDayOfMonth());  //日
    }

    //  2.时间戳（以Unix元年：1970年1月1日 00:00:00 到某个时间之间的毫秒值）
    @Test
    public void test2() {
        Instant ins1 = Instant.now();  //默认获取的是UTC时区
        System.out.println(ins1);

        //设置时区 +8
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        //换成毫秒
        System.out.println(ins1.getEpochSecond());

        //运算 +30秒
        Instant ins2 = Instant.ofEpochSecond(30);
        System.out.println(ins2);
    }

    //  3.时间间隔
    //    Duration: 时间之间的间隔
    //    Period: 日期之间的间隔
    @Test
    public void test3() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();

        Duration duration1 = Duration.between(ins1, ins2);
        System.out.println(duration1.getSeconds()); //秒
        System.out.println(duration1.toMillis()); //毫秒

        System.out.println("---------------------------------");

        LocalTime lt1 = LocalTime.now();
        Thread.sleep(1000);
        LocalTime lt2 = LocalTime.now();
        System.out.println(Duration.between(lt1, lt2).toMillis()); //毫秒

        System.out.println("---------------------------------");

        LocalDate ld1 = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }
}
