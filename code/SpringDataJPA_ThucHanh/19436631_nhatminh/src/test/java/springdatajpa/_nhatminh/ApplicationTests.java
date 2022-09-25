package springdatajpa._nhatminh;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import springdatajpa._nhatminh.entity.ChuyenBay;
import springdatajpa._nhatminh.entity.MayBay;
import springdatajpa._nhatminh.entity.NhanVien;
import springdatajpa._nhatminh.repository.ChuyenbayRepository;
import springdatajpa._nhatminh.repository.MayBayRepository;
import springdatajpa._nhatminh.repository.NhanVienRepository;

@SpringBootTest
class ApplicationTests {
    @Autowired
    ChuyenbayRepository chuyenbayService;

    @Autowired
    MayBayRepository maybayService;

    @Autowired
    NhanVienRepository nhanvienService;


    @Test
        //cho biết các chuyến bay đi Đà lạt (DAD)
    void cau1() {
        List<ChuyenBay> danhSachChuyenBayDiDaLat = chuyenbayService.findChuyenBayDiDaLat("DAD");
        System.out.println("Danh sách chuyến bay đi Đà Lạt : ");
        for (ChuyenBay cb : danhSachChuyenBayDiDaLat) {
            System.out.println(cb);
        }
    }

    @Test
        //cho biết các máy bay có tầm bay >10000km
    void cau2() {
        List<MayBay> danhSachMayBay = maybayService.findMayBayTamBayHon10000();
        System.out.println("Danh sách máy bay có tầm bay hơn 10000km : ");
        for (MayBay cb : danhSachMayBay) {
            System.out.println(cb);
        }
    }
    @Test
        //cho biết Nhân viên có lương <10000
    void cau3() {
        List<NhanVien> danhSachNhanVien = nhanvienService.findNhanVienLuongNhoHon10000();
        System.out.println("Danh sách nhân viên có lương nhỏ hơn 10000 : ");
        for (NhanVien nv : danhSachNhanVien) {
            System.out.println(nv);
        }
    }
    @Test
        //cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10000km và lớn hơn 8000 km
    void cau4() {
        List<ChuyenBay> danhSachChuyenBay = chuyenbayService.findChuyenBayDoDaiHon8000andNhoHon10000();
        System.out.println("Danh sách chuyến bay  : ");
        for (ChuyenBay cb : danhSachChuyenBay) {
            System.out.println(cb);
        }
    }
    @Test
        //Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    void cau5() {
        List<ChuyenBay> danhSachChuyenBay = chuyenbayService.findChuyenBayCau5("SGN","BMV");
        System.out.println("Danh sách chuyến bay xuất phát Sài Gòn và đi Ban Mê Thuộc  : ");
        for (ChuyenBay cb : danhSachChuyenBay) {
            System.out.println(cb);
        }
    }
    @Test
        //Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    void cau6() {
  int soChuyenBayDiSaiGon = chuyenbayService.sochuyenBayXuatPhatSaiGon("SGN");
        System.out.println("Số chuyến bay xuất phát Sài Gòn và đi Ban Mê Thuộc  : " +soChuyenBayDiSaiGon);

    }

}
