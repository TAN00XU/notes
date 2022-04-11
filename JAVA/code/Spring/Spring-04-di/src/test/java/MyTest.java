import com.tan00xu.pojo.Student;
import com.tan00xu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
    /*
    Student{
        name='饮梦',
        address=Address{address='中国'},
        books=[西游记, 红楼梦, 水浒传, 三国演义],
        hobbys=[听歌, 游戏, 敲代码],
        card={姓名=饮梦, 性别=男},
        games=[JAVA, Python, C],
        wife='null',
        info={
            学号=2022,
            地址=四川
            }
        }

     */

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user2",User.class);
        System.out.println(user);

    }
}
