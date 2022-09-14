import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * @author TAN00XU
 * @date 2022/09/13 17:10
 */
public class Work_4 {

    public static final File FILE = new File("files/game.properties");

    public static void main(String[] args) throws IOException {
        if (!FILE.exists()) {
            GuessNumber.start();
        } else {
            Properties properties = new Properties();
            FileReader fileReader = new FileReader(FILE);
            properties.load(fileReader);
            fileReader.close();
            int count = Integer.parseInt(properties.getProperty("count"));
            if (count >= 3) {
                System.out.println("游戏试玩已结束，想玩请充值(www.itcast.cn)");
            } else {
                GuessNumber.start();
            }
        }
    }
}

class GuessNumber {
    public static final File FILE = new File("files/game.properties");

    public static void start() throws IOException {
        init();
        System.out.println("=====游戏开始=====");
        game();
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(FILE);
        properties.load(fileReader);
        fileReader.close();
        int count = Integer.parseInt(properties.getProperty("count"));
        count++;
        properties.setProperty("count", String.valueOf(count));
        FileWriter fileWriter = new FileWriter(FILE);
        properties.store(fileWriter, "第 " + count + " 次");
        fileWriter.close();
    }

    public static void game() {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请在1-100之间猜数字\n0 退出游戏");
        while (true) {
            System.out.println("请输入猜测的数：");
            int toGuess = scanner.nextInt();
            if (toGuess == 0) {
                break;
            }
            if (toGuess > num) {
                System.out.println("猜大了");
            } else if (toGuess < num) {
                System.out.println("猜小了");
            } else {
                System.out.println("猜对了！");
                break;
            }

        }
    }

    public static void init() throws IOException {
        if (!FILE.getParentFile().exists()) {
            FILE.getParentFile().mkdirs();
            FILE.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("count", "0");

            FileWriter fileWriter = new FileWriter(FILE);
            properties.store(fileWriter, "初始化");
        }
    }

}