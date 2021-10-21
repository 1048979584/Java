package 枚举类与注解;

/**
 * 三、Enum类的常用方法
 *  *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *  *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *  *      toString()：返回当前枚举类对象常量的名称
 
 */

public class SeasonEnum{
    public static void main(String[] args) {
        seasonTest season = seasonTest.SPRING;
        System.out.println(season.toString());
        System.out.println(season.desc);

        //values():返回的常用量(对象)数组
        seasonTest[] values = seasonTest.values();
        for(int i=0;i< values.length;i++){
            System.out.println(values[i]);
            System.out.println(values[i].season);
        }
        System.out.println("***************");
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        seasonTest valueOf = seasonTest.valueOf("WINTER");
        System.out.println(valueOf.season);

    }
    enum seasonTest{
        SPRING("春天", "春暖花开"),
        SUMMER("夏天", "夏日炎炎"),
        AUTUMN("秋天", "秋高气爽"),
        WINTER("冬天", "冰天雪地");


        private final String season ;
        private final String desc;

        seasonTest(String season, String desc) {
            this.season = season;
            this.desc = desc;
        }

    }

}
