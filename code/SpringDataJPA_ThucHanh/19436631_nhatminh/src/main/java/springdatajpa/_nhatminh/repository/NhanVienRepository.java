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
}
