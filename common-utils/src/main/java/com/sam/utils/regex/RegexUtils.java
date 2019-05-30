package com.sam.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/18 14:20
 */
public class RegexUtils {
    public static void getGroup(String str,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int groupCount = matcher.groupCount();
        if (groupCount>0){
            while (matcher.find()){
                System.out.println(matcher.group(0));
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group("username"));
                System.out.println(matcher.group("userAge"));
            }
        }

    }
}
