package com.project.QLDSV_HTC.service;

import com.project.QLDSV_HTC.entity.Khoa;
import com.project.QLDSV_HTC.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }

    public Khoa getKhoaById(String maKhoa) {
        return khoaRepository.findById(maKhoa).orElse(null);
    }
}