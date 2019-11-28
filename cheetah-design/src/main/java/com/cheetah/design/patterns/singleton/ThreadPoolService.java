package com.cheetah.design.patterns.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolService {

    /** 线程池保持ALIVE状态线程数 */
    public static final int                 CORE_POOL_SIZE      = 10;

    /** 线程池最大线程数 */
    public static final int                 MAX_POOL_SIZE       = 40;

    /** 空闲线程回收时间 */
    public static final int                 KEEP_ALIVE_TIME     = 1000;

    /** 线程池等待队列 */
    public static final int                 BLOCKING_QUEUE_SIZE = 1000;



    private ThreadPoolService() {}



    private static class Inner {
        private static volatile ThreadPoolExecutor executor = new ThreadPoolExecutor(
                MAX_POOL_SIZE,
                CORE_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MICROSECONDS, // 单位
                new LinkedBlockingDeque<Runnable>(Integer.MAX_VALUE), // 阻塞队列
                Executors.defaultThreadFactory() // 线程工厂
                );
    }
}