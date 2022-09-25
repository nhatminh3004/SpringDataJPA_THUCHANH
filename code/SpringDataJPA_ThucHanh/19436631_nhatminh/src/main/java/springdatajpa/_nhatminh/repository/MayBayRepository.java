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
}
