package com.sam.db.pool.oracle.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ChenXinmin on 2017/1/9.
 * interface for connection pool
 */
public interface IConnectionPool {
    /**
     * get connection
     * @return
     */
    Connection getConnection();

    /**
     * get current connection
     * @return
     */
    Connection getCurrentConnecton();

    /**
     * release connection
     * @param conn
     * @throws SQLException
     */
    void releaseConn(Connection conn) throws SQLException;

    /**
     * destroy connection
     */
    void destroy();

    /**
     * check connection pool is active
     * @return
     */
    boolean isActive();

    /**
     * check pool is active and init
     */
    void checkPool();
}
