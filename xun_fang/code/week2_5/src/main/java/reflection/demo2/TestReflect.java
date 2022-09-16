package reflection.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author TAN00XU
 * @date 2022/09/16 15:55
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");

        //得到公共的构造函数
//        Constructor<?>[] constructors = aClass.getConstructors();
//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
//        }
        //得到所有的构造函数
        for (Constructor<?> declaredConstructor : aClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println("--------------------");

        Constructor<?> constructor = aClass.getConstructor();
        //        System.out.println(constructor);

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
//        System.out.println(declaredConstructor);
        Object o = constructor.newInstance();
        System.out.println(o);

    }
}
