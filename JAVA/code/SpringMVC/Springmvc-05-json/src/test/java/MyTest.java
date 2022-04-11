import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tan00xu.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        User user0 = new User("饮梦0", 18, "男");
        User user1 = new User("饮梦1", 18, "男");
        User user2 = new User("饮梦2", 18, "男");
        User user3 = new User("饮梦3", 18, "男");
        User user4 = new User("饮梦4", 18, "男");

        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        /*==============================================================*/
        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>\n"+str1);

        String str2 = JSON.toJSONString(user0);
        System.out.println("JSON.toJSONString(user1)==>\n"+str2);

        /*==============================================================*/
        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>\n"+jp_user1);

        /*==============================================================*/
        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>\n"+jsonObject1.getString("name"));

        /*==============================================================*/
        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>\n"+to_java_user);
    }
}
