package 常用类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat的使用：SimpleDateFprmate对Dtae类的美化和解析
 * 1.两个操作
 * 1.1格式化：日期--》字符串
 * 1.2解析：格式化的逆过程--？日期
 */

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormatTest sdft = new SimpleDateFormatTest();
        sdft.testSimple2();
    }

    public void testSimple() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        //格式化：日期--》字符串
        Date date = new Date();
        System.out.println(date); // Wed Oct 13 16:58:43 CST 2021
        String formate = simpleDateFormat.format(date);
        System.out.println(formate); //21-10-13 下午5:26

        //解析：字符串--》日期
        String str= "22-10-13 下午5:26";
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);
    }
    public void testSimple2() throws ParseException {
        /** 按照指定格式美化和解析：调用带参构造器 **/
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        Date date = new Date();
        String str = simpleDateFormat2.format(date);
        System.out.println(str);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = simpleDateFormat2.parse("02020.五月.10 公元 04:32 下午");
        System.out.println(date2);  //Sun May 10 16:32:00 CST 2020
    }


}
