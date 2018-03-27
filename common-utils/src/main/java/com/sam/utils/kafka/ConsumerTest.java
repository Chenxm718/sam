package com.sam.utils.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.util.*;

public class ConsumerTest{


    @Test
    public void test1() {
        String recordStrFormat = "offset = %d, key = %s, value = %s\n";
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.119.128:9092,192.168.119.129:9092,192.168.119.130:9092");
        props.put("group.id", "default");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", 1000);
        props.put("session.timeout.ms", 30000);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        //test test2 为topic的名字
        consumer.subscribe(Arrays.asList("test4"));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format(recordStrFormat, record.offset(), record.key(), record.value()));
                }
            }
        } finally {
            if (null != consumer)
                consumer.close();
        }
    }
}
