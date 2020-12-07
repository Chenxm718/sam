package com.sam.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author ChenXinmin
 * @date 2020/12/7 8:37
 */
public class VoucherUtilsTest {
    /**
     * 分片
     */
    @Test
    public void testShard(){
        System.out.println(Math.abs(new Long(1009527380).hashCode())%32 +1);
        System.out.println(Math.abs(("15047250012").hashCode())%32 +1);
    }

    /**
     * 根据销售单ID获取邮件压缩密码
     * 短信发送的密码
     */
    @Test
    public void testEmailPassWord(){
        System.out.println(getEmailPassWord("20113010395000001001"));
    }

    /**
     * 根据销售单ID获取邮件压缩密码
     *
     * @param sellOrderId 销售单ID
     */
    public static String getEmailPassWord(String sellOrderId) {
        String salt1 = "sellOrder";
        String salt2 = "email";
        sellOrderId = StringUtils.reverse(sellOrderId);
        String password = (salt1 + sellOrderId + salt2).hashCode() + "";
        if (password.contains("-")) {
            password = password.substring(1);
        }
        if (password.length() > 8) {
            password = password.substring(0, 8);
        } else {
            for (int i = 0; i < password.length() - 8; i++) {
                password = "8" + password;
            }
        }
        return password;
    }
}
