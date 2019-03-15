package com.sam.test;

import com.sam.utils.lambda.ConsumerDemo;
import com.sam.utils.lambda.FunctionDemo;
import com.sam.utils.lambda.SupplierDemo;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by ChenXinmin on 2017/2/7.
 */
public class TestLambda {
    @Test
    public void test(){
        Map<String ,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        List<String> list = FunctionDemo.testFunction(map, nc->FunctionDemo.funDemo(nc));
        list.forEach(li-> System.out.println(li));
    }

    @Test
    public void test1(){
        int   n = 10 , max = 0 , min = 0 , temp = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            max = min = Integer.parseInt(br.readLine( ));
        } catch ( IOException e ) {
            System.out.println(e.getMessage());
        }
        for ( int i = 0 ; i <= n ; i ++ ) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                temp = Integer.parseInt(br.readLine( ));
                if (temp > max ) max=temp;
                if (temp < min) min=temp;
            } catch ( IOException e ) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("max number = "+max+", min number = "+min);
    }

    @Test
    public void testConsumer(){
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("3");
//        list.add("-1");
//        list.add("10");
//        Consumer<List<String>> cunsumer = list1 -> {
//            list1.add("90");
//        };
//        Consumer<List<String>> cunsumer2 = list1 -> {
//            list1.add("90");
//        };
//        ConsumerDemo.consumerList(list,
//                con->{
//                    con.add("80");
//                    con.sort(Comparator.comparing(Integer::valueOf));
//                }
//                );
////        list.add("5");
////        list.sort(Comparator.comparing(Integer::valueOf));
//        list.forEach(s -> {
//            System.out.println(s);
//        });
        String str = "test";
        ConsumerDemo.consumerList(str,consumer->{
            consumer.forEach(s -> {
                System.out.println(s);
            });
        });
        ConsumerDemo.biConsumerList(str,(con,total )->{
            con.forEach(s -> {
                System.out.println(s+"====="+total);
            });
        });
    }
    @Test
    public void testSupplier(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("-1");
        list.add("10");

//        List<String> stringList = SupplierDemo.supplier(init());
    }
    private List<String> init(){
        return new ArrayList<>();
    }

    @Test
    public void testFun(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("-1");
        list.add("10");
        Integer size = FunctionDemo.functionTest(list, initStr->{
//            initStr.add("9");
            return initStr.size();
        });
        System.out.println(size);
        list.forEach(s -> {
            System.out.println(s);
        });
        Integer count = FunctionDemo.functionTest(list,initS -> returnSize(initS));
        System.out.println(count);
    }
    private Integer returnSize(List<String> list){
        if (list!=null && !list.isEmpty()){
            return list.size();
        }else {
            return 0;
        }

    }
}
