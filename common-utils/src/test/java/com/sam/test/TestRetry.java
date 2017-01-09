package com.sam.test;

import com.sam.utils.data.RetryUtils;
import org.junit.Test;

/**
 * Created by ChenXinmin on 2017/1/9.
 * RetryUtils junit test
 */
public class TestRetry {

    @Test
    public void sendData(int a,int b){
        RetryUtils.retry(10,0);
    }
}
