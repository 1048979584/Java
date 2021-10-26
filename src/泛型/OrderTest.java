package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 */
public class OrderTest<T> {
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型，T类型的参数对象orderT
    T orderT;

    public OrderTest() {
    }

    public OrderTest(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    //如下三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "OrderTest{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    /**
     * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
     * 换句话说：泛型方法所属的类是不是泛型类都没有关系
     * 泛型方法：可以声明为静态，原因是泛型方法是在调用方法时确定而非实例化时确定
     */
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e:list){
            list.add(e);
        }
        return list;
    }
}
/**
 * 如果父类已经指定泛型类型，则继承的子类不是泛型类
 */
class SubOrder extends OrderTest<Integer> {
    //不是泛型类

}
class SubOrder2<T> extends OrderTest<T>{
    //subOrder2<T>:仍然是泛型类
}


