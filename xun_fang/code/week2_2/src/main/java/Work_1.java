import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 文件到集合
 *
 * @author TAN00XU
 * @date 2022/09/13 17:56
 */
public class Work_1 {

    /**
     * 文件到集合
     *
     * @param path 路径
     */
    public static void fileToList(String path) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            ArrayList<User> users = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                User user = new User();
                user.setName(split[0]);
                user.setAge(split[1]);
                user.setGender(split[2]);
                users.add(user);
            }
            bufferedReader.close();
            users.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
