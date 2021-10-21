import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args) {
        DateTimeTest dateTimeTest = new DateTimeTest();
        dateTimeTest.test2();
    }
    /**
     * java.util.Date类 ---> 表示特定的瞬间，精确到毫秒
     *            |---java.sql.Date类
     *
     * 1.两个构造器的使用
     *     >构造器一：Date()：创建一个对应当前时间的Date对象
     *     >构造器二：创建指定毫秒数的Date对象
     * 2.两个方法的使用
     *     >toString():显示当前的年、月、日、时、分、秒
     *     >getTime():获取当前Date对象对应的毫秒数。（时间戳）
     *
     * 3. java.sql.Date对应着数据库中的日期类型的变量
     *     >如何实例化
     *     >如何将java.util.Date对象转换为java.sql.Date对象
     *
     */

    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1= new Date();
        System.out.println(date1.toString()); //Wed Oct 13 10:45:18 CST 2021
        System.out.println(date1.getTime()); //1634093178060

        //构造器二：创建指定毫秒数的Date对象
        Date date2= new Date(163409112454l);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3= new java.sql.Date(163409112454l);
        System.out.println(date3.toString());


        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);  //多态，父类继承子类的方法
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        java.sql.Date date6 = new java.sql.Date(date1.getTime());
        System.out.println("转换的时间为"+date6);


    }

}
