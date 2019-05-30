package sam.test;

import sam.redis.utils.RedisUtils;

import java.time.LocalDateTime;

/**
 * @Author:ChenXinmin
 * @Date:2019/5/23 14:23
 */
public class PopRun4 extends Thread{
    public void run() {
        String key = "push_key_test";
        Long len = RedisUtils.llen(key);
        System.out.println(len);
        for(int i=1;i<=len;i++){
            String v = RedisUtils.rpop(key);
            System.out.println("PopRun4_"+v+"-"+LocalDateTime.now());
        }
    }
}
