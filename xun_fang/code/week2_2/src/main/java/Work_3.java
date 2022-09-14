import java.io.*;
import java.util.ArrayList;

/**
 * 序列化与反序列化
 *
 * @author TAN00XU
 * @date 2022/09/13 18:51
 */
public class Work_3 {
    public static final File FILE = new File("user.txt");


    /**
     * 反序列化
     */
    public static void deserialization() {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(FILE));
            ArrayList<User> users = (ArrayList<User>) input.readObject();
            users.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 序列化
     */
    public static void serialization() {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三", "18", "男"));
        users.add(new User("李四", "19", "女"));
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILE, true));
            out.writeObject(users);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        serialization();
        deserialization();
    }

}
