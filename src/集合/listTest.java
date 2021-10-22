package 集合;
//List常用方法

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index) / remove(Object obj)
 * 改：set(int index, Object ele)
 * 查：get(int index)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历：① Iterator迭代器方式
 * ② 增强for循环
 * ③ 普通的循环
 */

public class listTest {
    public static void main(String[] args) {
        listTest test = new listTest();
        test.ListTest();
    }

    public void ListTest() {
        List list = new ArrayList();
        list.add("123");
        list.add("456");
        list.add("abc");
        list.add(1);
        list.add(2);
        list.add(new Person("dave", 28));

        System.out.println("一.在index位置插入ele元素");
        list.add(0, "first");
        Iterator iterator = list.iterator();
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("二.从index位置开始将eles中的所有元素添加进来");
        List list2 = Arrays.asList(1,'a',"bc","abc");
        list.addAll(list2);
        System.out.println(list);

        System.out.println("三.获取指定index位置的元素");
        System.out.println(list.get(2));

        System.out.println("四.返回obj在集合中出现的位置");
        int index = list.indexOf("abc");
        int lastIndex = list.lastIndexOf("abc");
        System.out.println("第一次出现位置"+index);
        System.out.println("最后一次出现位置"+lastIndex);

        System.out.println("五.设置指定index位置的元素为ele");
        list.set(0,"second");
        System.out.println(list);

        System.out.println("六.返回从fromIndex到toIndex位置的子集合");
        List sub = list.subList(3,5);
        System.out.println(sub);

        System.out.println("七.移除指定index位置的元素，并返回此元素");
        Object obj = list.remove(2);
        System.out.println(obj);
        list.remove(new Integer(2) );  //删除对象
        list.remove("abc");
        System.out.println(list);


    }
}
/**
 * 请问ArrayList/LinkedList/Vector的异同？谈谈你的理解？
 * ArrayList底层是什么？扩容机制？Vector和ArrayList的最大区别?
 *
 * ArrayList和LinkedList的异同二者都线程不安全，相对线程安全的Vector，执行效率高。
 * 此外，ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
 * 对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
 * 对于新增和删除操作add(特指插入)和remove，LinkedList比较占优势，因为ArrayList要移动数据。
 *
 * ArrayList和Vector的区别Vector和ArrayList几乎是完全相同的,
 * 唯一的区别在于Vector是同步类(synchronized)，属于强同步类。
 * 因此开销就比ArrayList要大，访问要慢。正常情况下,
 * 大多数的Java程序员使用ArrayList而不是Vector,
 * 因为同步完全可以由程序员自己来控制。Vector每次扩容请求其大小的2倍空间，
 * 而ArrayList是1.5倍。Vector还有一个子类Stack。
 */
