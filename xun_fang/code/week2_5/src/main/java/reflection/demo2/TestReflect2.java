package reflection.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author TAN00XU
 * @date 2022/09/16 16:25
 */
public class TestReflect2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        //暴力反射
//        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance("学习");
        System.out.println(o);

    }
}
