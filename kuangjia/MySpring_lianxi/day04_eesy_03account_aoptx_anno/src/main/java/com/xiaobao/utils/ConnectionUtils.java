package com.xiaobao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection> ();

    @Resource(name = "dataSource")
    private DataSource dataSource;

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
