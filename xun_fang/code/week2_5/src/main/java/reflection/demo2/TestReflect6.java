package reflection.demo2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 越过泛型检查
 *
 * @author TAN00XU
 * @date 2022/09/16 19:01
 */
public class TestReflect6 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> arrayList = new ArrayList<>();
        Class<? extends ArrayList> aClass = arrayList.getClass();
        Method add = aClass.getMethod("add", Object.class);
        Object hello = add.invoke(arrayList, "hello");
        Object world = add.invoke(arrayList, "world");
        System.out.println(arrayList);


    }
}
