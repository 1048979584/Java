package 枚举类与注解;

/**
 * 自定义枚举类，使用单例模式创建枚举类
 */
public class Seasontest {

    public static void main(String[] args) {
        Seasontest seasontest = SPRING;
        System.out.println(SPRING.season);
    }

    //1.声明Season对象的属性:private final修饰
    private final String season;
    private final String desc;

    //2.私有化类的构造器,并给对象属性赋值
    public Seasontest(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

    //3.提供当前枚举类的多个对象
    public static final Seasontest SPRING = new Seasontest("春天", "春暖花开");
    public static final Seasontest SUMMER = new Seasontest("夏天", "夏日炎炎");
    public static final Seasontest AUTUMN = new Seasontest("秋天", "秋高气爽");
    public static final Seasontest WINTER = new Seasontest("冬天", "冰天雪地");
    //4.1.其他诉求：获取枚举类对象的属性

    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    //4.2.其他诉求2：提供toString()
    @Override
    public String toString() {
        return "Seasontest{" +
                "season='" + season + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


}
