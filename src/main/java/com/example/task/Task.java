package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class Task{
    private Logger logger = LoggerFactory.getLogger(Task.class);

    /**
     * 上次任务执行完成等待两秒进行下一次执行
     * @throws Exception
     */
  /*  @Scheduled(fixedDelay=3000)
    public void taskFixedDelay() throws Exception{
        logger.info("taskDelay定时任务开始:{}",System.currentTimeMillis());
        Thread.sleep(2000);
        logger.info("taskDelay定时任务结束:{}",System.currentTimeMillis());
    }*/

    /**
     * 上次任务执行开始后等待两秒进行下一次执行
     * @throws Exception
     */
  /*  @Scheduled(fixedRate=9000)
    public void taskFixedRate() throws Exception{
        logger.info("taskDelay定时任务开始:{}",System.currentTimeMillis());
        logger.info("读取log.proprties文件的值:{}", ResourceBundle.getBundle("log").getString("url"));
        //Thread.sleep(2000);
        logger.info("taskDelay定时任务结束:{}",System.currentTimeMillis());
    }*/

    /**
     * @Scheduled(cron="0 0/20 * * * ?")
     * 每20分钟执行一次
     */

    /**
     * @Scheduled(cron="0 1 0 * * ?")
     * 每天凌晨一点执行一次
     */


    /**
     * @Scheduled(cron="0 0/20 * * * ?")
     * 每20分钟执行一次
     */
       @Scheduled(fixedDelay=3000)
    public void autoApprove() throws Exception{
ThreadPoolExecutor threadPoolExecutor = GrantUtils.getThreadPoolExecutor();
int corePoolSize = threadPoolExecutor.getCorePoolSize();
int activeCount = threadPoolExecutor.getActiveCount();
int freeTheadSize = corePoolSize-activeCount;
if(freeTheadSize>0){
    logger.info("批量处理申请-"+ LocalDateTime.now().toString());
}
    }
}
