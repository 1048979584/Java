package 泛型;



import com.sun.xml.internal.ws.util.QNameMap;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk5.0新增的特征
 */
public class GenericTest {
    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        genericTest.test2();
    }
    //在集合中使用泛型之前的情况：
    public void test(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(49);
        list.add(72);
        list.add(81);
        list.add(89);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时可能出现类型转化异常
            int stuScore = (Integer)score;

            System.out.println(stuScore);
        }

    }

    public void test2(){
        /**
         * 泛型的使用
         * 1.jdk5.0新增的特征
         *
         * 2.在集合中使用泛型：
         *  总结：
         *  ①集合接口或集合类在jdk5.0时都修改为带泛型的结构。
         *  ②在实例化集合类时，可以指明具体的泛型类型
         *  ③指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
         *    比如：add(E e)  --->实例化以后：add(Integer e)
         *  ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
         *  ⑤如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
         *
         * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
         *
         */
        Map<String,Integer> map = new HashMap();
        map.put("Jack",86);
        map.put("Tony",90);
        map.put("Dave",92);

        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        //泛型的特殊写法，嵌套
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }
    }

    /**
     * 在集合中使用泛型
     */
    public void test3(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(34);
    }
    //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

    //方式一：
//        for(Integer score :list){
//            //避免了强转的操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//        }


}
