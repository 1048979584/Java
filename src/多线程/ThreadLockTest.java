package 多线程;
/**
 * 解决线程安全问题的方式三：lock锁
 * synchronized 与 lock的异同
 * 相同：两者都可以解决安全问题
 * 不同synchronized机制在执行完相应的代码后，自动的释放同步监视器
 * lock需要手动启动lock，结束时也需要手动实现
 * 优先使用顺序：lock》同步代码块》同步方法
 */

import java.util.concurrent.locks.ReentrantLock;

class window implements Runnable {
    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            try {
                //2.调用锁定方法lock
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                    ticket--;
                } else break;
            } finally {
                //3.调用解锁方法unlock
                lock.unlock();
            }
        }

    }
}

public class ThreadLockTest {
    public static void main(String[] args) {
        window w1 = new window();
        Thread thread1 = new Thread(w1);
        Thread thread2 = new Thread(w1);
        Thread thread3 = new Thread(w1);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
