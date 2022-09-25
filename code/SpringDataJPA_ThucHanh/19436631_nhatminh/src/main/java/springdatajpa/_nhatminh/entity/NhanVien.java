package springdatajpa._nhatminh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name = "manv")
    private String maNhanVien;
    @Column(name = "ten")
    private String ten;
    @Column(name = "luong")
    private int luong;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public NhanVien(String maNhanVien, String ten, int luong) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", ten='" + ten + '\'' +
                ", luong=" + luong +
                '}';
    }

    public NhanVien() {
    }
}
