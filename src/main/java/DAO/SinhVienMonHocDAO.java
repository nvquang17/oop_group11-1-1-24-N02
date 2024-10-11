package DAO;

import DTO.MonHocDTO;
import DTO.SinhVienDTO;
import DTO.SinhVienMonHocDTO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienMonHocDAO {

    private static final String FILE_NAME = "sinhvienmonhoc.dat";
    public static List<SinhVienMonHocDTO> sinhVienMonHocList = new ArrayList<>();

    public SinhVienMonHocDAO() {
        loadSinhVienMonHoc();
    }

    // Thêm sinh viên - môn học
    public void addSinhVienMonHoc(SinhVienMonHocDTO sinhVienMonHoc) {
        sinhVienMonHocList.add(sinhVienMonHoc);
        saveSinhVienMonHoc();
    }

    // Cập nhật thông tin sinh viên - môn học
    public void updateSinhVienMonHoc(SinhVienMonHocDTO sinhVienMonHoc) {
        for (int i = 0; i < sinhVienMonHocList.size(); i++) {
            if (sinhVienMonHocList.get(i).getMaSinhVien().equals(sinhVienMonHoc.getMaSinhVien())
                    && sinhVienMonHocList.get(i).getMaMonHoc().equals(sinhVienMonHoc.getMaMonHoc())) {
                sinhVienMonHocList.set(i, sinhVienMonHoc);
                saveSinhVienMonHoc();
                break;
            }
        }
    }

// Xóa sinh viên - môn học theo mã sinh viên và mã môn học
    public boolean deleteSinhVienMonHoc(String maSinhVien, String maMonHoc) {
        boolean isDeleted = sinhVienMonHocList.removeIf(svMonHoc
                -> svMonHoc.getMaSinhVien().equals(maSinhVien) && svMonHoc.getMaMonHoc().equals(maMonHoc)
        );

        // Lưu lại danh sách sau khi xóa
        if (isDeleted) {
            saveSinhVienMonHoc();
        }

        return isDeleted; // Trả về true nếu xóa thành công, ngược lại false
    }

    // Liệt kê tất cả sinh viên - môn học
    public List<SinhVienMonHocDTO> listAll() {
        return new ArrayList<>(sinhVienMonHocList);
    }

    // Tải danh sách sinh viên - môn học từ tệp
    private void loadSinhVienMonHoc() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            sinhVienMonHocList = (List<SinhVienMonHocDTO>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Tệp không tồn tại, khởi tạo danh sách rỗng
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Lưu danh sách sinh viên - môn học vào tệp
    private void saveSinhVienMonHoc() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(sinhVienMonHocList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SinhVienMonHocDTO> getRegisteredCourses(String maSinhVien) {
        List<SinhVienMonHocDTO> registeredCourses = new ArrayList<>(); // List to hold registered courses

        // Iterate through the list of student-course registrations
        for (SinhVienMonHocDTO svMonHoc : sinhVienMonHocList) {
            // Check if the student ID matches
            if (svMonHoc.getMaSinhVien().equals(maSinhVien)) {
                registeredCourses.add(svMonHoc); // Add the registered course to the list
            }
        }

        return registeredCourses; // Return the list of registered courses
    }

    public List<MonHocDTO> getUnregisteredCourses(String maSinhVien) {
        List<MonHocDTO> unregisteredCourses = new ArrayList<>(); // Danh sách môn học chưa đăng ký
        MonHocDAO monHocDAO = new MonHocDAO();
        // Duyệt qua tất cả các môn học
        for (MonHocDTO course : monHocDAO.getCourses()) {
            boolean isRegistered = false;
            // Kiểm tra xem sinh viên đã đăng ký môn học này chưa
            for (SinhVienMonHocDTO svMonHoc : sinhVienMonHocList) {
                if (svMonHoc.getMaSinhVien().equals(maSinhVien)
                        && svMonHoc.getMaMonHoc().equals(course.getMaMonHoc())) {
                    isRegistered = true; // Đã đăng ký
                    break;
                }
            }
            // Nếu sinh viên chưa đăng ký môn học này, thêm vào danh sách chưa đăng ký
            if (!isRegistered) {
                unregisteredCourses.add(course);
            }
        }
        return unregisteredCourses; // Trả về danh sách môn học chưa đăng ký
    }

    public List<SinhVienMonHocDTO> getStudentsByCourse(String maMonHoc) {
        List<SinhVienMonHocDTO> registeredStudents = new ArrayList<>(); // List to hold registered student-course registrations

        // Iterate through the list of registrations
        for (SinhVienMonHocDTO registration : sinhVienMonHocList) {
            // Check if the course ID matches the given course ID
            if (registration.getMaMonHoc().equals(maMonHoc)) {
                registeredStudents.add(registration); // Add the registration to the list
            }
        }
        return registeredStudents; // Return the list of registered student-course registrations
    }

    // Duyệt đăng ký của sinh viên
    public void approveRegistration(String maSinhVien, String maMonHoc) {
        for (SinhVienMonHocDTO svMonHoc : sinhVienMonHocList) {
            if (svMonHoc.getMaSinhVien().equals(maSinhVien) && svMonHoc.getMaMonHoc().equals(maMonHoc)) {
                svMonHoc.setDangKyDuocDuyet(true); // Đánh dấu đăng ký là đã duyệt
                saveSinhVienMonHoc(); // Lưu lại thay đổi
                break; // Thoát khỏi vòng lặp khi đã tìm thấy
            }
        }
    }

// Cập nhật điểm cho sinh viên
    public void updateScores(String maSinhVien, String maMonHoc, Double diemQuaTrinh, Double diemKetThuc) {
        for (SinhVienMonHocDTO svMonHoc : sinhVienMonHocList) {
            if (svMonHoc.getMaSinhVien().equals(maSinhVien) && svMonHoc.getMaMonHoc().equals(maMonHoc)) {
                svMonHoc.setDiemQuaTrinh(diemQuaTrinh); // Cập nhật điểm quá trình
                svMonHoc.setDiemKetThuc(diemKetThuc); // Cập nhật điểm kết thúc
                saveSinhVienMonHoc(); // Lưu lại thay đổi
                break; // Thoát khỏi vòng lặp khi đã tìm thấy
            }
        }
    }
    public Double calculateAverageScore(String maSinhVien) {
        double totalScore = 0.0; // Variable to hold total score
        int count = 0; // Count of registered courses

        // Iterate through the list of registrations for the specified student
        for (SinhVienMonHocDTO svMonHoc : sinhVienMonHocList) {
            if (svMonHoc.getMaSinhVien().equals(maSinhVien)) {
                // Only include valid scores for average calculation
                if (svMonHoc.getDiemKetThuc() != null) {
                    totalScore += svMonHoc.tinhDiemTongKet(); // Use tinhDiemTongKet() to get the final score
                    count++; // Increment count of valid scores
                }
            }
        }

        // If no courses found, return null or 0.0
        if (count == 0) {
            return null; // or return 0.0; based on your preference
        }

        // Calculate and return the average score
        return totalScore / count;
    }

}
