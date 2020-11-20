package com.sam.utils.data;

/**
 * @author ChenXinmin
 * @date 2017/1/9.
 * 重试机制工具
 */
public class RetryUtils {
    public static final int MAX_RETRY = 3;
    //重试机制
    public static void retry(int a,int b){
        int retryCount = 0;//次数
        while(retryCount<MAX_RETRY+1){
            try{
                //业务
                System.out.println(a/b);
                System.out.println("===========执行业务重试第"+ retryCount+"次成功==================");
                break;//无异常跳出循环
            }catch (Exception e){
                retryCount ++;//异常时,重试次数增加
                System.out.println("===========重试次数========="+ retryCount);
                if(retryCount==3){
                    throw e;
                }
                continue;//结束本次循环,继续
            }
        }
    }

}
