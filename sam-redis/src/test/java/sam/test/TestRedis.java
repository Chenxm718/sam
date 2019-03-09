package sam.test;

import org.junit.Test;
import sam.redis.utils.RedisUtils;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/5 17:15
 */
public class TestRedis {

    @Test
    public void testRedis(){
        RedisUtils.add("test_1_33","test_to1");
        System.out.println(RedisUtils.get("test_1_33"));
    }
    @Test
    public void testRedisNx(){
        RedisUtils.setNx("test_1_3333","test_to1");
        System.out.println(RedisUtils.get("test_1_3333"));
    }
    @Test
    public void testIncr(){
        RedisUtils.incr("test_1_3332");
        System.out.println(RedisUtils.get("test_1_3332"));
    }


}
