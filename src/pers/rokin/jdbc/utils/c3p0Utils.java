package pers.rokin.jdbc.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class c3p0Utils {
    private static DataSource dataSource = null;
    static{
        try{
            dataSource = new ComboPooledDataSource("mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放连接资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(resultSet != null)
            resultSet.close();
        if(statement != null)
            statement.close();
        if(connection != null)
            connection.close();
    }
}
