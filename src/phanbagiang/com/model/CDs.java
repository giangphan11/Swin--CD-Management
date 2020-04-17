package phanbagiang.com.model;

public class CDs implements Comparable<CDs> {
	private String theLoai;
	private String loai;
	private String tieuDe;
	private double gia;
	private int ma;
	private int namXB;
	static int cdCounter=0;
	

	public CDs() {
		super();
		cdCounter++;
	}
	public CDs(String theLoai, String loai, String tieuDe, double gia, int ma, int namXB) {
		super();
		this.theLoai = theLoai;
		this.loai = loai;
		this.tieuDe = tieuDe;
		this.gia = gia;
		this.ma = ma;
		this.namXB=namXB;
		cdCounter++;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public static int getCdCounter() {
		return cdCounter;
	}
	
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public static void TieuDe() {
		System.out.println("Thể loại\t"+"Loại\t"+"Tiêu đề\t\t"+"Giá\t"+"Mã\t"+"Năm XB");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-16s%-8s%-16s%-8s%-4s%-8s", this.theLoai,this.loai,this.tieuDe,this.gia,this.ma,this.namXB);
	}
	@Override
	public int compareTo(CDs o) {
		// TODO Auto-generated method stub
		if(this.gia<o.gia) {
			return 1;
		}
		else if(this.gia>o.gia) {
			return -1;
		}
		else {
			return this.tieuDe.compareToIgnoreCase(o.tieuDe);
		}
	}
	
}
