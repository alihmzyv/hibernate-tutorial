package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/hb_student_tracker";
        String user = "postgres";
        String pass = "admin";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connection is successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
