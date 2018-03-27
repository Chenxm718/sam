package com.sam.test;

import com.sam.utils.lambda.FunctionDemo;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void test1(){
        int t = 10 ;
//        FunctionDemo.function1(1,fun->FunctionDemo.function1(fun));
    }
}
