package com.example.thuyltph35992_thi1212.DTO;

public class DiemDanhDTO {
    private  int id;
    private String MaSV;
    private String HoTen;
    private String Email;
    private int Tong_vang;

    public DiemDanhDTO() {
    }

    public DiemDanhDTO(int id, String maSV, String hoTen, String email, int tong_vang) {
        this.id = id;
        MaSV = maSV;
        HoTen = hoTen;
        Email = email;
        Tong_vang = tong_vang;
    }
    public DiemDanhDTO(String maSV, String hoTen, String email, int tong_vang) {
        MaSV = maSV;
        HoTen = hoTen;
        Email = email;
        Tong_vang = tong_vang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getTong_vang() {
        return Tong_vang;
    }

    public void setTong_vang(int tong_vang) {
        Tong_vang = tong_vang;
    }
}
