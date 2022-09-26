package springdatajpa._nhatminh.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name = "manv")
    private String manv;
    @Column(name = "ten")
    private String ten;
    @Column(name = "luong")
    private int luong;
    //thêm mối quan hệ nhiều nhiều với máy bay phát sinh ra bảng mới , thuộc tính joinColums đại diện cho khoá chính và khoá ngoại hiện đứng ở entity nào thì để khoá chính entity đó vào, thuộc tính invertJoincolums đại diện cho entity hiện không đứng
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chungnhan", joinColumns = {@JoinColumn(name = "manv",referencedColumnName ="manv" )}, inverseJoinColumns = {@JoinColumn(name = "mamb",referencedColumnName = "mamb")})
    private Set<MayBay> mayBays;
    //

    public String getMaNhanVien() {
        return manv;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.manv = maNhanVien;
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
        this.manv = maNhanVien;
        this.ten = ten;
        this.luong = luong;
    }

    public NhanVien(String maNhanVien, String ten, int luong, Set<MayBay> mayBays) {
        this.manv = maNhanVien;
        this.ten = ten;
        this.luong = luong;
        this.mayBays = mayBays;
    }

    public Set<MayBay> getMayBays() {
        return mayBays;
    }

    public void setMayBays(Set<MayBay> mayBays) {
        this.mayBays = mayBays;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + manv + '\'' +
                ", ten='" + ten + '\'' +
                ", luong=" + luong +
                '}';
    }


    public NhanVien() {
    }
}
