package com.project.QLDSV_HTC.entity;

import java.io.Serializable;
import java.util.Objects;

public class DangKyId implements Serializable {
    private Integer lopTinChi; // Khớp với kiểu của MALTC trong LopTinChi
    private String sinhVien;   // Khớp với kiểu của MASV trong Sinhvien

    // Constructor mặc định
    public DangKyId() {}

    // Constructor với tham số
    public DangKyId(Integer lopTinChi, String sinhVien) {
        this.lopTinChi = lopTinChi;
        this.sinhVien = sinhVien;
    }

    // Getter và Setter
    public Integer getLopTinChi() {
        return lopTinChi;
    }

    public void setLopTinChi(Integer lopTinChi) {
        this.lopTinChi = lopTinChi;
    }

    public String getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(String sinhVien) {
        this.sinhVien = sinhVien;
    }

    // equals và hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DangKyId that = (DangKyId) o;
        return lopTinChi.equals(that.lopTinChi) && sinhVien.equals(that.sinhVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lopTinChi, sinhVien);
    }
}