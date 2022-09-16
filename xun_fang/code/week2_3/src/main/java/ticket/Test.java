package ticket;

/**
 * 测试类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }

}
