package 多线程.经典例题;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 存在问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到
 * 消费者比生产者快时，消费者会取到相同的数据
 * <p>
 * 分析：
 * 1.是否是多线程的问题？是，生产者的线程，消费者的线程
 * 2.是否有共享数据的问题？是，店员、产品、产品数
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及线程的通信？是
 *
 *
 */

//店员控制产品数量（共享数据）
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() throws InterruptedException {
        if (productCount < 20) {
            productCount++;
            //当生产第10个产品后，可能由于出现阻塞，消费者同步消费了一个，此时打印就会显示生产第9个，线程安全问题
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");
            Thread.sleep(1000);
            notifyAll();
        } else {
            wait();
        }
    }

    public synchronized void consumeProduct() throws InterruptedException {
        if (productCount > 0) {
            productCount--;
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            notifyAll();
        } else {
            wait();
        }
    }
}

//生产者，只负责生产
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品");
        while (true) {
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者，只负责消费
class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.consumeProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        //生产者使用同步监视器clerk.produceProduct()
        //消费者使用同步监视器clerk.consumeProduct()
        //两个监视器（同步方法）都同属于对象clerk，因此生产者线程在调用clerk.produceProduct()，不会出现消费者同步调用clerk.consumeProduct()

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        Customer c1 = new Customer(clerk);
        c1.setName("消费者1");
        Customer c2 = new Customer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();

    }
}
