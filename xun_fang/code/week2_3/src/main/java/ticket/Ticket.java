package ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 票类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Ticket implements Runnable {
    private static int tickets = 50;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "票");
                    tickets--;
                }
            } finally {
                lock.unlock();
            }

        }
    }


    //    @Override
//    public void run() {
//        while (true) {
//            sellTicket();
//        }
//    }
//
//    private static synchronized void sellTicket() {
//        if (tickets > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在出售第" +
//                    tickets + "张票");
//            tickets--;
//        }
//    }
//    private Object obj = new Object();
//
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (obj) {
//                if (tickets > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(
//                            Thread.currentThread().getName() +
//                                    "正在出售第" + tickets + " 张票"
//                    );
//                    tickets--;
//                }
//            }
//
//        }
//    }
}
