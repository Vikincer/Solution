package pers.rokin.jdbc.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtils {
    private static DataSource dataSource;
    static {
        try{
            InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties properties = new Properties();
            properties.load(in);

            dataSource = BasicDataSourceFactory.createDataSource(properties);

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
