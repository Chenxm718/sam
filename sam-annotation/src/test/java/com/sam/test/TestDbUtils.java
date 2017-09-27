package com.sam.test;

import com.sam.annotation.utils.DbUtils;
import org.junit.Test;

/**
 * Created by ChenXinmin on 2017/9/27.
 */
public class TestDbUtils {
    @Test
    public void testDbUtils(){
        DbUtils.DbEntityInfo entityInfo = DbUtils.getEntityInfo(TestTableBean.class);
        System.out.println(entityInfo.getTableName());
    }
}
