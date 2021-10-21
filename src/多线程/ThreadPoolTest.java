package 多线程;

/**
 * JDK 5.0起提供了线程池相关API：ExecutorService和Executors
 * ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
 *
 * void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行Runnable
 * Future submit(Callable task)：执行任务，有返回值，一般又来执行Callable
 * void shutdown()：关闭连接池
 * Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 *
 * Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
 * Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
 * Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池
 * Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。

 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumberTest implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumberTest2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池，public interface ExecutorService extends Executor {}
        ExecutorService service = Executors.newFixedThreadPool(10);

        // public interface ExecutorService extends Executor {}
        // public abstract class AbstractExecutorService implements ExecutorService {}
        // public class ThreadPoolExecutor extends AbstractExecutorService {}    >>ThreadPoolExecutor  --  ExecutorService
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //2.执行指定的线程操作，需要提供Runable的接口或Callable接口实现类的对象
        service.execute(new NumberTest()); //适合于Runable
        service.execute(new NumberTest2());//适合于Callable
//        service.submit();

        //3.关闭连接
        service.shutdown();

    }
}
