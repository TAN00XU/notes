package TestThread;

/**
 * 自定义线程类
 *
 * @author TAN00XU
 * @date 2022/09/14
 */
public class MyThread extends Thread {
    private int userId;
    private String username;


    public void show() {
        System.out.println(this.userId + "=======" + this.username);
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
