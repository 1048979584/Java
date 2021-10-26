package IO;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

/**
 * File类的使用
 * 1.File类的一个对象，代表一个文件或一个文件目录
 * 2.File类声明在java.io包下
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        FileTest fileTest =new FileTest();
        fileTest.test3();
    }
    /**
     * 1.如何创建File类的实例
     *      File(String filePath):以filePath为路径创建File对象，可以是绝对路径或者相对路径
     *      File(String parentPath,String chilePath)：以parentPath为父路径，childPath为子路径创建File对象
     *      File(File parentFile,String childPath)；根据一个父File对象和子文件路径创建File对象
     *
     */
    public void test(){
        //构造器1：
        File file1 = new File("hello.txt");//相当于当前module
        File file2 =new File("D:\\java\\num.txt");
        System.out.println(file1.exists());
        System.out.println(file2);  //返回路径
        //构造器2：
        File file3 = new File("D:\\java","files"); //文件夹路径
        System.out.println(file3);
        //构造器3：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    public void test2(){
        File file1 = new File("hello.txt");
        //获取绝对路径
        System.out.println(file1.getAbsoluteFile());
        //获取路径
        System.out.println(file1.getPath());
        //获取名称
        System.out.println(file1.getName());
        //获取上层文件目录
        System.out.println(file1.getParent());
        //获取文件长度
        System.out.println(file1.length());
        //获取最后一次的修改时间，毫秒值
        System.out.println(file1.lastModified());
        System.out.println(new Date(file1.lastModified()));
        //判断是否为文件目录
        System.out.println(file1.isDirectory());
        //判断是否为文件
        System.out.println(file1.isFile());

        //如下的两个方法适用于文件目录：
        //public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
        //public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
        File file2 = new File("C:\\Program Files (x86)\\Microsoft");  //指定文件一定要存在
        String[] fileList = file2.list();
        for(String f : fileList){
            System.out.println(f);
        }
        File[] files = file2.listFiles();
        for(File f:files){
            System.out.println(f);
        }

        /**
         * File类重命名功能
         * public boolean renameTo(File desc):把文件重命名为指定文件路径,相当于移到并重命名文件
         *      比如：file1.renameTo(file2)为例
         *      要想保证返回为true，要保证file1在文件中存在，在file2中不存在
         *
         */
        File file3 = new File("D:\\java\\hello.txt");
        File file4 = new File("D:\\java\\Java\\src\\IO\\hi.txt");
        boolean bool = file3.renameTo(file4);
        System.out.println(bool);
    }

    public void test3() throws IOException {
        //创建文件，若文件存在，则不创建。若不创建返回false
        //创建文件目录，如果此文件目录存在则不创建。如果上层目录不存在，也不创建
        //创建文件目录，如果文件目录存在则不创建，如果上层目录不存在，一并创建
        File file = new File("newFile.txt");
        if (!file.exists()) {
            System.out.println(file.createNewFile());
            System.out.println("创建成功");
        }else {
            System.out.println(file.delete());
            System.out.println("删除成功");
        }
        File file2 = new File("D:\\java\\Java\\src\\IO\\IO1");
        boolean isTure = file2.mkdir();
        if(isTure){
            System.out.println("文件目录mkdir成功");
        }else{
            System.out.println("文件目录mkdir失败");
            file2.delete();
        }
        File file3 = new File("D:\\java\\Java\\src\\IO\\IO2\\IO3");
        boolean isTure2 = file3.mkdirs();
        if(isTure2){
            System.out.println("文件目录mkdirs成功");
        }else{
            System.out.println("文件目录mkdirs失败");
            file3.delete();
        }
    }
}
