import com.tan00xu.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        //获取ApplicationContext 拿到Spring容器
        //解析beans.xml文件，生成管理相应的bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在Spring中管理了，我们要使用就直接去里面取出来就可以
        //getBean : 参数为Spring配置文件中bean的id
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
