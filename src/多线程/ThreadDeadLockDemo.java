package 多线程;

/**
 *1.死锁的理解： 不同的线程分别占用对方需要的同步资源不放弃
 * 都在等待对方放弃自己需要的同步资源，形成线程的死锁
 * 说明：死锁后不会出现异常也不会出现提示，所有线程处于阻塞状态
 *
 * 演示死锁问题,线程锁s1执行后，阻塞1秒，线程2会执行锁2，线程1就无法执行锁2，线程2也无法执行锁1
 */
public class ThreadDeadLockDemo {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append('a');
                    s2.append('1');
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2) {
                        s2.append('b');
                        s1.append('2');
                        System.out.println(s1);
                        System.out.println(s2);
                    }

                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append('c');
                    s2.append('3');

                    synchronized (s1) {
                        s2.append('d');
                        s1.append('4');
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }

        }).start();
    }
}
