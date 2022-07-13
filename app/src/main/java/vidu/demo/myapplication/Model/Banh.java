package vidu.demo.myapplication.Model;

import java.io.Serializable;

public class Banh implements Serializable {
    private int id ;
    private String AnhSP;
    private String TenSP;
    private int Gia ;
    private String ChiTietSP;

    public Banh() {
    }

    public Banh(int id, String anhSP, String tenSP, int gia, String chiTietSP) {
        this.id = id;
        AnhSP = anhSP;
        TenSP = tenSP;
        Gia = gia;
        ChiTietSP = chiTietSP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnhSP() {
        return AnhSP;
    }

    public void setAnhSP(String anhSP) {
        AnhSP = anhSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public String getChiTietSP() {
        return ChiTietSP;
    }

    public void setChiTietSP(String chiTietSP) {
        ChiTietSP = chiTietSP;
    }
}
