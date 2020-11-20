package com.sam.test;

import com.sam.utils.data.RetryInterface;
import com.sam.utils.data.RetryUtils;
import org.junit.Test;

/**
 * RetryUtils junit test
 * @author ChenXinmin
 * @date 2017/1/9.
 */
public class TestRetry {

    @Test
    public void sendData(){
        RetryUtils.retry(10,0);
    }

    @Test
    public void testRetryFunction(){
        // 工作函数入参
        boolean param = true;
        RetryInterface.retry(RetryInterface.MAX_RETRY_COUNT, () -> doWork(param),
                () -> RetryInterface.doSleep(RetryInterface.INTERVAL_SECONDS));
    }
    /**
     * 工作函数
     *
     * @param param
     *            一个布尔类型的入参
     * @return 返回
     */
    public static boolean doWork(boolean param) {
        System.out.println("start to do some work...");
        // 为简单期间，将入参param的值取反，模拟工作函数的执行结果
        boolean result = !param;
        if (result) {
            System.out.println("doWork success!");
        } else {
            System.out.println("doWork failed!");
        }
        return result;
    }

}
