package database;

import java.sql.*;
public class DataBaseConnection {
    private static String url;
    private static String user;
    private static String password;


    public DataBaseConnection(String url, String user, String password){
        this.url = url;
        this.user= user;
        this.password = password;
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url , user , password);
    }

}
