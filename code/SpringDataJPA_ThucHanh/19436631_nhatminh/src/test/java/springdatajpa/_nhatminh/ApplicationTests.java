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

    @Test
        //Cho biết tên phí công lái máy bay Boeing
    void cau15() {

        List<String> listNamePhiCongBoeing = nhanvienService.findTenPhiCongLaiBoeing();
        System.out.println("Danh sách Phi Công lái máy bay Boeing : ");
        for (String name : listNamePhiCongBoeing) {

            System.out.println(name);

        }
    }

    @Test
        //Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
    void cau16() {

        List<String> listThongTinMayBay = maybayService.findvoiMoiLoaimaybayChoBietMaSoAndLoaiAndSoPhiCongCoTheLai();
        System.out.println("Danh sách thông tin máy bay và loại tương ứng với số phi công có thể lái : ");
        for (String info : listThongTinMayBay) {

            System.out.println(info);

        }
    }

    @Test
        //Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
    void cau17() {
        List<ChuyenBay> danhSachChuyenBayDapUngNhuCau = chuyenbayService.chuyenbayADenBVaQuayVeA();
        System.out.println("Danh sách chuyến bay A đến B rồi về A  : ");

        for (ChuyenBay chuyenBay : danhSachChuyenBayDapUngNhuCau) {

            System.out.println(chuyenBay);
        }
    }

    @Test
        //Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
    void cau18() {

        List<String> listThongTinChuyenBay = chuyenbayService.sochuyenbayxuatphatTheoTungGA();
        System.out.println("Danh sách số chuyến bay xuất phát theo từng ga : : ");
        for (String info : listThongTinChuyenBay) {

            System.out.println(info);

        }
    }

    @Test
        //Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
    void cau19() {

        List<String> listchiphiPhaiTraChoTungChuyenBay = chuyenbayService.tongchiphiphaitraPhiCongCuaTungChuyenBay();
        System.out.println("Tổng chi phí phải trả cho từng chuyến bay : ");
        for (String info : listchiphiPhaiTraChoTungChuyenBay) {

            System.out.println(info);

        }
    }

    @Test
        //	Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
    void cau20() {

        List<String> listChuyenBayKhoiHanhTruoc12h = chuyenbayService.danhsachChuyenBayKhoiHanhTruoc12h();
        System.out.println("Danh sách chuyến bay khởi hành trước 12h : ");
        for (String cb : listChuyenBayKhoiHanhTruoc12h) {

            System.out.println(cb);

        }
    }

    @Test
        //	Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
    void cau21() {

        List<String> listChuyenBayKhoiHanhTruoc12h = chuyenbayService.cau21();
        System.out.println("Danh sách chuyến bay khởi hành trước 12h theo từng địa điểm : ");
        for (String cb : listChuyenBayKhoiHanhTruoc12h) {

            System.out.println(cb);

        }
    }

    @Test
        //		Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    void cau22() {

        List<String> listmasoPhiCong3MayBay = nhanvienService.findNhanVienLaiDuoc3LoaiMayBay();
        System.out.println(" Mã số của các phi công chỉ lái được 3 loại máy bay : ");
        for (String nv : listmasoPhiCong3MayBay) {

            System.out.println(nv);

        }
    }

    @Test
        //Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.
    void cau23() {

        List<String> list = nhanvienService.cau23();
        System.out.println(" Danh sách phi công có thể lái nhiều hơn 3 loại máy bay có tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái : ");
        for (String nv : list) {

            System.out.println(nv);

        }
    }

    @Test
        //Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái
    void cau24() {

        List<String> list = nhanvienService.cau24();
        System.out.println(" Mã phi công và tổng só loại máy bay có thể lái : ");
        for (String nv : list) {

            System.out.println(nv);

        }
    }

    @Test
        //Tìm nhân viên không phải là phi công
    void cau25() {

        List<NhanVien> listNhanVienKhongPhaiPhiCong = nhanvienService.findNhanVienKhongPhaiPhiCong();
        System.out.println(" Danh sách nhân viên không phải phi công : ");
        for (NhanVien nv : listNhanVienKhongPhaiPhiCong) {

            System.out.println(nv);

        }
    }

    @Test
        //Tìm nhân viên  có lương cao nhất
    void cau26() {

        List<String> list = nhanvienService.findNhanVienLuongCaoNhat();

        System.out.println(" Nhân viên có lương cao nhất là  : ");
        System.out.println("Mã nhân viên - Lương");
        for (String nv : list) {

            System.out.println(nv);

        }
    }

    @Test
        //Tổng lương phải trả cho nhân viên
    void cau27() {

        List<String> list = nhanvienService.tongLuongTraNhanVien();


        System.out.println("Tổng lương phải trả cho nhân viên là : " + list);

    }
    @Test
        //28.Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing.
    void cau28() {
        List<ChuyenBay> list = chuyenbayService.cau28();
        System.out.println("Các chuyến bay được thực hiện bởi tất cả loại máy bay Boeing là : " );
        for(ChuyenBay  cb : list){
            System.out.println(cb);
        }
    }


}
