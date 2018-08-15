package com.sam.test;

import com.sam.kafka.producer.KafkaProducerClient;
import org.junit.Test;

/**
 * @Author:ChenXinmin
 * @Date:2018/8/15 17:14
 */
public class TestProducer {
    @Test
    public void testProducer(){
        for (int i=0;i<10;i++) {
            KafkaProducerClient.send("test_sam","test"+i);
        }
        KafkaProducerClient.flush();

    }
}
