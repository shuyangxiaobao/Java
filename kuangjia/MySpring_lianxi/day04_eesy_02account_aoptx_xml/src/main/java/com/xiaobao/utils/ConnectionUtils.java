package com.xiaobao.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection> ();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        Connection connection = t1.get ();
        if (connection == null){
            try {
                connection = dataSource.getConnection ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
            t1.set ( connection );
        }
        return connection;
    }

    public void removeConnection(){
        t1.remove ();
    }
}
