package com.sam.utils.data;

import java.util.concurrent.TimeUnit;

/**
 * 重试函数式接口
 * @author ChenXinmin
 * @date 2020/11/20 9:50
 */
@FunctionalInterface
public interface RetryInterface {
    /**
     * 执行某种操作的函数结构定义，没有入参，返回值为布尔类型
     * @return 返回值
     */
    boolean action();

    /**
     * 最大重试次数5次
     */
    int MAX_RETRY_COUNT = 5;

    /**
     * 重试间隔时间3秒
     */
    int INTERVAL_SECONDS = 3;

    /**
     * 实现重试
     *
     * @param maxRetryCount
     *            最大重试次数
     * @param workFunction
     *            每次重试所执行的工作函数
     * @param intervalFunction
     *            重试间隔期间执行的函数，比如sleep一段时间
     */
    static void retry(int maxRetryCount, RetryInterface workFunction,
                             RetryInterface intervalFunction) {
        // 如果最大重试次数小于1，或重试工作函数为空，直接返回
        if (maxRetryCount < 1 || null == workFunction) {
            return;
        }

        // 执行最大重试次数次重试操作
        for (int i = 0; i < maxRetryCount; i++) {
            // 如果本次的执行结果为成功，则不再继续重试
            if (workFunction.action()) {
                return;
            }

            // 如果本次的执行结果为失败，则执行重试间隔函数之后继续重试执行工作函数
            intervalFunction.action();
        }

        System.out.println("have tried maxRetryCount!");
    }

    /**
     * 让当前线程睡眠指定秒数
     *
     * @param seconds 秒数
     * @return 是否成功
     */
    static boolean doSleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (InterruptedException e) {
            System.out.println("exception occurs when doSleep, e = " + e);
            return false;
        }
    }
}
