package com.project.QLDSV_HTC.controller;

import java.io.IOException;

import com.project.QLDSV_HTC.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
