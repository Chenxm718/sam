package com.sam.test;

import com.sam.utils.lambda.FunctionDemo;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
