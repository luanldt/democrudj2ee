package democrud.model;
// Generated Apr 1, 2017 3:11:16 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Systemuser generated by hbm2java
 */
public class Systemuser  implements java.io.Serializable {


     private int id;
     private String maNhanVien;
     private String ho;
     private String ten;
     private String matKhau;
     private Integer gioiTinh;
     private Date ngaySinh;
     private String noiSinh;
     private String diaChiThuongTru;
     private String diaChiTamTru;
     private String hinhAnh;
     private Set<Userdiploma> userdiplomas = new HashSet(0);

    public Systemuser() {
    }

	
    public Systemuser(int id) {
        this.id = id;
    }
    public Systemuser(int id, String maNhanVien, String ho, String ten, String matKhau, Integer gioiTinh, Date ngaySinh, String noiSinh, String diaChiThuongTru, String diaChiTamTru, String hinhAnh, Set userdiplomas) {
       this.id = id;
       this.maNhanVien = maNhanVien;
       this.ho = ho;
       this.ten = ten;
       this.matKhau = matKhau;
       this.gioiTinh = gioiTinh;
       this.ngaySinh = ngaySinh;
       this.noiSinh = noiSinh;
       this.diaChiThuongTru = diaChiThuongTru;
       this.diaChiTamTru = diaChiTamTru;
       this.hinhAnh = hinhAnh;
       this.userdiplomas = userdiplomas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getMaNhanVien() {
        return this.maNhanVien;
    }
    
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getHo() {
        return this.ho;
    }
    
    public void setHo(String ho) {
        this.ho = ho;
    }
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getMatKhau() {
        return this.matKhau;
    }
    
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public Integer getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getNoiSinh() {
        return this.noiSinh;
    }
    
    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }
    public String getDiaChiThuongTru() {
        return this.diaChiThuongTru;
    }
    
    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }
    public String getDiaChiTamTru() {
        return this.diaChiTamTru;
    }
    
    public void setDiaChiTamTru(String diaChiTamTru) {
        this.diaChiTamTru = diaChiTamTru;
    }
    public String getHinhAnh() {
        return this.hinhAnh;
    }
    
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public Set<Userdiploma> getUserdiplomas() {
        return this.userdiplomas;
    }
    
    public void setUserdiplomas(Set<Userdiploma> userdiplomas) {
        this.userdiplomas = userdiplomas;
    }




}


