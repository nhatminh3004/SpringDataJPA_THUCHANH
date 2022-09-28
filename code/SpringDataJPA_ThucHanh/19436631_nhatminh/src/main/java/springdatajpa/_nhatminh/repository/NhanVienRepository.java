package springdatajpa._nhatminh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springdatajpa._nhatminh.entity.MayBay;
import springdatajpa._nhatminh.entity.NhanVien;

import javax.transaction.Transactional;
import java.util.List;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Modifying
    @Transactional
    @Query(value = "select * from nhanvien where  luong <10000  ", nativeQuery = true)
    public List<NhanVien> findNhanVienLuongNhoHon10000();
    @Transactional
    @Query(value = " select sum(luong) from nhanvien", nativeQuery = true)
    public int  tongsoluongtraNhanVien();

    @Query(value = " select  nhanvien.manv from nhanvien inner join chungnhan  on nhanvien.manv = chungnhan.manv inner join maybay  on maybay.mamb = chungnhan.mamb where  loai like 'Boeing%'", nativeQuery = true)
    public List<String> manhanvienLaiMayBayBoeing();
    @Modifying
    @Transactional
    @Query(value = "select nhanvien.manv,nhanvien.ten,nhanvien.luong from nhanvien inner join chungnhan  on nhanvien.manv = chungnhan.manv inner join maybay  on maybay.mamb = chungnhan.mamb where loai like 'Boeing 747%' ", nativeQuery = true)
    public List<NhanVien> findNhanVienBoeing747();

    @Query(value = "select Distinct  c.manv from maybay mb inner join chungnhan c on mb.mamb = c.mamb inner join nhanvien nv on c.manv = nv.manv where  loai like 'Boeing%' or loai like 'Airbus%'", nativeQuery = true)
    public List<String> findMaSoPhiCongBoeingAndAirbus();
    @Query(value = "select DISTINCT nhanvien.ten from nhanvien join chungnhan c on nhanvien.manv = c.manv join maybay m on m.mamb = c.mamb where  loai like 'Boeing%'", nativeQuery = true)
    public List<String> findTenPhiCongLaiBoeing();
    @Query(value = "select nhanvien.manv from nhanvien join chungnhan c on nhanvien.manv = c.manv group by nhanvien.manv having count(c.mamb)=3", nativeQuery = true)
    public List<String> findNhanVienLaiDuoc3LoaiMayBay();
    @Query(value = "SELECT  cn.MaNV, TamBay,loai FROM NHANVIEN nv, MAYBAY mb, CHUNGNHAN cn WHERE nv.MaNV = cn.MaNV AND mb.MaMB = cn.MaMB AND cn.MaNV IN (SELECT nv.MaNV FROM NHANVIEN nv, CHUNGNHAN cn WHERE nv.MaNV = cn.MaNV GROUP BY nv.MaNV HAVING COUNT(MAMB) > 3)\n", nativeQuery = true)
    public List<String> cau23();
    @Query(value = "select nv.manv,count(mb.mamb) as \"Tổng số  loại máy bay phi công có thể lái\" from nhanvien nv inner join chungnhan c on nv.manv = c.manv join maybay mb on mb.mamb = c.mamb\n" +
            "and  nv.manv in (select c1.manv from chungnhan c1) group by nv.manv", nativeQuery = true)
    public List<String> cau24();
    @Query(value = "select * from nhanvien where  manv not in (select cn.manv from chungnhan cn)", nativeQuery = true)
    public List<NhanVien> findNhanVienKhongPhaiPhiCong();
    @Query(value = "select   n.manv,n.luong  from nhanvien n  where  n.manv in (select  c.manv from  chungnhan c) and  luong in (select max(n2.luong) from nhanvien n2)", nativeQuery = true)
    public List<String> findNhanVienLuongCaoNhat();
    @Query(value = "select sum(luong) from nhanvien", nativeQuery = true)
    public List<String> tongLuongTraNhanVien();
}
