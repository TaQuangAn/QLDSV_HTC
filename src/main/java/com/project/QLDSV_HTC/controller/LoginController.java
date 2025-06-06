package com.project.QLDSV_HTC.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.QLDSV_HCT.session.Session;
import com.project.QLDSV_HTC.App;
import com.project.QLDSV_HTC.service.LoginService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


@Component
public class LoginController {

	@FXML
    private TextField usernameField; // TextField for username input

    @FXML
    private PasswordField passwordField; // PasswordField for password input
    
    @FXML
    private TextField masvField; // TextField for masv input

    @FXML
    private PasswordField matkhauField; // PasswordField for matkhau input

    @FXML
    private Label errorLabel; // Label to display error messages
    
    @Autowired
    private LoginService loginService;


    @FXML
    private void login() throws IOException {
    	String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        String role = loginService.loginAndGetRole(username, password);
        if (role == null) {
            errorLabel.setText("Sai tài khoản hoặc mật khẩu!");
        } else {
        	try {
                // 🔧 Kết nối SQL bằng tài khoản người dùng
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDSV_HTC;encrypt=false";
                Session.connection = DriverManager.getConnection(url, username, password);
                Session.currentUsername = username;
                Session.currentRole = role;

                // ✅ Điều hướng giao diện theo vai trò
                switch (role) {
                    case "PGV":
                        App.setRoot("PGV_KHOA_home");
                        break;
                    case "KHOA":
                        App.setRoot("PGV_KHOA_home");
                        break;
                    case "SV":
                        App.setRoot("loginSV");
                        break;
                    default:
                        errorLabel.setText("Không xác định được vai trò!");
                }
            } catch (Exception e) {
                errorLabel.setText("Kết nối thất bại: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void loginSV() {
        String masv = masvField.getText().trim();
        String matkhau = matkhauField.getText().trim();

        try {
        	CallableStatement cs = Session.connection.prepareCall("{call sp_KiemTraDangNhapSV(?, ?)}");
        	cs.setString(1, masv);
        	cs.setString(2, matkhau);

        	ResultSet rs = cs.executeQuery();
        	if (rs.next() && rs.getInt("KetQua") == 1) {
        	    // Đúng tài khoản, chuyển sang giao diện SV
        	    Session.currentUsername = masv;
        	    Session.currentRole = "SV";
        	    App.setRoot("SV_home");
            }

        } catch (SQLException | IOException e) {
            errorLabel.setText("Sai mã SV hoặc mật khẩu!");
            e.printStackTrace();
        }
    }
}
