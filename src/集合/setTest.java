package 集合;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.*;

/**
 * Set接口中没有定义额外的方法，使用的都是collection中声明过的方法
 */
public class setTest {
    /**
     * 一、Set存储无序的，不可重复的数据
     *      |--无序性：不等于随机性。存储的数据在底层数组中并非按照素组索引的位置添加，而是根据哈希值决定的
     *      |--不可重复性：保证添加的元素按照equals()判断时，不能返回ture.即相同的元素只能添加一个
     * 二、添加元素的过程：以HashSet为例：
     *      |--我们向HashSet中添加元素a时，实现调用元素a所在类的hashCode()方法计算出哈希值
     *      |--此哈希值通过某种方法计算出元素a在HasSet底层数组中的存放位置（即，索引位置），再判断此位置上是否存在元素
     *          此位置没有元素，则元素a添加成功  --情况1
     *          如果此位置上存在元素b（或以链表的形似存在多个元素），则计算元素的哈希值
     *              如果哈希值不相同则直接添加成功 --情况2
     *              如果哈希值相同，进而需要调用元素所在类的equals()方法：
     *                  equals()返回true则添加失败
     *                  equals()返回false则添加成功 --情况3
     *       对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储
     *       jdk7：元素a放到数组中，指向原来的元素
     *       jdk8：原来的元素在数组中，指向元素a
     *          七上八下
     */
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("abc");
        set.add("book");
        set.add(new User("lisa",20));
        set.add(new User("lisa",20));
        set.add(new User("lisa",21));  //!! 如果要判断添加obj的内容不能相同，需要重写equals&hashCode
        set.add(123);

//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        for(Object obj:set){
            System.out.println(obj);
        }

    }
}

class HashSetTest{
    /**
     * HashSet是Set接口的典型实现，大多数时候使用Set集合都使用这个类实现
     * HashSet按Hash算法来存储集合中的元素，因此具有很好的存取、查找、删除性能
     * Hash具有以下特点：不能保证元素的排列顺序
     *  HashSet具有以下特点：不能保证元素的排列顺序
     *      HashSet不是线程安全的
     *      集合元素可以是NULL
     *      HashSet集合判断两个元素相等的标准：两个对象通过hashCode()方法比较相等，并且两个对象的equals()方法返回值也相等
     *   对于存放Set容器的对象，对应的类一定要重写equals()和hashCode(Object obj)方法，以实现对象相等原则。即：“相等的对象必须具有相等的散列码”
     *
     *   重写hashCode() & equals()方法的基本原则
     *   在程序运行时，同一个对象多次调用hashCode()方法应该返回相同的值
     *      当两个对象的equals()方法比较返回true时，这两个对象的hashCode()方法的返回值也应该相等
     *      对象中作equals()方法比较的结果为failed，都应该用来计算hashCode值
     *   重写equals()方法基本原则
     *      复写equals方法的时候一般需要同时复写hashCode方法。通
     */
}

class LinkedHashSetTest{
    /**
     * LinkedHashSet的使用
     * LinkedHashSet作为HashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
     * 优点：对于对于频繁的遍历操作，效率较高
     */
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}



class User {
    private  String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //按照姓名从大到小排列,年龄从小到大排列

    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
//            return this.name.compareTo(user.name);  //按照姓名从小到大排列
//            return -this.name.compareTo(user.name);  //按照姓名从大到小排列
            int compare = -this.name.compareTo(user.name);  //按照姓名从大到小排列
            if (compare != 0) {   //年龄从小到大排列
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        } else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
