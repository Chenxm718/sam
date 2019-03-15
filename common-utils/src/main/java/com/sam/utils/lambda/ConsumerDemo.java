package com.sam.utils.lambda;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/14 10:28
 */
public class ConsumerDemo {
    public static void consumerList(String startStr, Consumer<List<String>> consumer ){
        if (startStr!=null){
            List<String> list = new ArrayList<>();
            for ( int i=0;i<10;i++) {
                list.add(startStr+"_"+i);
            }
            consumer.accept(list);
        }
    }

    public static void biConsumerList(String startStr, BiConsumer<List<String>,Integer> consumer ){
        if (startStr!=null){
            Integer initCount = 10;
            List<String> list = new ArrayList<>();
            for ( int i=0;i<initCount;i++) {
                list.add(startStr+"_"+i);
            }
            consumer.accept(list,initCount);
        }
    }
}

