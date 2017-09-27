package com.sam.annotation.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by ChenXinmin on 2017/9/27.
 * 表名注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ATable {
    /**
     * 表名，注解
     * 此处默认是空，如果是空，解析是默认取类名
     * @return
     */
    String tableName() default "";
}
