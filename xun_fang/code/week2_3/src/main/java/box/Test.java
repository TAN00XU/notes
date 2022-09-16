package box;

/**
 * 测试类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Test {
    public static void main(String[] args) {
        Box box = new Box();
        new Thread(new Product(box)).start();
        Thread thread = new Thread(new Customer(box));
        thread.setDaemon(true);
    }
}
