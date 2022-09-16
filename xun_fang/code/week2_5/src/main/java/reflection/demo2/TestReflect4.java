package reflection.demo2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 成员变量练习
 *
 * @author TAN00XU
 * @date 2022/09/16 16:45
 */
public class TestReflect4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");
        Object o = aClass.getConstructor().newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "学习");
        System.out.println(o);

    }
}
