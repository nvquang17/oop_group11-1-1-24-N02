package DTO;

import java.io.Serializable;

public class SinhVienMonHocDTO implements Serializable {

    private String maSinhVien;
    private String maMonHoc;
    private Double diemQuaTrinh;  // Điểm quá trình (có thể null)
    private Double diemKetThuc;   // Điểm kết thúc
    private boolean dangKyDuocDuyet; // Trạng thái đăng ký (đã được duyệt hay chưa)

    public SinhVienMonHocDTO(String maSinhVien, String maMonHoc) {
        this(maSinhVien, maMonHoc, 0.0, 0.0, false);
    }

    // Constructor có thể nhận trạng thái đăng ký (tùy chỉnh)
    public SinhVienMonHocDTO(String maSinhVien, String maMonHoc, Double diemQuaTrinh, Double diemKetThuc, boolean dangKyDuocDuyet) {
        this.maSinhVien = maSinhVien;
        this.maMonHoc = maMonHoc;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemKetThuc = diemKetThuc;
        this.dangKyDuocDuyet = dangKyDuocDuyet;
    }

    // Getters and Setters
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public Double getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(Double diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public Double getDiemKetThuc() {
        return diemKetThuc;
    }

    public void setDiemKetThuc(Double diemKetThuc) {
        this.diemKetThuc = diemKetThuc;
    }

    public boolean isDangKyDuocDuyet() {
        return dangKyDuocDuyet;
    }

    public void setDangKyDuocDuyet(boolean dangKyDuocDuyet) {
        this.dangKyDuocDuyet = dangKyDuocDuyet;
    }

    // Phương thức tính điểm tổng kết
    public Double tinhDiemTongKet() {
        if (diemQuaTrinh == null) {
            // Nếu không có điểm quá trình, hệ số 100% cho điểm kết thúc
            return diemKetThuc;
        } else {
            // Nếu có cả hai điểm, hệ số 50% cho mỗi điểm
            return (diemQuaTrinh * 0.5) + (diemKetThuc * 0.5);
        }
    }
}
