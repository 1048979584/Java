package IO;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class io {
    public static void main(String[] args) throws IOException {
//        test();
//        test1(new File("C:\\Users\\qiuwei\\Desktop\\bug截图"));
//        test2(new File("C:\\Users\\qiuwei\\Desktop\\bug截图\\1.png"));
        getDirectorySize(new File("C:\\Users\\qiuwei\\Desktop\\bug截图"));
    }

    /**
     * 指定目录下创建文件
     */
    public static void test() throws IOException {
        File file = new File("D:\\java\\Java\\src\\IO\\hi.txt");
        //创建文件与hi.txt目录同级
        File newFile = new File(file.getParent(),"haha.txt");
        boolean isTure = newFile.createNewFile();
        if(isTure){
            System.out.println("创建成功");
        }else{
            System.out.println("文件已存在");
        }
    }
    /**
     *  输出指定目录下所有以.jpg文件结尾的文件
     */

    public static List test1(File f) {
        //如果输入的file对象是文件则直接输出
        String[] list = f.list();
        List pngList = new ArrayList();
        if (list.length > 0) {
            for (String str : list) {
                if (str.endsWith(".png")) {
                    pngList.add(str);
                }
            }
            return pngList;
        }
        return null;
    }

    /**
     * 遍历指定目录所有文件名称，包括子文件目录中的文件。
     */
    public static void test2(File file3) {
        List list3 = new ArrayList();
        if (file3.isFile()) {
        } else {
            File[] files = file3.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f);
                } else {
                    test1(f);  //使用递归调用
                }
            }
        }

    }




    //删除指定目录，目录下没有文件才能删除成功，也使用递归的方法。如果对象是文件直接删除，如果对象是目录则展开，判断每一个对象，如果是文件则直接删除，如果是目录再次展开
    public void deleteDirectory(File f){
        if(f.isFile()){
            f.delete();
        }else{
            File[] list = f.listFiles();
            for(File f2:list){deleteDirectory(f2);
            }
        }
    }

    //求任意一个总目录的大小
    public static long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] all = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);// f的大小;
            }
        }
        System.out.println(size);
        return size;
    }




}
