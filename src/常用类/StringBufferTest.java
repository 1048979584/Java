package 常用类;
/**
 * String、StringBuffer、StringBuilder三者的异同？
 *
 * String:不可变的字符序列；底层使用char[]存储
 * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
 * StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储
 *
 */


public class StringBufferTest {
    public static void main(String[] args) {
        StringBufferTest sbt = new StringBufferTest();
        sbt.test3();
    }
    /**
     * StringBuffer的常用方法：
     *
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
     * StringBuffer delete(int start,int end)：删除指定位置的内容
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     * public int indexOf(String str)
     * public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
     * public int length()
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     *
     * 总结：
     *     增：append(xxx)
     *     删：delete(int start,int end)
     *     改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
     *     查：charAt(int n )
     *     插：insert(int offset, xxx)
     *     长度：length();
     *     遍历：for() + charAt() / toString()
     *
     */

    public void test2(){
        StringBuffer str = new StringBuffer("abc");
        str.append(1);
        str.append('3');
        System.out.println(str);
        str.delete(1,3);
        System.out.println(str);
        System.out.println(str.charAt(0));
        str.insert(1,'m');
        System.out.println(str);
        System.out.println(str.length());
    }
    /**
     * 对比String、StringBuffer、StringBuilder三者的效率：
     * 从高到低排列：StringBuilder > StringBuffer > String
     *
     */
    public void test3() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}
