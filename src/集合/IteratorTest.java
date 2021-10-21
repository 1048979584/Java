package 集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
 */
public class IteratorTest {
    public static void main(String[] args) {
        IteratorTest iteratorTest = new IteratorTest();
        iteratorTest.test();
    }


    public void test() {
        Collection collection = new ArrayList();
        Person per = new Person("tony", 25);
        collection.add(123);
        collection.add("abc");
        collection.add('f');
        collection.add(per);
        collection.add(new String("Tom"));

         Iterator iterator = collection.iterator();

        //迭代方法一
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //迭代方法二
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }

        //遍历集合
        iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //增强for循环
        for(Object obj :collection){
            System.out.println(obj);
        }

    }
}
