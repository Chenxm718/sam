package com.sam.test;

import com.sam.annotation.db.ATable;

/**
 * Created by ChenXinmin on 2017/9/27.
 */
@ATable()
public class TestTableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
