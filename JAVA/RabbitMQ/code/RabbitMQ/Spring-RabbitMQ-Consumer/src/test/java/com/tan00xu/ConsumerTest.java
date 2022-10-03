package com.tan00xu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/03 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rabbitmq-consumer.xml"})
public class ConsumerTest {
    @Test
    public void test1() {
        while (true) {
        }

    }
}
