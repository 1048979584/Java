package IO;

import java.io.*;

public class testFileInputOutputStream {
    public static void main(String[] args) {
        bufferedTest();
    }
    /**
     * 使用fileInputSteeam和fileOutputStream读写非文本文件
     */
    public static void test() {
        FileInputStream fip = null;
        FileOutputStream fop = null;
        try {
            //1.指明需要复制和写入的File对象
            File copyf = new File("D:\\java\\Java\\src\\IO\\头像.png");
            File pastf = new File("D:\\java\\Java\\src\\IO\\头像copy2.png");
            //2.提供FileReader和FileWriter对象
            fip = new FileInputStream(copyf);
            fop = new FileOutputStream(pastf);
            //3.写入读取文件
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fip.read(bytes)) != -1) {
                fop.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            if (fip != null) {
                try {
                    fip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fop != null) {
                try {
                    fop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 处理流之一：缓冲流的使用
     * 1.缓冲流,字节流
     * BufferInputStream
     * BufferOutputStream
     */

    public static void BufferedStreamTest(){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try {
            //1.造文件对象
            File cf = new File("D:\\java\\Java\\src\\IO\\头像.png");
            File pf = new File("D:\\java\\Java\\src\\IO\\头像copy3.png");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(cf);
            fos = new FileOutputStream(pf);
            //2.2造缓冲流
            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);

            //3.复制的细节：读取，写入
            int len;
            byte[] bytes = new byte[1024];
            while((len=bfis.read(bytes))!=-1){
                bfos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        //4.资源关闭，要求先关闭外层流再关闭内层流，关闭外层流时内层流会自动关闭
        if(bfis!=null){
            try {
                bfis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bfos!=null){
            try {
                bfos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *  2.使用字符缓冲流实现文本复制
     *  BufferedRead
     *  BufferedWriter
     */
    public static void bufferedTest(){
        BufferedReader br =null;
        BufferedWriter bw =null;
        try {
            //1.造文件对象
            File cf = new File("D:\\java\\Java\\src\\IO\\hi.txt");
            File pf = new File("D:\\java\\Java\\src\\IO\\hicopy.txt");
            //2.造流
            //2.1造节点流
            FileReader fr = new FileReader(cf);
            FileWriter fw = new FileWriter(pf,true);
            //2.2造缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //3.复制的细节：读取，写入
//            int len;
//            char[] chars = new char[1024];
//            while((len=br.read(chars))!=-1){
//                bw.write(chars,0,len);
//            }
            String data;
            while((data = br.readLine())!=null){
//                bw.write(data);   //data不包含换行符
                //提供换行方式一
//                bw.write(data+'\n');
                //方式二
                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
