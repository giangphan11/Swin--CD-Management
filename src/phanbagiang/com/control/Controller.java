package phanbagiang.com.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import phanbagiang.com.model.CDs;

public class Controller {
	static Scanner scn=new Scanner(System.in);
	static Scanner scl=new Scanner(System.in);
	static HashSet<CDs>dsCD=new HashSet<CDs>();
	public static void Menu() {
		while(true) {
		System.out.println("============ MENU ===========");
		System.out.println("1. Thêm CD mới");
		System.out.println("2. Tìm kiếm CD theo tên");
		System.out.println("3. Hiển thị danh mục CD");
		System.out.println("4. Sắp xếp CD theo giá giảm dần");
		System.out.println("5. Thoát");
		System.out.println("============ END ==========");
		System.out.print("Mời nhập lựa chọn: ");
		int chon=scn.nextInt();
		if(chon==1) {
			System.out.println("\n=========    THÊM CD MỚI    ==========");
			String theLoai;
			String loai;
			do {
				System.out.print("Nhập thể loại đĩa(game, movie,music): ");
				theLoai=scl.nextLine();
			}
			while(!theLoai.equals("game")&&!theLoai.equals("movie")&&!theLoai.equals("music"));
			do {
				System.out.print("Nhập loại đĩa(audio,video):");
				loai=scl.nextLine();
			}
			while(!loai.equals("audio")&&!loai.equals("video"));
			
			System.out.print("Nhập tiêu đề: ");
			String tieuDe=scl.nextLine();
			System.out.print("Nhập giá: ");
			double gia= scn.nextDouble();
			System.out.print("Nhập mã: ");
			int ma=scn.nextInt();
			System.out.print("Nhập năm xuất bản: ");
			int namXB=scn.nextInt();
			
			CDs cD=new CDs(theLoai, loai, tieuDe, gia, ma,namXB);
			dsCD.add(cD);
		}
		else if(chon ==2) {
			System.out.println("\n=========    TÌM KIẾM    ==========");
			if(dsCD.size()>0) {
				System.out.print("Nhập vào tiêu đề CD: ");
				String tieuDe=scl.nextLine();
				boolean flag=false;
				Iterator<CDs>i=dsCD.iterator();
				while(i.hasNext()) {
					CDs cd=i.next();
					if(cd.getTieuDe().equalsIgnoreCase(tieuDe)) {
						CDs.TieuDe();
						System.out.println(cd);
						flag=true;
					}
				}
				if(flag==false) {
					System.out.println("Không tìm thấy !");
				}
			}
			else {
				System.out.println("Danh sách rỗng !");
			}
		}
		else if(chon==3) {
			System.out.println("\n=========    HIỂN THỊ CHI TIẾT    ==========");
			System.out.println("Số lượng: "+CDs.getCdCounter());
			CDs.TieuDe();
			for(CDs x :dsCD) {
				System.out.println(x);
			}
			
		}
		else if(chon==4) {
			System.out.println("\n=========    SẮP XẾP    ==========");
			ArrayList<CDs>ds=new ArrayList<CDs>();
			ds.addAll(dsCD);
			Collections.sort(ds);
			CDs.TieuDe();
			for(CDs x: ds) {
				System.out.println(x);
			}
		}
		else if(chon==5) {
			System.out.println("Tạm biệt !!!");
			break;
		}
		}
	}
}
