package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection Connector(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jjdbc:mysql://localhost/knk?user=root&password=vesazhitia.12fr");
            return conn;
        }
        catch (Exception e){
            return  null;
        }
    }
}