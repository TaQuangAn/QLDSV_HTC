package com.project.QLDSV_HTC.entity;



import java.util.List;


import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Khoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Khoa {
	
	@Id
	@Column(name = "MAKHOA",columnDefinition = "NCHAR(10)")
	private String maKhoa;
	
	@Column(name = "TENKHOA", columnDefinition = "NVARCHAR(50)", nullable = false, unique = true)
	private String tenKhoa;
	
    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private List<Lop> dsLop;
    
    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private List<GiangVien> dsGiangVien;
    
    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    private List<LopTinChi> dsLopTinChi;
}
