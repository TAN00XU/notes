package homework;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Predicate练习类
 *
 * @author TAN00XU
 * @date 2022/09/18 12:32
 */
public class PredicatePractice {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖贤,33"};
        ArrayList<String> array = myFilter(
                strArray,
                s -> s.split(",")[0].length() > 2,
                s -> Integer.parseInt(s.split(",")[1]) > 33
        );
        array.forEach(System.out::println);

    }

    private static ArrayList<String> myFilter(String[] strArray, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> array = new ArrayList<String>();
        for (String str : strArray) {
            if (pre1.and(pre2).test(str)) {
                array.add(str);
            }
        }
        return array;
    }

}
