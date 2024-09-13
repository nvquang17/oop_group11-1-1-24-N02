/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Student {
    private String MSSV; //Mã số sinh viên
    private String name; //Họ và tên
    private String schoolyear; //Khóa
    private String department; //Khoa
    private String lop; //Lớp
    private Date dob; //Sinh nhật
    private String address; //Địa chỉ
    private String gender; //Giới tính
    private String phonenumber; //Số điện thoại

    public Student(){
        
    }
    //Getters
    public String getMSSV() {
        return MSSV;
    }

    public String getName() {
        return name;
    }

    public String getSchoolYear() {
        return schoolyear;
    }

    public String getDepartment() {
        return department;
    }

    public String getLop() {
        return lop;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
    
    public String getPhoneNumber() {
        return phonenumber;
    }

    //Setters
    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchoolYear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    
}
