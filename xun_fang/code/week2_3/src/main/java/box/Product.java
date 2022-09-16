package box;

/**
 * 生产者类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Product implements Runnable {
    private final Box box;

    public Product(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            box.put(i);
        }
    }
}
