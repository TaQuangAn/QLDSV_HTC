package com.project.QLDSV_HTC.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class LoginService {

	public String loginAndGetRole(String username, String password) {
        try (Connection conn = getConnection(username, password)) {
            CallableStatement cs = conn.prepareCall("{call sp_LayVaiTro}");
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString(1); // PGV / KHOA / SV
            }
        } catch (Exception e) {
            System.err.println("Lỗi đăng nhập: " + e.getMessage());
        }
        return null;
    }

    private Connection getConnection(String username, String password) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDSV_HTC;encrypt=false;trustServerCertificate=true;charset=UTF-8";
        return DriverManager.getConnection(url, username, password);
    }
}
