
package model;


public class SinhVien {
    private long id;
    private String ma;
    private String hoten;
    private double diem;
    private String nganh;
    private int gioitinh;

    public SinhVien() {
    }

    public SinhVien(String ma, String hoten, double diem, String nganh, int gioitinh) {
        this.ma = ma;
        this.hoten = hoten;
        this.diem = diem;
        this.nganh = nganh;
        this.gioitinh = gioitinh;
    }

    public SinhVien(long id, String ma, String hoten, double diem, String nganh, int gioitinh) {
        this.id = id;
        this.ma = ma;
        this.hoten = hoten;
        this.diem = diem;
        this.nganh = nganh;
        this.gioitinh = gioitinh;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }
    public Object[] toDataRow(){
        return new Object[]{
            this.id,this.getMa(),this.hoten,this.diem,this.nganh,this.gioitinh
        };
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", ma=" + ma + ", hoten=" + hoten + ", diem=" + diem + ", nganh=" + nganh + ", gioitinh=" + gioitinh + '}';
    }

    public Object getGenderAsString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
