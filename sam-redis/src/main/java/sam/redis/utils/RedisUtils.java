package sam.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import sam.redis.RedisEnv;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/5 16:43
 */
public class RedisUtils {

    public static JedisSentinelPool getJedisSentinelPool(){
        Properties properties = RedisEnv.initRedisENV();
        Set<String> sentinels = new HashSet<>();
        sentinels.add(properties.getProperty("redis.host.node1"));
        sentinels.add(properties.getProperty("redis.host.node2"));
        sentinels.add(properties.getProperty("redis.host.node3"));
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(
                properties.getProperty("redis.master.name")
                ,sentinels,properties.getProperty("redis.password")
        );
        return jedisSentinelPool;
    }

    public static String get(String key){
       String value ;
       JedisSentinelPool pool = getJedisSentinelPool();
       Jedis jedis =  pool.getResource();
       value = jedis.get(key);
//       jedis.close();
//       pool.close();
       return value;
    }
    public static void add(String key,String value){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        jedis.set(key,value,"NX","PX",60);
        jedis.close();
        pool.close();
    }

    public static void setNx(String key,String value){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        Long result = jedis.setnx(key,value);
        //1成功，0已存在
        System.out.println(result);
        jedis.close();
        pool.close();
    }
    public static Long incr(String key){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        Long result = jedis.incr(key);
        //1成功，0已存在
//        System.out.println(result);
        jedis.close();
        pool.close();
        return result;
    }


    public static Long rpush(String key, String... values){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        long value = jedis.rpush(key,values);
//        jedis.close();
//        pool.close();
        return value;
    }


    public static String rpop(String key){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        String value = jedis.rpop(key);
        jedis.close();
        pool.close();
        return value;
    }

    public static Long lpush(String key, String... values){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        long value = jedis.lpush(key,values);
        jedis.close();
        pool.close();
        return value;
    }


    public static String lpop(String key){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        String value = jedis.lpop(key);
//        jedis.close();
//        pool.close();
        return value;
    }


    public static Long llen(String key){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        Long value = jedis.llen(key);
//        jedis.close();
//        pool.close();
        return value;
    }

    public static Long incrBy(String key,long increment){
        JedisSentinelPool pool = getJedisSentinelPool();
        Jedis jedis =  pool.getResource();
        Long value = jedis.incrBy(key, increment);
//        jedis.close();
//        pool.close();
        return value;
    }
}
