package service;

import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;

public class SinhVienService {

    List<SinhVien> listSV;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SinhVien> getAll() {
        listSV = new ArrayList<>();
        //lấy toàn bộ dữ liệu từ bảng trong sql sang list
        sql = "select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//thực thi câu lệnh sql
            //lấy kế quả câu select trả về rs
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();//in ra tất cả các lỗi
            return null;
        }
    }

    public int insertSV(SinhVien sv) {
        //tra ve so dong duoc them moi
        sql = "insert into sinhvien(masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh)values\n"
                + "(?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getMa());
            ps.setString(2, sv.getHoten());
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getNganh());
            ps.setInt(5, sv.getGioitinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int deleteSV(String ma) {
        sql = "delete from sinhvien where masinhvien like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) { //khong xoa duoc
            e.printStackTrace();
        }
        return 0;
    }

    public int updateSV(String ma, SinhVien sv) {
        sql = "update sinhvien set \n"
                + "hoten=?,diemtrungbinh=?,nganhhoc=?, gioitinh=?\n"
                + "where masinhvien like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getHoten());
            ps.setDouble(2, sv.getDiem());
            ps.setString(3, sv.getNganh());
            ps.setInt(4, sv.getGioitinh());
            ps.setString(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<SinhVien> timTheoTen(String ten) {
        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = " select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien where hoten like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }
            return listSV;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<SinhVien> filterByGender(int gender) {

        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = "SELECT * FROM sinhvien WHERE gioitinh = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, gender);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<SinhVien> sortByDiemFromDB() {

        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = "SELECT * FROM sinhvien ORDER BY diemtrungbinh DESC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  
    public static void main(String[] args) {
        SinhVienService ss = new SinhVienService();
        List<SinhVien> kq = ss.getAll();
        for (SinhVien sinhVien : kq) {
            System.out.println(sinhVien.toString());

        }
    }

}
