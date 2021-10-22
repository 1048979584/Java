package 集合;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        test2();
    }

    //自然排序，类中已定义的排序
    public static void test() {
        TreeMap map = new TreeMap();
        User2 u1 = new User2("Tom", 23);
        User2 u2 = new User2("Jerry", 32);
        User2 u3 = new User2("Jack", 20);
        User2 u4 = new User2("Rose", 18);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 76);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }


    //定制排序，重写排序方法
    public static void test2(){
       TreeMap treeMap = new TreeMap(new Comparator() {
           @Override
           public int compare(Object o1, Object o2) {
               if(o1 instanceof User2 && o2 instanceof User2){
                   User2 U1= (User2)o1;
                   User2 U2= (User2)o2;
//                   return Integer.compare(U1.getAge(),U2.getAge());  //通过年龄
                   return U1.getName().compareTo(U2.getName());        //通过姓名
               }
               throw new RuntimeException("输入参数不一致");
           }
       });
        User2 u1 = new User2("Tom", 23);
        User2 u2 = new User2("Jerry", 32);
        User2 u3 = new User2("Jack", 20);
        User2 u4 = new User2("Rose", 18);

        treeMap.put(u1, 98);
        treeMap.put(u2, 89);
        treeMap.put(u3, 76);
        treeMap.put(u4, 100);

        Set entrySet = treeMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());


        }
    }
}

class User2 implements Comparable {
    private String name;
    private int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
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
        if (!(o instanceof User2)) return false;
        User2 user2 = (User2) o;
        return Objects.equals(name, user2.name) && Objects.equals(age, user2.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "user2{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}