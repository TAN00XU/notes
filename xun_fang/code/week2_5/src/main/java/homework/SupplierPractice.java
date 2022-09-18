package homework;

import java.util.function.Supplier;

/**
 * Supplier练习类
 *
 * @author TAN00XU
 * @date 2022/09/18 12:06
 */
public class SupplierPractice {
    public static void main(String[] args) {
        int[] arr = {11, 9, 65, 75, 23, 45, 11, 99};
        int maxValue = getMax(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println(maxValue);

    }

    public static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

}
