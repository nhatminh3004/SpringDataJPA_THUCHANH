package springdatajpa._nhatminh.entity;

import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBay {
	@Id
	@Column(name = "macb")
	private String maChuyenBay;
	@Column(name = "gadi")
	private String gaDi;
	@Column(name = "gaden")
	private String gaDen;
	@Column(name = "dodai")
	private String doDai;
	@Column(name = "giodi")
	private Time gioDi;
	@Column(name = "gioden")
	private Time gioDen;
	@Column(name = "chiphi")
	private int chiPhi;

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public String getGaDi() {
		return gaDi;
	}

	public void setGaDi(String gaDi) {
		this.gaDi = gaDi;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public String getDoDai() {
		return doDai;
	}

	public void setDoDai(String doDai) {
		this.doDai = doDai;
	}

	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	public Time getGioDen() {
		return gioDen;
	}

	public void setGioDen(Time gioDen) {
		this.gioDen = gioDen;
	}

	public int getChiPhi() {
		return chiPhi;
	}

	public void setChiPhi(int chiPhi) {
		this.chiPhi = chiPhi;
	}

	public ChuyenBay(String maChuyenBay, String gaDi, String gaDen, String doDai, Time gioDi, Time gioDen, int chiPhi) {
		super();
		this.maChuyenBay = maChuyenBay;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.doDai = doDai;
		this.gioDi = gioDi;
		this.gioDen = gioDen;
		this.chiPhi = chiPhi;
	}

	public ChuyenBay() {
		super();
	}

	@Override
	public String toString() {
		return "ChuyenBay [maChuyenBay=" + maChuyenBay + ", gaDi=" + gaDi + ", gaDen=" + gaDen + ", doDai=" + doDai
				+ ", gioDi=" + gioDi + ", gioDen=" + gioDen + ", chiPhi=" + chiPhi + "]";
	}

}
