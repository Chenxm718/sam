package com.sam.test;

import com.sam.utils.regex.RegexUtils;
import org.junit.Test;

/**
 * @Author:ChenXinmin
 * @Date:2019/3/18 14:25
 */
public class RegexTest {
    @Test
    public void textGroup(){
        String str = "{userName:sam,userAge:30}";
        String regex = "^\\{userName\\:(?<username>.*?),userAge\\:(?<userAge>\\d+)\\}$";
        RegexUtils.getGroup(str,regex);
    }
}
