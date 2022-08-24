package pers.rokin.jdbc;

import jdk.nashorn.internal.ir.WhileNode;
import pers.rokin.jdbc.utils.JDBCUtils;

import java.sql.*;

public class JDBCFirstDemo {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
//            String sql = "INSERT INTO admin VALUES(2,'DDD','123456')";  //增
//            String sql = "DELETE FROM admin WHERE id = 2";  //删
            String sql = "UPDATE admin SET name='AAA' WHERE id=2";  //改
            String sql1 = "SELECT * FROM admin ";  //查

            int i = statement.executeUpdate(sql);
            ResultSet resultSet = statement.executeQuery(sql1);
            while(resultSet.next()){
                System.out.println("id: " + resultSet.getObject("id"));
                System.out.println("username: " + resultSet.getObject("name"));
                System.out.println("password: " + resultSet.getObject("password"));
            }
            if(i>0)
                System.out.println("成功！");
        }finally {
            JDBCUtils.release(connection,statement,null);
        }

    }
}
