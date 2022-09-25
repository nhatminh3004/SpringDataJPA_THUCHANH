package springdatajpa._nhatminh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maybay")
public class MayBay {
    @Id
    @Column(name = "mamb")
    private int mamayBay;
    @Column(name = "loai")
    private String loai;
    @Column(name = "tambay")
    private int tamBay;

    public int getMamayBay() {
        return mamayBay;
    }

    public void setMamayBay(int mamayBay) {
        this.mamayBay = mamayBay;
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
        this.mamayBay = mamayBay;
        this.loai = loai;
        this.tamBay = tamBay;
    }

    public MayBay() {
    }

    @Override
    public String toString() {
        return "MayBay{" +
                "mamayBay=" + mamayBay +
                ", loai='" + loai + '\'' +
                ", tamBay=" + tamBay +
                '}';
    }
}
