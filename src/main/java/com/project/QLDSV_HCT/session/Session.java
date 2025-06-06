package com.project.QLDSV_HCT.session;

import java.sql.Connection;
import java.sql.SQLException;

public class Session {
	public static Connection connection;
	public static String currentUsername;
    public static String currentRole;
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Đã đóng kết nối SQL Server.");
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Lỗi khi đóng connection: " + e.getMessage());
        }
    }
}
