package homework;

import java.util.function.Function;

/**
 * Function练习类
 *
 * @author TAN00XU
 * @date 2022/09/18
 */
public class FunctionPractice {
    public static void main(String[] args) {
        String s = "林青霞,30";
        convert(
                s,
                ss -> ss.split(",")[1],
                Integer::parseInt,
                i -> i + 70
        );
    }

    public static void convert(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        int i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(i);
    }

}
