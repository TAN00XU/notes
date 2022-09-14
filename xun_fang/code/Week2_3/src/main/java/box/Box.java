package box;

/**
 * 箱子类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class Box {
    private int milk;
    private boolean state = false;

    /**
     * 装入
     *
     * @param milk 牛奶
     */
    public synchronized void put(int milk) {
        //没有牛奶就等待
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.milk = milk;
        System.out.println("生产者将第" + milk + "瓶放入奶箱");
        //生产完毕后修改奶箱状态
        state = true;
        //唤醒其他线程
        notifyAll();
    }

    /**
     * 得到
     */
    public synchronized void get() {
        //如果没有牛奶就等待
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者将第" + milk + "瓶取出奶箱");

        //生产完毕后修改奶箱状态
        state = false;
        //唤醒其他线程
        notifyAll();
    }
}
