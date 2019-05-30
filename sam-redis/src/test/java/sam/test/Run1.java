package sam.test;

import sam.redis.utils.RedisUtils;

/**
 * @Author:ChenXinmin
 * @Date:2019/5/23 14:23
 */
public class Run1 extends Thread{

    public void run() {
        for (int i=0;i<10;i++){
            String key = "push_key_test";
            RedisUtils.rpush(key,"run1_"+i);
//            System.out.println("run1_"+i);
        }
    }
}
