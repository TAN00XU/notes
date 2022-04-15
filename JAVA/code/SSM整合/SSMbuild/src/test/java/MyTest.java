import com.tan00xu.dao.BookMapper;
import com.tan00xu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
       /* char a = '\u4e00';
        char b = '\u9fa5';
        while (a <= b) {
            System.out.print(a);
            System.out.println(Integer.toHexString(a));
            System.out.println(Integer.hashCode(a));
            a++;
        }*/
        String regex = "[\u4E00-\u9FA5]{2,10}";
        String regex1 = "^[\u4E00-\u9FA5]{2,5}(.[\u4E00-\u9FA5]{2}){0,2}$";
        String regex2 = "[A-Za-z0-9_]";
        String regex3 = "^a(?=bb).*";
        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.println("请输入：");
            String name = sc.next();
            System.out.println(name.matches(regex3));

//            sc.close();
        }

    }

    @Test
    public void test(){

    }


}



