package com.inspur.jvm.classloader_02;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  总结ClassLoader并且查看一下的源代码,从加载 连接 初始化
 */
public class MyTest27 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring3", "username", "password");
    }
}
