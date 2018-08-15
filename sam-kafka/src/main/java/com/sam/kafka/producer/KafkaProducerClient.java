package com.sam.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;

/**
 * @Author:ChenXinmin
 * @Date:2018/8/15 16:57
 */
public class KafkaProducerClient {
    // set up the producer
    private static KafkaProducer<String, String> producer;
    static {
        producer = new KafkaProducer<>(ConfigPropertiesUtil.readProperties());
    }

    /**
     * single data  send to kafka
     * @param topic
     * topic名称
     * @param message
     * 发送的信息
     * 按统一格式组装的数据
     */
    public static void send(String topic, String message) {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }

    /**
     * batch send to kafka
     * @param topic
     * topic名称
     * @param messages
     * 发送的信息  按统一格式组装的数据集合
     */
    public static void batchSend(String topic, List<String> messages) {
        if (messages == null || messages.isEmpty()) {
            return;
        }
        for (String message : messages) {
            send(topic, message);
        }
    }

    /**
     * producer flush data
     */
    public static void flush(){
        if (producer!=null){
            producer.flush();
        }
    }
}
