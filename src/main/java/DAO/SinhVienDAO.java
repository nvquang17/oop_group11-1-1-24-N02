package DAO;

import DTO.SinhVienDTO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private static final String FILE_NAME = "sinhvien.dat";
    private List<SinhVienDTO> students;

    // Constructor
    public SinhVienDAO() {
        this.students = new ArrayList<>();
        loadStudents();
    }

    public List<SinhVienDTO> getStudents() {
        return students;
    }

    // Thêm sinh viên
    public void addSinhVien(SinhVienDTO sinhVien) {
        students.add(sinhVien);
        saveStudents();
    }

    // Cập nhật sinh viên
    public void updateSinhVien(SinhVienDTO sinhVien) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMaSinhVien().equals(sinhVien.getMaSinhVien())) {
                students.set(i, sinhVien);
                saveStudents();
                break;
            }
        }
    }

    // Xóa sinh viên
    public void deleteSinhVien(String maSinhVien) {
        students.removeIf(sinhVien -> sinhVien.getMaSinhVien().equals(maSinhVien));
        saveStudents();
    }

    // Liệt kê tất cả sinh viên
    public List<SinhVienDTO> listSinhVien() {
        return students;
    }

    // Tải danh sách sinh viên từ file
    private void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<SinhVienDTO>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, initialize an empty list
            students = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SinhVienDTO getSinhVienById(String maSinhVien) {
        for (SinhVienDTO sinhVien : students) {
            if (sinhVien.getMaSinhVien().equals(maSinhVien)) {
                return sinhVien;  // Trả về sinh viên nếu tìm thấy
            }
        }
        return null;  // Trả về null nếu không tìm thấy
    }

    // Lưu danh sách sinh viên vào file
    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
