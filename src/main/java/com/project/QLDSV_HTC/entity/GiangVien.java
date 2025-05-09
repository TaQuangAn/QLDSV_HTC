package com.project.QLDSV_HTC.entity;


import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "GIANGVIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiangVien {

	@Id
	@Column(name = "MAGV",columnDefinition = "NCHAR(10)", length = 10)
    private String maGV;
	
	@Column(name = "HO", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String ho;
	
	@Column(name = "TEN", columnDefinition = "NVARCHAR(10)", nullable = false)
    private String ten;
	
	@Column(name = "HOCVI", columnDefinition = "NVARCHAR(20)")
    private String hocVi;

    @Column(name = "HOCHAM", columnDefinition = "NVARCHAR(20)")
    private String hocHam;

    @Column(name = "CHUYENMON", columnDefinition = "NVARCHAR(50)")
    private String chuyenMon;
	
	@ManyToOne
    @JoinColumn(name = "MaKhoa", nullable = false)
    private Khoa khoa;
	
	@OneToMany(mappedBy = "giangVien", cascade = CascadeType.ALL)
    private List<LopTinChi> dsLopTinChi;
	
}
