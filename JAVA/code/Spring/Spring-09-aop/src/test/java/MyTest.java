import com.tan00xu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口，所以要获取接口的实现类然后强制转换为接口
        UserService userService = (UserService) context.getBean("userService");

        userService.delete();
    }
}
