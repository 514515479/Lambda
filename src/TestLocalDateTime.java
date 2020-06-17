import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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
}
