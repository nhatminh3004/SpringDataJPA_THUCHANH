package springdatajpa._nhatminh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springdatajpa._nhatminh.entity.ChuyenBay;
import springdatajpa._nhatminh.entity.MayBay;

import javax.transaction.Transactional;
import java.util.List;

public interface MayBayRepository extends JpaRepository<MayBay, Integer> {
    @Modifying
    @Transactional
    @Query(value = "select * from maybay where  tambay >10000   ", nativeQuery = true)
    public List<MayBay> findMayBayTamBayHon10000();

    @Transactional
    @Query(value = "select count(*) from maybay where loai like 'Boeing%'   ", nativeQuery = true)
    public int findSoMayBayBoeing();
    @Transactional
    @Query(value = "select  maybay.mamb from nhanvien inner join chungnhan  on nhanvien.manv = chungnhan.manv inner join maybay  on maybay.mamb = chungnhan.mamb where nhanvien.ten like  'Nguyen%'   ", nativeQuery = true)
    public List<String> maMayBayNhanVienHoNGUYENLAI();
    @Query(value = "select * from maybay where  tambay > (select  dodai from  chuyenbay where  macb='VN280') ", nativeQuery = true)
    public List<String> maMayBayThucHienDuongBayVn280();
    @Query(value = "select c.mamb,mb.loai,count(c.manv) AS \"Tổng số phi công có thể lái máy bay\" from maybay mb join chungnhan c on mb.mamb = c.mamb group by  c.mamb, mb.loai ", nativeQuery = true)
    public List<String> findvoiMoiLoaimaybayChoBietMaSoAndLoaiAndSoPhiCongCoTheLai();
}
