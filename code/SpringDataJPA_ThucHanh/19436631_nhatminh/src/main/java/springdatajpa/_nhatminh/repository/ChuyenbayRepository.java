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
}
