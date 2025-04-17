package com.project.QLDSV_HTC.controller;

import java.io.IOException;

import com.project.QLDSV_HTC.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}