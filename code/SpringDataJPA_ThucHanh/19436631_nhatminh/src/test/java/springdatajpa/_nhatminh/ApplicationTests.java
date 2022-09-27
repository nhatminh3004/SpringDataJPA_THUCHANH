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
        List<ChuyenBay> danhSachChuyenBay = chuyenbayService.findChuyenBayCau5("SGN", "BMV");
        System.out.println("Danh sách chuyến bay xuất phát Sài Gòn và đi Ban Mê Thuộc  : ");
        for (ChuyenBay cb : danhSachChuyenBay) {
            System.out.println(cb);
        }
    }

    @Test
        //Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    void cau6() {
        int soChuyenBayDiSaiGon = chuyenbayService.sochuyenBayXuatPhatSaiGon("SGN");
        System.out.println("Số chuyến bay xuất phát Sài Gòn và đi Ban Mê Thuộc  : " + soChuyenBayDiSaiGon);

    }

    @Test
        //Có bao nhiêu loại máy báy Boeing.
    void cau7() {
        int soMayBayBoeing = maybayService.findSoMayBayBoeing();
        System.out.println("Số máy bay Boeing  : " + soMayBayBoeing);

    }

    @Test
        //Cho biết tổng số lương phải trả cho các nhân viên.
    void cau8() {
        int tongsoLuong = nhanvienService.tongsoluongtraNhanVien();
        System.out.println("Tổng số lương phải trả cho các nhân viên  : " + tongsoLuong);

    }

    @Test
        //Cho biết mã số của các phi công lái máy bay Boeing
    void cau9() {
        int i = 0;
        List<String> masonhanvienLaiBoeing = nhanvienService.manhanvienLaiMayBayBoeing();
        System.out.println("Danh sách mã nhân viên lái máy bay Boeing");
        for (String manv : masonhanvienLaiBoeing) {
            i++;
            System.out.println("mã nhân viên" + i + ": " + manv);

        }
    }

    @Test
        //Cho biết các nhân viên có thể lái máy bay có mã số 747
    void cau10() {
        List<NhanVien> danhSachNhanVienLai747 = nhanvienService.findNhanVienBoeing747();
        System.out.println("Danh sách nhân viên lái máy bay mã số 747  : ");

        for (NhanVien nv : danhSachNhanVienLai747) {

            System.out.println(nv);
        }
    }

    @Test
        //Cho biết mã máy bay mà nhân viên họ NGuyễn có thể Lái
    void cau11() {

        List<String> mamayBays = maybayService.maMayBayNhanVienHoNGUYENLAI();
        System.out.println("Danh sách mã máy bay nhân viên họ Nguyễn có thể lái");
        for (String mamb : mamayBays) {

            System.out.println(mamb);

        }
    }
    @Test
        //Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus
    void cau12() {

        List<String> maPhiCongs = nhanvienService.findMaSoPhiCongBoeingAndAirbus();
        System.out.println("Danh sách mã phi công lái được Boeing và Airbus : ");
        for (String maphiCong : maPhiCongs) {

            System.out.println(maphiCong);

        }
    }
    @Test
        //Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    void cau13() {

        List<String> listMayBay = maybayService.maMayBayThucHienDuongBayVn280();
        System.out.println("Danh sách máy bay thực hiện được chuyến bay VN280 : ");
        for (String maybay : listMayBay) {

            System.out.println(maybay);

        }
    }
    @Test
        //Cho biết các chuyến bay có thể được thực hiện bởi máy bay Airbus A320
    void cau14() {

        List<String> listChuyenBay = chuyenbayService.chuyenbaythuchienByAirbusA320();
        System.out.println("Danh sách chuyến bay được thực hiện bởi Airbus A320 : ");
        for (String cb : listChuyenBay) {

            System.out.println(cb);

        }
    }


}
