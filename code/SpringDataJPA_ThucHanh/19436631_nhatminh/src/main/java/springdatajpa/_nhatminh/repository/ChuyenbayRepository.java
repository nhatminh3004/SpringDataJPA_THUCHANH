package springdatajpa._nhatminh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springdatajpa._nhatminh.entity.ChuyenBay;
import springdatajpa._nhatminh.entity.MayBay;

import javax.transaction.Transactional;
import java.util.List;

public interface ChuyenbayRepository extends JpaRepository<ChuyenBay, String> {
    @Modifying
    @Transactional
    @Query(value = "select * from chuyenbay where  gaden like :gaDen   ", nativeQuery = true)
    public List<ChuyenBay> findChuyenBayDiDaLat(@Param("gaDen") String name);
    @Modifying
    @Transactional
    @Query(value = "select * from chuyenbay where  chuyenbay.dodai <10000 and dodai>8000  ", nativeQuery = true)
    public List<ChuyenBay> findChuyenBayDoDaiHon8000andNhoHon10000();
    @Modifying
    @Transactional
    @Query(value = "select * from chuyenbay where  gadi like :gaDi and gaden like :gaDen  ", nativeQuery = true)
    public List<ChuyenBay> findChuyenBayCau5(@Param("gaDi") String gaDi,@Param("gaDen") String gaDen);

    @Transactional
    @Query(value = "select count(*)  from chuyenbay where  gadi like  :gaDi ", nativeQuery = true)
    public int sochuyenBayXuatPhatSaiGon(@Param("gaDi") String gaDi);
    @Query(value = "select macb from chuyenbay where  dodai<(select tambay  from maybay where loai='Airbus A320') ", nativeQuery = true)
    public List<String> chuyenbaythuchienByAirbusA320();
    @Query(value = "select  * from chuyenbay where gadi in (select  gaden from chuyenbay) and gaden in (select  gadi from  chuyenbay) ", nativeQuery = true)
    public List<ChuyenBay> chuyenbayADenBVaQuayVeA();
    @Query(value = "select gadi,count(*) as \"số chuyến bay xuất phát\" from chuyenbay group by  gadi ", nativeQuery = true)
    public List<String> sochuyenbayxuatphatTheoTungGA();
    @Query(value = "select gadi,sum(chiphi) as \"số chi phí phải trả\" from chuyenbay group by  gadi", nativeQuery = true)
    public List<String> tongchiphiphaitraPhiCongCuaTungChuyenBay();
    @Query(value = "select macb from chuyenbay where  giodi<'12:00' group by  macb", nativeQuery = true)
    public List<String> danhsachChuyenBayKhoiHanhTruoc12h();
    @Query(value = "select gadi,count(*) \"Số lượng chuyến bay xuất phát trước 12h\" from chuyenbay where  giodi<'12:00' group by  gadi", nativeQuery = true)
    public List<String> cau21();
    @Query(value = "select  Distinct  cb.* from chuyenbay cb, maybay mb where dodai <mb.tambay and loai like 'Boeing%'", nativeQuery = true)
    public List<ChuyenBay> cau28();
}
