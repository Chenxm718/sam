package com.sam.db.pool.oracle.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenXinmin on 2017/1/9.
 */
public class DBInitInfo {
    public  static List<DBBean> beans = null;
    static{
        beans = new ArrayList<DBBean>();
        // 这里数据 可以从xml 等配置文件进行获取
        // 为了测试，这里我直接写死
        DBBean beanOracle = new DBBean();
        beanOracle.setDriverName("oracle.jdbc.driver.OracleDriver");
        beanOracle.setUrl("jdbc:oracle:thin:@192.168.55.120:1521:cmc01");
        beanOracle.setUserName("ccs_ods");
        beanOracle.setPassword("cmc123");

        beanOracle.setMinConnections(5);
        beanOracle.setMaxConnections(100);

        beanOracle.setPoolName("cmcbi");
        beans.add(beanOracle);
    }
}
