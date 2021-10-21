package 常用类;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTimeTest.test2();
    }

    /**
     * LocalDate、LocalTime、LocalDateTime的使用
     * 相当于来说，localDateTime使用频率较高
     */

    public static void test1() {
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 10, 13, 21, 12, 30);
        System.out.println(localDateTime1);

        //getXxx()：获取相关的属性
        int day = localDateTime.getDayOfMonth();
        System.out.println(day);
        DayOfWeek day2 = localDateTime1.getDayOfWeek();
        System.out.println(day2);
        int day3 = localDateTime.getDayOfYear();
        System.out.println(day3);
        int hour = localDateTime.getHour();
        System.out.println(hour);


        //体现不可变性
        //withXxx():设置相关的属性，day,hours
        LocalDateTime localDateTime2 =localDateTime.withDayOfMonth(11);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withMonth(12);
        System.out.println(localDateTime3);


        //不可变性,+,-
        LocalDateTime localDateTime4 = localDateTime.plusMonths(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusMonths(1);
        System.out.println(localDateTime5);


    }
    /**
     * 很重要
     * 自定义的格式，ofPattern("yyyy-MM-dd hh:mm:ss")
     */
    public static void test2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        //格式化
        String  str = formatter.format(LocalDateTime.now());
        System.out.println(str);
        String  str2 = formatter2.format(LocalDateTime.now());
        System.out.println(str2);
        String  str3 = formatter3.format(LocalDateTime.now());
        System.out.println(str3);

        //解析
        TemporalAccessor parse = formatter.parse("2021-10-13 10:03:50");
        System.out.println(parse);
    }

}
