package DAO;

import DTO.MonHocDTO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {

    private static final String FILE_NAME = "monhoc.dat"; // Tên tệp để lưu trữ môn học
    private List<MonHocDTO> courses = new ArrayList<>(); // Danh sách môn học

    public MonHocDAO() {
        loadCourses(); // Tải danh sách môn học từ tệp
    }

    public List<MonHocDTO> getCourses() {
        return courses;
    }

    // Thêm môn học
    public void addCourse(MonHocDTO course) {
        courses.add(course); // Thêm môn học vào danh sách
        saveCourses(); // Lưu danh sách môn học vào tệp
    }

    // Cập nhật môn học
    public void updateCourse(MonHocDTO course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getMaMonHoc().equals(course.getMaMonHoc())) { // Tìm môn học theo mã
                courses.set(i, course); // Cập nhật môn học
                saveCourses(); // Lưu danh sách sau khi cập nhật
                break;
            }
        }
    }

    // Xóa môn học
    public void deleteCourse(String maMonHoc) {
        courses.removeIf(course -> course.getMaMonHoc().equals(maMonHoc)); // Xóa môn học theo mã
        saveCourses(); // Lưu danh sách sau khi xóa
    }

    // Liệt kê tất cả các môn học
    public List<MonHocDTO> listCourses() {
        return new ArrayList<>(courses); // Trả về danh sách môn học
    }

    // Lấy môn học theo mã
    public MonHocDTO getMonHocById(String maMonHoc) {
        for (MonHocDTO course : courses) {
            if (course.getMaMonHoc().equals(maMonHoc)) { // Kiểm tra mã môn học
                return course; // Trả về môn học tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy môn học
    }

    // Tải danh sách môn học từ tệp
    private void loadCourses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            courses = (List<MonHocDTO>) ois.readObject(); // Đọc danh sách môn học từ tệp
        } catch (FileNotFoundException e) {
            // Tệp không tìm thấy, khởi tạo danh sách rỗng
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }
    }

    // Lưu danh sách môn học vào tệp
    private void saveCourses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(courses); // Ghi danh sách môn học vào tệp
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }
    }
}
