package com.project.QLDSV_HTC.entity;


import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Monhoc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonHoc {
	
	@Id
    @Column(name = "MAMH",columnDefinition = "NCHAR(10)")
    private String maMH;
	
	@Column(name = "TENMH",columnDefinition = "NVARCHAR(50)", nullable = false, unique = true)
    private String tenMH;
	
	@Column(name = "SOTIET_LT", nullable = false)
    private int soTietLT;
	
	@Column(name = "SOTIET_TH", nullable = false)
    private int soTietTH;
	
	@OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
    private List<LopTinChi> dsLopTinChi;
}
