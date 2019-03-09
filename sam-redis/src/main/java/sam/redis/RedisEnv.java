package sam.redis;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/5 16:16
 */
public class RedisEnv {
    public static Properties initRedisENV(){
        InputStreamReader in = null;
        try {
            Properties pro = new Properties();
            in = new InputStreamReader(RedisEnv.class.getClassLoader().getResourceAsStream("redis.properties"), "UTF-8");
            pro.load(in);
            return pro;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if ( null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
