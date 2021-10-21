package 枚举类与注解;

/**
 * 1.理解Annotation：
 * ①Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并在不改变程序原有逻辑情况下，在源程序中嵌入一些补充信息
 * ②在JAVASE中，注解的使用比较简单，例如标记过时的功能，忽略警告等
 *
 * 2.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 * @Override: 限定重写父类方法，该注解只能由于方法
 * @Deprecated: 用于表示所修饰的元素（类，方法）已过时。
 * @SuppressWarnings: 抑制编译器警告
 *
 * 3.如何自定义注解，参照@SuppressWarnings定义
 * ①注解声明为@interface
 * ②内部定义成员，通常用value表示
 * ③可以指定成员的默认值，使用default定义
 * ④如果自定义注解没有成员，表明是一个标识作用，比如@Override
 *
 * 如果注解有成员，在使用时要给成员赋值
 * 自定义注解必须配上注释的信息处理流程才有意义
 *
 * 4.JDK提供的4种元注解
 * @Retention  :指定所修饰的Annotation的生命周期：SOURCE , CLASS(默认行为) ,RUNTIME
 *      只有声明为RUNTIME声明周期的注解，才能通过反射获取
 * @Target :用于指定被修饰的Anotation 能用于修饰哪些元素
 * @Document
 * @Inherited
 *
 */
public class AnnotationTest {
    @MyAnnotation("自定义注解")
    public void test(){

    }
    @MyAnnotation
    public void test2(){}

}
