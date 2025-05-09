package com.project.QLDSV_HTC.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Sinhvien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sinhvien {

		@Id
		@Column(name = "MASV", columnDefinition = "NCHAR(10)")
		private String maSV;
		
		@Column(name = "HO", columnDefinition = "NVARCHAR(50)", nullable = false)
		private String ho;
		
		@Column(name = "TEN", columnDefinition = "NVARCHAR(10)", nullable = false)
		private String ten;
		
		@ManyToOne
	    @JoinColumn(name = "MALOP", nullable = false)
	    private Lop lop;
		
		@Column(name = "PHAI", nullable = false)
		private boolean phai = false;
		
		@Temporal(TemporalType.TIMESTAMP)
	    private Date ngaySinh;
		
		@Column(name = "DIACHI", columnDefinition = "NVARCHAR(100)")
	    private String diaChi;
		
		@Column(name = "DANGHIHOC", nullable = false)
		private boolean dangNghiHoc = false;

		@Column(name = "PASSWORD", columnDefinition = "NVARCHAR(40)", nullable = false)
	    private String password = "123456";
		
		@OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
	    private List<DangKy> dsDangKy;
}
