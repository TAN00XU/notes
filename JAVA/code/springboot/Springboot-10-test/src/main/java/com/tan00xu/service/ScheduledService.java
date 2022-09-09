package com.tan00xu.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author TAN00XU
 * @date 2022/09/08 20:12
 */
@Service
public class ScheduledService {

    /**
     * 定时任务
     * 秒 分 时 日 月 星期
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void timedTask() {
        System.out.println("定时任务执行了！");
    }
}
