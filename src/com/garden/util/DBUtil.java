package com.garden.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getDBConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "system"
        );
    }
}
