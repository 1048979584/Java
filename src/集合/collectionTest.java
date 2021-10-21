package 集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Collection接口：单列数据，定义了存取一组对象的方法的集合
 *  List：元素有序、可重复的集合
 *  Set：元素无序，不可重复的集合
 *
 * Map接口：双列数据，保存具有映射关系“key-vaule"的集合
 *
 * 集合框架
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *      |---List接口：存储有序的，可重复的数据。--》”动态数组“
 *          |---ArrayList、LinkedList、Vector
 *              |---ArrayList：作为list接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData存储
 *                  |--
 *              |---LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高;底层使用双向链表存储
 *              |---Vector：作为list接口的古老实现类；线程安全，效率低；底层使用Object[] elementData存储
 *
 *       |---Set接口：存储无序的、不可重复的数据  --》数学集合
 *          |---HashSet、LinkedHashSet、TreeSrt
 *
 * |---Map接口：双列接口，用来存储一对（key-value)一对的数据
 *      |---HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *  特别注意点：Collection接口的实现类中添加obj时，要求obj所在的类重写equals()
 */

public class collectionTest {
    public static void main(String[] args) {
        colltest();
    }

public static void colltest(){
    Collection coll = new ArrayList();
    Collection coll2 = new ArrayList();
    Collection coll3 = new ArrayList();
    Person person =new Person("jenefer",20);

    System.out.println("******1.添加******");
    coll.add(123);
    coll.add("abc");
    coll2.add("123");
    System.out.println(coll);
    coll2.add(coll);
    System.out.println(coll2);

    System.out.println("******2.获取有效元素的个数******");
    System.out.println(coll.size());

    System.out.println("******3.清空集合");
    coll.clear();
    System.out.println(coll);

    System.out.println("******4.是否是空集合******");
    boolean isTrue = coll.isEmpty();
    System.out.println(isTrue);

    System.out.println("******5.是否包含某个元素******");
    coll.add(123);
    coll.add("abc");
    coll.add("cde");
    coll3.add(123);
    coll3.add("abc");
    coll3.add("cde");
    System.out.println(coll.contains("abc"));

    System.out.println("******6.删除");
    coll.remove("abc");
    System.out.println(coll);

    System.out.println("******7.取两个集合的交集******");
    System.out.println(coll3);
    coll3.retainAll(coll);
    System.out.println(coll3);

//    boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c

    System.out.println("******8.集合是否相等******");
    System.out.println(coll.equals(coll3));

    coll3.add(person);
    boolean isTure2 = coll3.contains(new Person("jenefer",20)); //ture,如果没有重写equals，此时结果为false
    System.out.println(isTure2);

    System.out.println("******9.集合转成对象数组******");
    Object[] arr = coll2.toArray();
    for(int i=0;i< arr.length;i++){
        System.out.println(arr[i]);
    }

    System.out.println("******10.数组转换成集合******");
    String[] arr2 = new String[]{"aa","bb","cc"};
    List<String> list = Arrays.asList(arr2);
    System.out.println(list);

    List list2 = Arrays.asList(123,456,789);
    System.out.println(list2);
    List list3 = Arrays.asList(new int[]{123,456,789});  //使用基本数据类型时，会将数组作为一个整体
    System.out.println(list3);
    List list4 = Arrays.asList(new Integer[]{123,456,789});
    System.out.println(list4);

//    获取集合对象的哈希值
//
//    遍历
//    iterator()：返回迭代器对象，用于集合遍历


}
}
