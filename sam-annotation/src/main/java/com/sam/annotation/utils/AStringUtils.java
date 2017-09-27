package com.sam.annotation.utils;

/**
 * Created by ChenXinmin on 2017/9/27.
 */
public class AStringUtils {
    public static boolean isEmpty(String str){
        if(str == null || str.length()==0 || "".equals(str)){
            return true;
        }else {
            return false;
        }
    }
}
