package homework;

import java.util.function.Consumer;

/**
 * Consumer类
 *
 * @author TAN00XU
 * @date 2022/09/18 12:19
 */
public class ConsumerPractice {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};
        printInfo(
                strArray,
                str -> System.out.print("姓名：" + str.split(",")[0]),
                str -> System.out.println(",年龄：" + Integer.parseInt(str.split(",")[1]))
        );


    }

    private static void printInfo(String[] strArray, Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String str : strArray) {
            consumer1.andThen(consumer2).accept(str);
        }
    }
}
