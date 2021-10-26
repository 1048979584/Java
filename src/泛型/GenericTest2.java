package 泛型;

/**
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 * 1.关于自定义泛型类、泛型接口
 */
public class GenericTest2 {
    /**
     * 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为object类型
     * 要求：如果定义了类是带泛型的，建议在实例化时指明类的泛型
     */
    public void test(){
        OrderTest order = new OrderTest();
        order.setOrderT(12);
        order.setOrderT("abc");
        //建议实例化时指明泛型类型
        OrderTest<String> order2 = new OrderTest<>();
        order2.setOrderT("abc");
//        order2.setOrderT(123);

        //由于子类在继承泛型时指明了泛型的类型，实例化泛型类型时无需在指明类型
        SubOrder sub = new SubOrder();
        sub.setOrderT(123);
//        sub.setOrderT("abc");

    }
}
