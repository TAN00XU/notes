package reflection.demo1;

/**
 * 学生类
 *
 * @author TAN00XU
 * @date 2022/09/16
 */
public class Student {

    /**
     * 名字
     */
    private String name;
    int age;
    /**
     * 地址
     */
    public String address;

    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //成员方法：一个私有，四个公共

    private void function() {
        System.out.println("function private");
    }

    public void method1() {
        System.out.println("method1 public");
    }

    public void method2(String s) {
        System.out.println("method2 public =>" + s);
    }

    public String method3(String s, int i) {
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
