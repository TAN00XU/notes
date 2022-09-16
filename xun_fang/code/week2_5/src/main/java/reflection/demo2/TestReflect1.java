package reflection.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author TAN00XU
 * @date 2022/09/16 16:20
 */
public class TestReflect1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class, String.class);

        Object o = constructor.newInstance("学习", 18, "四川");
        System.out.println(o);


    }
}
