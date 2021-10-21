package 多线程;

/**
 * 01、程序、进程、线程
 * 程序(program)：为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象。
 * 进程(process)：程序的一次执行过程，或是正在运行的一个程序。是一个动态的过程：有它自身的产生、存在和消亡的过程。——生命周期。
 * 线程(thread)，进程可进一步细化为线程，是一个程序内部的一条执行路径。
 * 1.1、进程与线程
 * 一个Java应用程序java.exe，其实至少有三个线程：main()主线程，gc()垃圾回收线程，异常处理线程。当然如果发生异常，会影响主线程。
 * 1.2、何时需要多线程
 * 程序需要同时执行两个或多个任务。
 * 程序需要实现一些需要等待的任务时，如用户输入、文件读写操作、网络操作、搜索等。
 * 需要一些后台运行的程序时。
 * 02、线程的创建和使用
 * 2.1、线程的创建和启动
 * Thread类的特性
 * 每个线程都是通过某个特定Thread对象的run()方法来完成操作的，经常把run()方法的主体称为线程体
 * 通过该Thread对象的start()方法来启动这个线程，而非直接调用run()
 * 2.2、Thread类
 * Thread()：创建新的Thread对象
 * Thread(String threadname)：创建线程并指定线程实例名
 * Thread(Runnabletarget)：指定创建线程的目标对象，它实现了Runnable接口中的run方法
 * Thread(Runnable target, String name)：创建新的Thread对象
 *
 *
 */


/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run()方法 ---> 将此线程的方法声明在run()中
 * 3.创建Thread类的子对象
 * 4.通过此对象调用start()
 *
 * 例子:遍历100以内的所有的偶数
 */


//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //重写Thread类的run()
    @Override
    public void run() {
        for(int i = 1;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start():①启动当前线程 ②调用当前线程的run()
        t1.start();
        //问题1:我们不能通过直接调用run()的方式启动线程。
//        t1.run();

        //问题二:再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。会报IllegalThreadStateException
//        t1.start();
        //我们需要重现创建一个线程的对象，去start().
        MyThread t2 = new MyThread();
        t2.start();

        //如下操作仍在main线程中执行的
        for(int i = 1;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***main()***");
            }
        }
    }
}

