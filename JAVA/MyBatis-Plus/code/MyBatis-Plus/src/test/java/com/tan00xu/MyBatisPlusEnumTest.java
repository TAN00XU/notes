package com.tan00xu;

import com.tan00xu.entity.User;
import com.tan00xu.enums.GenderEnum;
import com.tan00xu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author TAN00XU
 * @date 2022/09/20 19:35
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum() {
        User user = new User();
        user.setName("user");
        user.setAge(11);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setGender(GenderEnum.FEMALE);
        userMapper.insert(user);
    }

    @Test
    public void test() {
        System.out.println(GenderEnum.FEMALE.getGender());
    }

}
