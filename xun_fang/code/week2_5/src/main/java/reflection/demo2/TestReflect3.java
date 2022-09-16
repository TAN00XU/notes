package reflection.demo2;

import reflection.demo1.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 成员变量
 *
 * @author TAN00XU
 * @date 2022/09/16 16:34
 */
public class TestReflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.demo1.Student");
        for (Field field : aClass.getFields()) {
            System.out.println(field);
        }
        System.out.println("--------------");
        for (Field declaredField : aClass.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("--------------");
        Field address = aClass.getField("address");
        //获取无参构造函数
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        address.set(o, "四川");
        System.out.println(o);

//        Student student = new Student();


    }
}
