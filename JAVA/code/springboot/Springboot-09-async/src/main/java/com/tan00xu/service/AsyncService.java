package com.tan00xu.service;

import org.springframework.stereotype.Service;

/**
 * @author TAN00XU
 * @date 2022/09/07 22:52
 */
@Service
public class AsyncService {
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("数据正在处理……");
    }
}
