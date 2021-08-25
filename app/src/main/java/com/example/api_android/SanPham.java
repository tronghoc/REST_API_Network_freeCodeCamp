package com.example.api_android;

public class SanPham {
    String HoTen;
    Integer Gia;
    String Hinh;

    public SanPham(String hoTen, Integer gia, String hinh) {
        HoTen = hoTen;
        Gia = gia;
        Hinh = hinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer gia) {
        Gia = gia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }
}
