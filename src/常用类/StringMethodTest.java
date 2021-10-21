package 常用类;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * int length()：返回字符串的长度：return value.length
 * char charAt(int index)：返回某索引处的字符return value[index]
 * boolean isEmpty()：判断是否是空字符串：return value.length==0
 * String toLowerCase()：使用默认语言环境，将String中的所有字符转换为小写
 * String toUpperCase()：使用默认语言环境，将String中的所有字符转换为大写
 * String trim()：返回字符串的副本，忽略前导空白和尾部空白
 * boolean equals(Object obj)：比较字符串的内容是否相同
 * boolean equals IgnoreCase(String anotherString)：与equals方法类似，忽略大小写
 * String concat(String str)：将指定字符串连接到此字符串的结尾。等价于用“+”
 * int compareTo(String anotherString)：比较两个字符串的大小
 * String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
 * String substring[int beginIndex,int endIndex)：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 */

public class StringMethodTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringMethodTest stringMethodTest = new StringMethodTest();
        stringMethodTest.method5();
    }

    public void method1() {
        String s1 = "Hello World";

        System.out.println("-------1-------\n" + s1.length());

        System.out.println("-------2-------\n" + s1.charAt(2));

        System.out.println("-------3-------\n" + s1.isEmpty());

        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();
        System.out.println("-------4-------\n" + s1);
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "  Hello World  ";
        String s5 = s1.trim();
        System.out.println("-------5-------\n" + s5);

        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));

        String s6 = "hello world";
        System.out.println("-------6-------\n" + s1.equalsIgnoreCase(s6));

        String s7 = "abc";
        String s8 = "abf";
        System.out.println("-------7-------\n" + s7.compareTo(s8));

        System.out.println(s1.substring(2));
        System.out.println(s1.substring(2,4));

    }
    /**
     * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     * boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
     * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
     * int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     * int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     * int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     * int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
     *
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */

    public void method2(){
        String s2 = "Hello World";
        System.out.println(s2.endsWith("ld"));
        System.out.println(s2.startsWith("Hell"));
        System.out.println(s2.startsWith("ello",1));
        System.out.println(s2.contains("o"));
        System.out.println(s2.indexOf("l"));
        System.out.println(s2.lastIndexOf("l"));


    }
    /**
     * 替换：
     * String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     * String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     * String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     * String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     *
     * 匹配:
     * boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     *
     * 切片：
     * String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     * String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     *
     */
    public void method3(){
        String s3 = "Hello World";
        String s4 = s3.replace('H','h');
        System.out.println(s4);
        String s5= s3.replace("World","Java");
        System.out.println(s5);



    }
    /**
     * String 与 char[]之间的转换
     *
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    public void method4(){
        String str1= "abc123";
        char[] charArray = str1.toCharArray();
        for(int i=0;i<charArray.length;i++){
            System.out.println(charArray[i]);
        }
        char[] arr = new char[]{'w','o','r','l','d'};
        String str2= new String(arr);
        System.out.println(str2);
    }

    /**
     * String 与 byte[]之间的转换
     *
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     *
     * 编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     *
     */
    public void method5() throws UnsupportedEncodingException {
        String str1="abc123编码集“";
        byte[] bytes = str1.getBytes();//使用默认的字符编码集，进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("**************解码***************");
        String str2 = new String(bytes);  //对bytes进行解码
        System.out.println(str2);

        String str3 = new String(gbks);  //编码集与解码集不一致
        System.out.println(str3);

        String str4 = new String(gbks,"gbk");  //使用gbk解码
        System.out.println(str4);
    }


}
