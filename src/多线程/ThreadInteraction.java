package 多线程;

/**
 * 创建三个线程交替打印1-100
 *
 * 1.wait()：一旦执行此方法，当前线程就会进入阻塞状态并释放同步监视器
 * 2.notify()：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，则唤醒优先级高的
 * 3.notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程。
 * 说明：
 * 1.wait()、notify()、notifyAll()三个方法使用在同步代码块或同步方法中。
 * 2.wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的监视器
 *  否则报错，java.lang.IllegalMonitorStateException
 * 3.wait()、notify()、notifyAll()三个方法定义在java.lang.Object类中。
 *
 *sleep和wait的异同
 * 1.相同点：一旦执行方法，都可以使得当前线程进入阻塞
 * 2.不同点：
 * 1》声明位置不同：sleep声明在Tread中，wait声明在Object中
 * 2》调用的要求不同：sleep()可以在任何场景下使用，wait()必须在同步代码块或同步方法中使用
 * 3》释放同步监视器：如果两个方法都使用在同步代码块或同步方法中sleep()不会释放锁，wait会释放锁
 */
class Number implements Runnable {
    private int number = 1;

    @Override

    public void run() {
        while (true) {

            synchronized (this) {
                //2.使用notify唤醒被wait的线程
                this.notifyAll();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //1.使用wait使当前线程进入阻塞并释放监视器
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}

public class ThreadInteraction {
    public static void main(String[] args) {
        Number num = new Number();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);
        Thread t3 = new Thread(num);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}
