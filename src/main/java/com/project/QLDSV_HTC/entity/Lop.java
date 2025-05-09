package com.project.QLDSV_HTC.entity;



import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Lop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lop {
	
	@Id
    @Column(name = "MALOP", columnDefinition = "NCHAR(10)")
    private String maLop;
	
	@Column(name = "TENLOP",columnDefinition = "NVARCHAR(50)", nullable = false, unique = true)
	private String tenLop;
	
	@Column(name = "KHOAHOC",columnDefinition = "NCHAR(9)", nullable = false)
	private String khoaHoc;
	
	@ManyToOne
    @JoinColumn(name = "MaKhoa", nullable = false)
    private Khoa khoa;
	
	@OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    private List<Sinhvien> danhsachSV;
}
