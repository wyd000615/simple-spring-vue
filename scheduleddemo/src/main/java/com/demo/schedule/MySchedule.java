package com.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedule {
    //fixedDelay  表示当前任务执行结束1庙后开启另一个任务
    @Scheduled(fixedDelay = 4000)
    public void fixedDay(){
        //System.out.println("fixdday11111111111111111111111111111111111111:"+new Date());
    }
    //fixedRate表示当前任务执行2秒后开启另一个定时任务,
    @Scheduled(fixedRate = 6000)
    public void fixedRate(){
        //System.out.println("fixedRate22222222222222222222222222222222222:"+new Date());
    }
    //fixedRate表示当前任务执行2秒后开启另一个定时任务,  initDelay 表示首次执行的延迟时间

    @Scheduled(initialDelay = 2000,fixedRate = 6000)
    public void initialDelay(){
        //System.out.println("initialDelay3333333333333333333333333333333333:"+new Date());
    }
    //{秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
    @Scheduled(cron = "8 * * * * ?")
    public void cron(){
        //System.out.println("cron44444444444444444444444444444444444444444:"+new Date());
    }

}
