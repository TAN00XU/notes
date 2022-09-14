package box;

/**
 * 消费者类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Customer implements Runnable {
    private final Box box;

    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.get();
        }
    }
}
