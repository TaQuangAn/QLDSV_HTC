package com.project.QLDSV_HTC.entity;


import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "LOPTINCHI", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NIENKHOA", "HOCKY", "MAMH", "NHOM"})
})	
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LopTinChi {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALTC")
    private int maLTC;
	
	@Column(name = "NIENKHOA", columnDefinition = "NCHAR(9)", nullable = false)
    private String nienKhoa;
	
	@Column(name = "HOCKY", nullable = false)
    private int hocKy;
	
	@ManyToOne
    @JoinColumn(name = "MAMH", nullable = false)
    private MonHoc monHoc;
	
	@Column(name = "NHOM", nullable = false)
    private int nhom;
	
	@ManyToOne
    @JoinColumn(name = "MAGV", nullable = false)
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "MAKHOA", nullable = false)
    private Khoa khoa;

    @Column(name = "SOSVTOITHIEU", nullable = false)
    private short soSVToiThieu;

    @Column(name = "HUYLOP", nullable = false)
    private boolean huyLop = false;

    @OneToMany(mappedBy = "lopTinChi", cascade = CascadeType.ALL)
    private List<DangKy> dsDangKy;

	
	
}
