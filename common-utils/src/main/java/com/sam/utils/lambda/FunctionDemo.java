package com.sam.utils.lambda;

import java.util.*;
import java.util.function.Function;

/**
 * jdk1.8 function -> lambda
 * Created by ChenXinmin on 2017/2/7.
 */
public class FunctionDemo {

    public static <T> List<T> testFunction(Map<T,T> args, Function<String[],List<T>> fun){
        System.out.println("print arg....");
        Set<T> set = args.keySet();
        List<T> list = new ArrayList(set);
        String[] arg = (String[])list.toArray(new String[list.size()]);
        return fun.apply(arg);
    }

    public static List<String> funDemo(String[] fd){
        List<String> list = Arrays.asList(fd);
        List<String> returnList = new ArrayList<>();
        list.forEach(l->{
            returnList.add(l+"test");
        });
        return returnList;
    }

}
