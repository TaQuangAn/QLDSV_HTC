package com.project.QLDSV_HTC.entity;



import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "DANGKY")
@IdClass(DangKyId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DangKy {
	@Id
    @ManyToOne
    @JoinColumn(name = "MALTC", nullable = false)
    private LopTinChi lopTinChi;

    @Id
    @ManyToOne
    @JoinColumn(name = "MASV", nullable = false, columnDefinition = "NCHAR(10)")
    private Sinhvien sinhVien;

    @Column(name = "DIEM_CC")
    private Integer diemCC;

    @Column(name = "DIEM_GK")
    private Float diemGK;

    @Column(name = "DIEM_CK")
    private Float diemCK;

    @Column(name = "HUYDANGKY", nullable = false)
    private boolean huyDangKy = false;
}
