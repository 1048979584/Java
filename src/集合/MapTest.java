package 集合;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 * |--Map:双列数据，存储key-value对的数据
 *      |--HashMap:作为map的主要实现类；线程不安全的，效率高；存储null的key和value
 *          |--LinkedHashMap:保证在遍历map元素的时候，可以按照添加的顺序遍历。
 *              原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素，对于频繁遍历操作效率较高
 *          |--TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑的key的自然排序或定制排序底层使用的红黑树
 *          |--Hashtable:作为古老的实现类；线程安全的，效率低，不能存储null的key和value
 *              --Properties:常用来处理配置文件。key和value都是String类型
 *
 *      HashMap的底层：数组+链表（jdk7及以前）
 *                    数组+链表+红黑树（jdk8）
 *
 * 二、Map结构的理解：
 *  Map中的key：无序的、不可重复的，使用set存储所有的key            ----》key所在的类要重写equals()和hashCode()
 *  Map中的value：无序的，可重复的，使用Collection存储所有的value   ----》value所在的类要重写equls()
 *  一个键值对：key-value构成一个Entry对象
 *  Map中的entry:无序的，不可重复的，使用Set存储所有的entry
 *  HashMap判断两个key相等的标准是：两个key通过equals()方法返回true，hashCode值也相等。
 * HashMap判断两个value相等的标准是：两个value 通过equals()方法返回true。
 */

/* 总结：
 *   jdk8 相较于jdk7在底层实现方面的不同：
 *      1.new HashMap():底层没有创建一个长度为16的数组
 *      2.jdk 8底层的数组是：Node[],而非Entry[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *         4.1形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
 *         4.2当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
 */

public class MapTest {
    /**
     * Map与Collection并列存在。用于保存具有映射关系的数据：key-value
     * map中的key和value都可以是任何引用类数据
     * Map中的Key用set存放，不允许重复，即同一个Map对象所对应的类，必须重写hashCode()和equals()方法
     * 常用String类作为map的键
     * key和value之间存在单向一对一关系，即通过指定的key能找到唯一的确定的value
     * map接口的常用实现类：HashMap、TreeMap、LinkedHashMap和Properties。HashMap是Map使用最高频率的实现类
     */
    public static void main(String[] args) {
        HashMapTest();


    }

    public static void HashMapTest(){
     /**
 *      添加、删除、修改操作：
 *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
                *      void putAll(Map m):将m中的所有key-value对存放到当前map中
                *      Object remove(Object key)：移除指定key的key-value对，并返回value
                *      void clear()：清空当前map中的所有数据
                *      元素查询的操作：
 *      Object get(Object key)：获取指定key对应的value
                *      boolean containsKey(Object key)：是否包含指定的key
                *      boolean containsValue(Object value)：是否包含指定的value
                *      int size()：返回map中key-value对的个数
                *      boolean isEmpty()：判断当前map是否为空
                *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
                *      元视图操作的方法：
 *      Set keySet()：返回所有key构成的Set集合
                *      Collection values()：返回所有value构成的Collection集合
                *      Set entrySet()：返回所有key-value对构成的Set集合
                *
 */

        Map map = new HashMap();
        Map map2 = new HashMap();
        map.put(12,"AA");
        map.put(13,"BB");
        map2.put(14,"cc");
        map2.putAll(map);
        System.out.println(map);
        System.out.println(map2);
        System.out.println(map2.remove(12));
        System.out.println(map2);
        System.out.println(map2.containsKey("13"));
        System.out.println(map2.containsKey(13));
        System.out.println(map2.containsValue("BB"));
        System.out.println(map2.size());
        System.out.println(map.isEmpty());
        System.out.println(map.equals(map2));

        System.out.println("遍历所有的key，并修改指定的key-value");
        Set KeySet = map2.keySet();
        Iterator iterator1 = KeySet.iterator();
        while(iterator1.hasNext()){
            Object key = iterator1.next();
            System.out.println(key);
        }

        System.out.println("遍历所有的value");
        Collection coll = map2.values();
        Iterator iterator3 = coll.iterator();
        while(iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

        //遍历所有的key-values
        System.out.println("方式一，输出map2的值");
        Set entrySet = map2.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("方式二,输出map的值");
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }

        System.out.println("修改map中指定的key,但不改变key对应的值");
        //System.out.println(map.remove(12)); //删除key返回对应的value
        map.put(14,map.remove(12));
        System.out.println(map);

        System.out.println("修改map中指定key的value值");
        map.put(13,"DD");
        System.out.println(map);


    }
}
