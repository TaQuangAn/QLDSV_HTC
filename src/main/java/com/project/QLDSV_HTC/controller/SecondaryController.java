package com.project.QLDSV_HTC.controller;

import com.project.QLDSV_HTC.App;
import com.project.QLDSV_HTC.entity.Khoa;
import com.project.QLDSV_HTC.service.KhoaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class SecondaryController {

    @FXML
    private TableView<Khoa> khoaTable;

    @FXML
    private TableColumn<Khoa, String> maKhoaColumn;

    @FXML
    private TableColumn<Khoa, String> tenKhoaColumn;

    // Inject KhoaService (giả sử bạn đã cấu hình Spring để cung cấp bean này)
    private final KhoaService khoaService;

    // Constructor để nhận KhoaService (Spring sẽ inject)
    public SecondaryController(KhoaService khoaService) {
        this.khoaService = khoaService;
    }

    @FXML
    public void initialize() {
        // Cấu hình các cột của TableView
        maKhoaColumn.setCellValueFactory(new PropertyValueFactory<>("maKhoa"));
        tenKhoaColumn.setCellValueFactory(new PropertyValueFactory<>("tenKhoa"));

        // Lấy dữ liệu từ CSDL và hiển thị lên TableView
        loadKhoaData();
    }

    private void loadKhoaData() {
        // Lấy danh sách khoa từ KhoaService
        ObservableList<Khoa> khoaList = FXCollections.observableArrayList(khoaService.getAllKhoa());
        khoaTable.setItems(khoaList);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }
}