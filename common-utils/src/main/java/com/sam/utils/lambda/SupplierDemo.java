package com.sam.utils.lambda;

import java.util.List;
import java.util.function.Supplier;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/14 11:30
 */
public class SupplierDemo {

    public static List<String> supplier(Supplier<List<String>> supplier){

        return supplier.get();
    }
}
