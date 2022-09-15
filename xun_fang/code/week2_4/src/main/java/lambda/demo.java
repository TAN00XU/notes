package lambda;

/**
 * @author TAN00XU
 * @date 2022/09/15 15:07
 */
public class demo {
    public static void main(String[] args) {
        Num num = (a, b) -> a * b;
        System.out.println(num.add(2, 3));

        Num num1 = Integer::sum;
        System.out.println(num1.add(2, 3));

    }
}
