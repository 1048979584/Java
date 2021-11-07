package IO;


import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流
 * 2.数据的流向：输入流、输出流
 * 3.数据的角色：节点流，处理流
 * 二、流的体系结构
 * 抽象基类     节点流（或文件流）                                       缓冲流（处理流的一种）
 * InputStream  FileInputStream(read(byte[] buffer))                  BufferedInputStream(read(byte[] buffer))
 * OutputStream FileOutputStream(write(byte[] buffer,0,len)           BufferedOutputStream(write(byte[] buffer,0,len)
 * Reader       FileReader(read(char[] cbuf)                          BuferedReader(read(char[] cbuf)
 * Writer       FileWriter(write(char[] cbuf,o,len)                   BufferedWriter(write(char[] cbuf,o,len)
 */

public class FileReaderWriterTest {
    public static void main(String[] args) throws IOException {
        test4("头像.png","头像copy.png");
    }
    /**
     * 1.read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
     * 2.异常处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
     * 3.读入的文件一定要存在，否则会报FileNotFoundException
     */
    public static void test1() {
        FileReader fr = null;
        try {
            //1.实例化File对象，指明要操作的文件
            File f =new File("D:\\java\\Java\\src\\IO\\hi.txt");
            //2.提供具体的流
            fr = new FileReader(f);
            //3.数据的读入过程,一次读入一个字符
            int data;
            while((data=fr.read()) !=-1){
                System.out.print((char)data); //将字节转换为字符并输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            if(fr !=null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * 对read()升级操作：使用read重载方法
     */
    public static void test2(){
        FileReader fr = null;
        try {
            //1.实例化File对象，指明要操作的文件
            File f =new File("D:\\java\\Java\\src\\IO\\hi.txt");
            //2.提供需要操作的流
            fr = new FileReader(f);
            // 3.数据读入
            char[] chars =new char[5];
            //3.1 read(char[] cbuf):返回每次读入cbuf数组中的字符个数，如果达到文件末尾，返回-1
            int len;
            while((len=fr.read(chars))!=-1){
//                for(int i=0;i<len;i++){
//                    System.out.print(chars[i]);
//                }
                //另外一种输出方法
                String str = new String(chars,0,len);
                System.out.print(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭数据流
            if(fr !=null) {
                try {
                    fr.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 从内存中写入数据到硬盘文件
     * 说明：
     * 1.输入操作，对应的File文件可以不存在，并不会报异常
     * 2.
     *      File对应的硬盘中如果文件不存在，在输出过程中会自动创建
     *      FileWriter(file,false)/FileWriter(file):对源文件覆盖
     *
     */
    public static void test3(){
        FileWriter fw = null;
        try {
            //1.提供File对象，指明写入对象
            File f = new File("D:\\java\\Java\\src\\IO","hi2.txt");
            //2.提供fileWriter对象，用于数据写出
            fw = new FileWriter(f,false);
            //3.写出操作
            fw.write("I have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源关闭
            if(fw !=null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * 使用FileReader和FileWriter实现文本的复制
     * 1.对于文本文件（.txt,.java,.c,.cpp）使用字符流处理
     * 2.对于非文本文件（.jpg，.png，.doc 等）使用字节流处理
     */
    public static void test4(String cf,String pf) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.指明需要复制和写入的File对象
            File copyf = new File("D:\\java\\Java\\src\\IO\\"+cf);
            File pastf = new File(copyf.getParent(),pf);
            //2.提供FileReader和FileWriter对象
            fr = new FileReader(copyf);
            fw = new FileWriter(pastf);
            //3.写入读取文件
            int len;
            char[] chars = new char[5];
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
