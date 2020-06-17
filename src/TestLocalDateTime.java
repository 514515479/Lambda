import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @Author: tobi
 * @Date: 2020/6/17 17:03
 **/
public class TestLocalDateTime {

    //  1. 日期：LocalDate  时间：LocalTime  日期和时间：LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
    }
}
