package com.sam.annotation.utils;

import com.sam.annotation.db.ATable;
import com.sam.annotation.exception.AException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ChenXinmin on 2017/9/27.
 * 解析数据库相关的注解工具类
 * table
 * column
 * 等
 */
public class DbUtils {

    private static Map<String, DbEntityInfo> infos = new ConcurrentHashMap<>();

    public static DbEntityInfo getEntityInfo(Class<?> clazz) {
        String key = clazz.getTypeName();
        DbEntityInfo info = infos.get(key);
        if (info != null) return info;

        info = new DbEntityInfo(clazz);
//        if (info.fields.size() == 0) throw new AException("clazz is not a valid entity");

        infos.put(key, info);
        return info;
    }

    /**
     * db相关实体，解析注解使用
     */
    public static class DbEntityInfo {
        /**
         * 实体对应的表名
         */
        String tableName;

        DbEntityInfo(Class<?> clazz){
            ATable aTable = clazz.getAnnotation(ATable.class);
            if(aTable==null){
                throw new AException("clazz must set table name for annotation");
            }
            //得到表名
            if(!AStringUtils.isEmpty(aTable.tableName())){
                this.tableName = aTable.tableName();
            }else{
                //如果为空，取类名 getName带包名
                this.tableName = clazz.getSimpleName().toLowerCase();
            }
        }
    }
}
