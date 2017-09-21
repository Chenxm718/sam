package com.sam.test;

import org.junit.Test;

import java.util.*;

/**
 * Created by ChenXinmin on 2017/2/10.
 */
public class TestSubList {
    @Test
    public void testSubList(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        int k = 0;
        Map<Integer,List<String>> map = new HashMap<>();
        for(int i =0;i<list1.size();i+=4){
            List<String> l ;
            if(i+4>list1.size()){
                l = list1.subList(i,list1.size());

            }else{
                l = list1.subList(i,i+4);
            }
            map.put(k,l);
            k++;
        }
        System.out.println( map.size());
        map.entrySet().forEach(e->{
            System.out.println("遍历set");
            System.out.println(e.getValue().toString());
            e.getValue().forEach(str->{
                System.out.println(str);
            });
        });
    }
    @Test
    public void testSplit(){
        String s = "1";
        System.out.println(Arrays.asList(s.split(",")));
    }
}
