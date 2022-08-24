package pers.rokin.jdbc;

import pers.rokin.jdbc.utils.JDBCUtils;

import java.sql.*;

/*
* SQL注入即是指web应用程序对用户输入数据的合法性没有判断或过滤不严，
* 攻击者可以在web应用程序中事先定义好的查询语句的结尾上添加额外的SQL语句，
* 在管理员不知情的情况下实现非法操作，以此来实现欺骗数据库服务器执行非授权的任意查询，从而进一步得到相应的数据信息
* */

public class SQLinjection {
    public static void main(String[] args) throws SQLException {
//        login(" 'or '1=1","'or '2=2");  //SQL注入漏洞  因为sql语句有AND 所以用了两个or
        //解决方法 使用PreparedStatement 可以防止sql注入  并且 效率更高
        newlogin(" 'or '1=1","'or '2=2");
    }

    private static void login(String username, String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //sql注入漏洞
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            //"SELECT * FROM admin WHERE name = '" + username + "' AND password = '" + password + "'";
            String sql = "SELECT * FROM admin WHERE name = '' or '1=1' AND password = '' or '2=2' ";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("password: " + resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(connection,statement,resultSet);
        }
    }

    private static void newlogin(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);    //开启事务
            String sql = "SELECT * FROM admin WHERE name = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);   //预编译sql
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //业务完毕提交事务
            connection.commit();
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("password: " + resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            connection.rollback();  //失败 回滚事务 但默认是会回滚的 不写也行
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(connection,preparedStatement,resultSet);
        }
    }

}
