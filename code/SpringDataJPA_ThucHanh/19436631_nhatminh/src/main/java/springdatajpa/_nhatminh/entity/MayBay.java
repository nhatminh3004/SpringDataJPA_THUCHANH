package springdatajpa._nhatminh.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "maybay")
public class MayBay {
    @Id
    @Column(name = "mamb")
    private int mamb;
    @Column(name = "loai")
    private String loai;
    @Column(name = "tambay")
    private int tamBay;
    //thêm mối quan hệ nhiều nhiều với nhân viên
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chungnhan", joinColumns = {@JoinColumn(name = "mamb",referencedColumnName ="mamb" )}, inverseJoinColumns = {@JoinColumn(name = "manv",referencedColumnName = "manv")})
    private Set<NhanVien> nhanViens;
    //

    public int getMamayBay() {
        return mamb;
    }

    public void setMamayBay(int mamayBay) {
        this.mamb = mamayBay;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getTamBay() {
        return tamBay;
    }

    public void setTamBay(int tamBay) {
        this.tamBay = tamBay;
    }

    public MayBay(int mamayBay, String loai, int tamBay) {
        this.mamb = mamayBay;
        this.loai = loai;
        this.tamBay = tamBay;
    }

    public Set<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public MayBay() {
    }

    public MayBay(int mamayBay, String loai, int tamBay, Set<NhanVien> nhanViens) {
        this.mamb= mamayBay;
        this.loai = loai;
        this.tamBay = tamBay;
        this.nhanViens = nhanViens;
    }

    @Override
    public String toString() {
        return "MayBay{" +
                "mamayBay=" + mamb +
                ", loai='" + loai + '\'' +
                ", tamBay=" + tamBay +
                '}';
    }
}
