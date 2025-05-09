package com.project.QLDSV_HTC.controller;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.project.QLDSV_HTC.App;

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
    private Label errorLabel; // Label to display error messages

    // Hard-coded credentials for demonstration (replace with actual authentication logic)
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    @FXML
    private void login() throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Check if username and password are correct
        if (isValidCredentials(username, password)) {
            App.setRoot("secondary"); // Navigate to secondary view if credentials are valid
        } else {
            errorLabel.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    // Method to validate credentials
    private boolean isValidCredentials(String username, String password) {
        // Replace this with actual authentication logic (e.g., database or service call)
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}
