package com.example.son.quanlysach_duanmau.model;

public class NguoiDung {
    public String userName;
    public String passWord;
    public String phone;
    public String fullName;

    public NguoiDung() {
    }

    public NguoiDung(String userName, String passWord, String phone, String fullName) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String toString() {
        return "NguoiDung{" +
                "userName='" + userName + '\'' +
                ",passWord='" + passWord + '\'' +
                ",phone='" + phone + '\'' + "," +
                ",hoTen='" + fullName + '\'' + '}';
    }
}
