package reflection.demo2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TAN00XU
 * @date 2022/09/16 18:29
 */
public class TestReflect5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");
        for (Method method : aClass.getMethods()) {
            System.out.println(method);
        }
        System.out.println("------------------");
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("------------------");
        Method method = aClass.getMethod("method1");
        Object o = aClass.getConstructor().newInstance();
        method.invoke(o);

        System.out.println("------------------");
        Method declaredMethod = aClass.getDeclaredMethod("method2", String.class);
        declaredMethod.invoke(o, "String");

        System.out.println("------------------");
        Method method3 = aClass.getMethod("method3", String.class, int.class);
        System.out.println(method3.invoke(o, "String", 1));

        System.out.println("------------------");
        Method function = aClass.getDeclaredMethod("function");
        function.setAccessible(true);
        function.invoke(o);

    }
}
