package homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流收集器类
 *
 * @author TAN00XU
 * @date 2022/09/18
 */
public class StreamCollector {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("谭旭");
        arrayList.add("余家海");
        arrayList.add("易剑波");
        arrayList.add("明波");
        arrayList.add("古骏椿");
        Stream<String> listStream = arrayList.stream().filter(s -> s.length() == 3);
        List<String> collect = listStream.collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("-------------------------------");

        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        Stream<Integer> integerStream = set.stream().filter(age -> age > 30);
        Set<Integer> collect1 = integerStream.collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("-------------------------------");

        String[] strArray = {"张三,18", "李四,28", "王五,38", "赵六,48"};
//        Stream<String> stringStream = Arrays.stream(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 30);
        Stream<String> stringStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 30);
        System.out.println("-------------------------------");

        Map<String, Integer> map = stringStream.collect(Collectors.toMap((s -> s.split(",")[0]), s -> Integer.parseInt(s.split(",")[1])));
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.printf("%s : %d\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
        System.out.println("-------------------------------");
        for (String s : map.keySet()) {
            System.out.printf("%s : %d\n", s, map.get(s));
        }


    }
}
