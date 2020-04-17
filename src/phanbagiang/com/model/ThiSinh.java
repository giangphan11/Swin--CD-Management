/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phanbagiang.com.model;


import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Vu Duong
 * Bước 1: Tạo 1 lớp biểu diễn cho đối tượng.
 * tên lớp phải đảm bảo ngắn gọn, rõ ràng và dễ hiểu.
 */
//Bước1: khai báo lớp vàd thuộc tính
public class ThiSinh {
    private String soBD;
    private String hoTen;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
//Bước 2: xây dựng hàm tạo
public ThiSinh() {
    soBD="";hoTen="no-name";diemToan=diemLy=diemHoa=0f;}

public String getSoBD() {
	return soBD;
}

public void setSoBD(String soBD) {
	this.soBD = soBD;
}

public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}

public float getDiemToan() {
	return diemToan;
}

public void setDiemToan(float diemToan) {
	this.diemToan = diemToan;
}

public float getDiemLy() {
	return diemLy;
}

public void setDiemLy(float diemLy) {
	this.diemLy = diemLy;
}

public float getDiemHoa() {
	return diemHoa;
}

public void setDiemHoa(float diemHoa) {
	this.diemHoa = diemHoa;
}

public ThiSinh(String soBD) {
    this.soBD = soBD;
    }
//ghi đè phương thức nhận diện khóa

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.soBD);
        return hash;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThiSinh other = (ThiSinh) obj;
        if (!Objects.equals(this.soBD, other.soBD)) {
            return false;
        }
        return true;
    }
//nhập thông tin ts
public void nhap()
{   Scanner sc=new Scanner(System.in);
    System.out.print("\tNhập số báo danh:");
    soBD=sc.nextLine();
    System.out.print("\tNhập họ tên thí sinh:");
    hoTen=sc.nextLine();
    System.out.print("\tNhập điểm toán:");
    diemToan=sc.nextFloat();
    System.out.print("\tNhập điểm lý:");
    diemLy=sc.nextFloat();
    System.out.print("\tNhập điểm hóa:");
    diemHoa=sc.nextFloat();
}

@Override
public String toString() {
    String tsValue;
    tsValue= "SBD:"+soBD+"\t Ho ten:"+hoTen+"\tdiem toan:"+diemToan+"\t điểm lý";
    tsValue=tsValue +diemLy+"\tđiem hóa"+diemHoa;
    return tsValue;
}
/*
 * Bước 7: Viết các business methods của đối tượng.
Đây là bước quan trọng nhất bởi nó định nghĩa tập các dịch vụ của đối tượng cung cấp cho bên ngoài.
 *
 */
/**
* Kiểm tra 1 thí sinh có đậu hay không
* @return true nếu sinh viên có tổng số điểm trên 15 và không
* có điểm nào dưới 3.
*/
public boolean CheckPassed() {
    return tongDiem()>15 && diemToan>=3&&diemHoa>=3 && diemLy>=3;
}
/**
* Tổng điểm của thí sinh
* @return: tổng điểm
*/
public float tongDiem() {
    return diemHoa+diemLy+diemToan;
}


}
