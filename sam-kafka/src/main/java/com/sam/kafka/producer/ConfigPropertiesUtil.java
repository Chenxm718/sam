package com.sam.kafka.producer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author:ChenXinmin
 * @Date:2018/8/15 17:02
 */
public class ConfigPropertiesUtil {

    public static Properties readProperties(){
        Properties props = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = ConfigPropertiesUtil.class.getClassLoader().getResourceAsStream("config/app.properties");
        // 使用properties对象加载输入流
        try {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       //获取key对应的value值
        props.put("bootstrap.servers", props.getProperty("kafka_bootstrap_servers"));
        props.put("acks", props.getProperty("kafka_acks"));
        props.put("retries", props.getProperty("kafka_retries"));
        props.put("batch.size", props.getProperty("kafka_batch_size"));
        props.put("auto.commit.interval.ms", props.getProperty("kafka_auto_commit_interval_ms"));
        props.put("linger.ms", props.getProperty("kafka_linger_ms"));
        props.put("key.serializer", props.getProperty("kafka_key_serializer"));
        props.put("value.serializer", props.getProperty("kafka_value_serializer"));
        return props;
    }
}
