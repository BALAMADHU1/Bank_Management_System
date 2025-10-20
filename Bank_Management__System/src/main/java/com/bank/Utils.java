package com.bank;
import java.sql.*;
import java.util.Random;

public class Utils {
    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";  // change accordingly
    private static final String PASS = "root";

    public static Connection getConnection() throws SQLException {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); } 
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static long generateAccountNumber() {
        Random random = new Random();
        return 100000000000L + (long)(random.nextDouble() * 900000000000L);
    }
}
