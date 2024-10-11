package DTO;

import java.io.Serializable;

public class SinhVienDTO implements Serializable {

    private String maSinhVien; // Mã sinh viên
    private String tenSinhVien; // Tên sinh viên
    private String matKhau; // Mật khẩu cho sinh viên
    private String gioiTinh; // Giới tính
    private String ngaySinh; // Ngày sinh
    private String diaChi; // Địa chỉ
    private String soDienThoai; // Số điện thoại
    private String email; // Email

    // Constructor
    public SinhVienDTO(String maSinhVien, String tenSinhVien, String matKhau,
            String gioiTinh, String ngaySinh, String diaChi,
            String soDienThoai, String email) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    // Getters and Setters
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
