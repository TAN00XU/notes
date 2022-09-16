package reflection.demo1;

/**
 * 测试反射类
 *
 * @author TAN00XU
 * @date 2022/09/16
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        Class<Student> studentClass1 = Student.class;
        System.out.println(studentClass == studentClass1);
        System.out.println("------------------");

        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass);
        System.out.println("------------------");

        Class<?> aClass1 = Class.forName("reflection.demo1.Student");
        System.out.println(studentClass == aClass1);
    }
}
