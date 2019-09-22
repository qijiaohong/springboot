package com.example.task;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GrantUtils {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTR;
    private static int corePoolSize=20;
    private static int maxPoolSize=20;
    private static int taskKeepAliveTime=60;
    private static int arrayBlockQueueSize=60;
static{
    InputStream inputStream = GrantUtils.class.getClassLoader().getResourceAsStream("queue.properties");
    Properties prop = new Properties();
    try {
        prop.load(inputStream);
        corePoolSize = Integer.parseInt(prop.getProperty("core.pool.size"));
        maxPoolSize = Integer.parseInt(prop.getProperty("max.pool.size"));
        taskKeepAliveTime = Integer.parseInt(prop.getProperty("task.keep.alive.size"));
        arrayBlockQueueSize = Integer.parseInt(prop.getProperty("array.block.queue.size"));

    } catch (IOException e) {
        e.printStackTrace();
    }
    THREAD_POOL_EXECUTR = new ThreadPoolExecutor(corePoolSize,maxPoolSize,taskKeepAliveTime, TimeUnit.SECONDS,new ArrayBlockingQueue<>(arrayBlockQueueSize));
}
    public static  ThreadPoolExecutor getThreadPoolExecutor(){
        return THREAD_POOL_EXECUTR;
    }
}
