package 常用类;

/**
 * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同的结果
 * 2.只要有一个是变量就在堆空间中
 * 3.如果拼接的结果调用intern()，返回值就在常量池中
 */
public class StringAdress {
    public static void main(String[] args) {
        String String1 = "hello";
        String String2 = "world";
        String String3 = "hello" + "world";
        String String4 = String1 + "world";
        String String5 = "hello" + String2;
        String String6 = String1 + String2;
        String String7 = (String1 + String2).intern();
        String String8 = "helloworld";
        final  String String9 = "world"; //添加final后变为常量
        String String10 = String1 + String9;


        System.out.println(String3 == String4);
        System.out.println(String3 == String5);
        System.out.println(String3 == String6);

        System.out.println(String3 == String7);
        System.out.println(String3 == String8);
        System.out.println(String3 == String10);

        stringTest st = new stringTest();
        st.change(st.str,st.ch);
        System.out.println(st.str); //good
        System.out.println(st.ch); //best


    }


}

class stringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    void change(String str, char ch[]) {
        str = "test ok";//string具有不可变性，栈空间地址值对应堆空间值和常量池中的值
        ch[0] = 'b';
    }
}

