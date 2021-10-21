package 多线程;

/**
 * 使用同步机制   将单例模式中的懒汉模式改为线程安全
 */
public class ThreadTest3 {
    public static void main(String[] args) {

    }
}


class bank {
    private bank() {
    }

    private static bank instance = null;

    private static bank getInstance() {
//效率稍低
//        synchronized (bank.class) {
//            if (instance == null) {
//                instance = new bank();
//            }
//            return instance;
//        }
//效率较高
        if (instance == null) {
            if (instance == null) {
                instance = new bank();
            }
        }
        return instance;
    }
}

