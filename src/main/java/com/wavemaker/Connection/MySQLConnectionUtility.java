package com.wavemaker.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtility {
    private static String MYSQL_HOST = "jdbc:mysql://18.217.214.158:3306/PG_Project";
    private static String MYSQL_USER_NAME = "root";
    private static String MYSQL_PASSWORD = "wm9qm75Q1@0b";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(MYSQL_HOST, MYSQL_USER_NAME, MYSQL_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Exception while Creating Mysql Connection " + MYSQL_HOST + " With Userdetails " + MYSQL_USER_NAME);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
