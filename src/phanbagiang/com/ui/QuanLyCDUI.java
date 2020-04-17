package phanbagiang.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.keyinfo.X509Data;

import phanbagiang.com.model.CDs;

public class QuanLyCDUI extends JFrame {
	DefaultTableModel dtm = null;
	JTable tblCD = null;

	JComboBox<String> cboTheLoai;
	JComboBox<String> cboLoai;
	JTextField txtTieuDe, txtGia, txtMaSo, txtNamXB;

	JButton btnThem, btnSua, btnXoa, btnTimKiem, btnThoat;
	public static HashSet<CDs> dsCD = null;

	Font font1 = new Font("Arial", Font.TYPE1_FONT, 16);
	Font font2 = new Font("Arial", Font.CENTER_BASELINE, 14);

	CDs cdSelected = null;
	int row;

	public QuanLyCDUI(String title) {
		super(title);
		addControls();
		fakeData();
		addEvents();
	}

	private void fakeData() {
		dsCD = new HashSet<CDs>();
		//
		cboTheLoai.addItem("Game");
		cboTheLoai.addItem("Movie");
		cboTheLoai.addItem("Music");
		//
		cboLoai.addItem("Audio");
		cboLoai.addItem("Video");
		//
		CDs cd1 = new CDs("Game", "Video", "Gangstar vice1", 1000, 1, 2019);
		CDs cd2 = new CDs("Movie", "Video", "Batman 2", 2000, 2, 2020);
		CDs cd3 = new CDs("Music", "Audio", "Way back home", 12000, 3, 2018);
		CDs cd4 = new CDs("Music", "Video", "Calm down", 8000, 4, 2020);
		CDs cd5 = new CDs("Game", "Audio", "Mordem Combat", 9900, 5, 2018);
		CDs cd6 = new CDs("Movie", "Video", "Diep Van4", 99800, 6, 2019);
		CDs cd7 = new CDs("Music", "Audio", "Good bye", 220000, 7, 2017);
		dsCD.add(cd1);
		dsCD.add(cd2);
		dsCD.add(cd3);
		dsCD.add(cd4);
		dsCD.add(cd5);
		dsCD.add(cd6);
		dsCD.add(cd7);
		// convert HashSet-> vector
		hienThiLenBang();

	}

	private void hienThiLenBang() {
		xoaToanBoBang();
		for (CDs x : dsCD) {
			Vector<Object> dsCDVEc = new Vector<Object>();
			dsCDVEc.add(x.getTheLoai());
			dsCDVEc.add(x.getLoai());
			dsCDVEc.add(x.getTieuDe());
			dsCDVEc.add(x.getGia());
			dsCDVEc.add(x.getMa());
			dsCDVEc.add(x.getNamXB());
			dtm.addRow(dsCDVEc);
		}
	}

	private void addEvents() {
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThoat();
			}

			private void xuLyThoat() {
				int cf = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không?", "Xác nhận thoát",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (cf == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else
					return;
			}
		});
		tblCD.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				row = tblCD.getSelectedRow();
				if (row != -1) {
					String theLoai = tblCD.getValueAt(row, 0).toString();
					cboTheLoai.setSelectedItem(theLoai);
					String loai = tblCD.getValueAt(row, 1).toString();
					cboLoai.setSelectedItem(loai);
					String tieuDe = tblCD.getValueAt(row, 2).toString();
					double gia = Double.parseDouble(tblCD.getValueAt(row, 3).toString());
					int ma = Integer.parseInt(tblCD.getValueAt(row, 4).toString());
					int namXB = Integer.parseInt(tblCD.getValueAt(row, 5).toString());
					txtTieuDe.setText(tieuDe);
					txtGia.setText(gia + "");
					txtNamXB.setText(namXB + "");
					txtMaSo.setText(ma + "");
					cdSelected = new CDs(theLoai, theLoai, tieuDe, gia, ma, namXB);
				}
			}
		});
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThem();
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyXoa();

			}
		});
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TimKiemUI ui = new TimKiemUI("Tìm kiếm CD");
				ui.showWindoW();
			}
		});
	}

	private void xuLyXoa() {
		if (txtMaSo.getText().equals(""))
			return;
		else {
			int ma = Integer.parseInt(txtMaSo.getText());
			boolean flag = false;

			// for ko xoa dc phan tu truoc no
			/*
			 * for(CDs x: dsCD) { if(x.getMa()==ma) { dsCD.remove(x); } }
			 */

			Iterator<CDs> i = dsCD.iterator();
			while (i.hasNext()) {
				CDs x = i.next();
				if (x.getMa() == ma) {
					flag = true;
					i.remove();
				}
			}
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "Xoá CD thành công !");
				hienThiLenBang();
			} else {
				JOptionPane.showMessageDialog(null, "Xoá CD thất bại !");
				return;
			}
		}
	}

	private void xoaToanBoBang() {
		int rowCount = dtm.getRowCount();
		// Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dtm.removeRow(i);
		}
	}

	private void xuLyThem() {
		if (txtMaSo.getText().equals("") || txtGia.equals(""))
			return;
		else {
			String theLoai = (String) cboTheLoai.getSelectedItem();
			String loai = (String) cboLoai.getSelectedItem();
			String tieuDe = txtTieuDe.getText();
			Double gia = Double.parseDouble(txtGia.getText());
			int ma = Integer.parseInt(txtMaSo.getText());
			int namXB = Integer.parseInt(txtNamXB.getText());
			CDs cd = new CDs(theLoai, loai, tieuDe, gia, ma, namXB);
			
			boolean flag = false;
			for (CDs x : dsCD) {
				if (x.getMa() == ma) {
					flag = true;
				}
			}
			if (flag == true) {
				JOptionPane.showMessageDialog(null, "Thêm CD thất bại !");
				return;
			} else {
				dsCD.add(cd);
				hienThiLenBang();
				JOptionPane.showMessageDialog(null, "Thêm CD thành công !");
			}
			
		}
	}

	private void addControls() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.DARK_GRAY);
		pnTitle.setLayout(new FlowLayout());
		JLabel lbTitle = new JLabel("Chương trình quản lý CD");
		lbTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lbTitle.setForeground(Color.GREEN);
		pnTitle.add(lbTitle);
		con.add(pnTitle, BorderLayout.NORTH);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		con.add(pnMain, BorderLayout.CENTER);

		JPanel pnMainLeft = new JPanel();
		pnMainLeft.setPreferredSize(new Dimension(300, 0));
		pnMainLeft.setLayout(new BorderLayout());

		JPanel pnLeft = new JPanel();
		pnMainLeft.add(pnLeft, BorderLayout.CENTER);
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());

		JSplitPane pnMain1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnMainLeft, pnRight);
		pnMain.add(pnMain1, BorderLayout.CENTER);

		dtm = new DefaultTableModel();
		dtm.addColumn("Thể loại");
		dtm.addColumn("Loại");
		dtm.addColumn("Tiêu đề");
		dtm.addColumn("Giá");
		dtm.addColumn("Mã");
		dtm.addColumn("Năm XB");
		tblCD = new JTable(dtm);
		tblCD.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));

		JScrollPane scbang = new JScrollPane(tblCD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnRight.add(scbang, BorderLayout.CENTER);
		TitledBorder ttBBangL = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Danh sách bảng đĩa CD",
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
		pnRight.setBorder(ttBBangL);

		JPanel pnTheLoai = new JPanel();
		pnTheLoai.setLayout(new FlowLayout());
		JLabel lbTheLoai = new JLabel("Thể loại:");
		cboTheLoai = new JComboBox<String>();
		cboTheLoai.setPreferredSize(new Dimension(180, 25));
		pnTheLoai.add(lbTheLoai);
		pnTheLoai.add(cboTheLoai);
		pnLeft.add(pnTheLoai);

		JPanel pnLoai = new JPanel();
		pnLoai.setLayout(new FlowLayout());
		JLabel lbLoai = new JLabel("Loại:");
		cboLoai = new JComboBox<String>();
		cboLoai.setPreferredSize(new Dimension(180, 25));
		pnLoai.add(lbLoai);
		pnLoai.add(cboLoai);
		pnLeft.add(pnLoai);

		TitledBorder ttBLe = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Thông tin CD",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
		pnLeft.setBorder(ttBLe);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setLayout(new FlowLayout());
		JLabel lbTieuDe = new JLabel("Tiêu đề:");
		txtTieuDe = new JTextField(16);
		pnTieuDe.add(lbTieuDe);
		pnTieuDe.add(txtTieuDe);
		pnLeft.add(pnTieuDe);

		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout());
		JLabel lbGia = new JLabel("Giá:");
		txtGia = new JTextField(16);
		pnGia.add(lbGia);
		pnGia.add(txtGia);
		pnLeft.add(pnGia);

		JPanel pnMaSo = new JPanel();
		pnMaSo.setLayout(new FlowLayout());
		JLabel lbMaSo = new JLabel("Mã số:");
		txtMaSo = new JTextField(16);
		pnMaSo.add(lbMaSo);
		pnMaSo.add(txtMaSo);
		pnLeft.add(pnMaSo);

		JPanel pnNamXB = new JPanel();
		pnNamXB.setLayout(new FlowLayout());
		JLabel lbNamXB = new JLabel("Năm xuất bản:");
		txtNamXB = new JTextField(16);
		pnNamXB.add(lbNamXB);
		pnNamXB.add(txtNamXB);
		pnLeft.add(pnNamXB);

		lbTheLoai.setFont(font2);
		lbLoai.setFont(font2);
		lbTieuDe.setFont(font2);
		lbGia.setFont(font2);
		lbMaSo.setFont(font2);
		lbNamXB.setFont(font2);

		lbTheLoai.setPreferredSize(lbNamXB.getPreferredSize());
		lbLoai.setPreferredSize(lbNamXB.getPreferredSize());
		lbTieuDe.setPreferredSize(lbNamXB.getPreferredSize());
		lbGia.setPreferredSize(lbNamXB.getPreferredSize());
		lbMaSo.setPreferredSize(lbNamXB.getPreferredSize());
		//

		JPanel pnButtonLeft = new JPanel();
		TitledBorder ttButtonL = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Chức năng",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
		// BorderFactory borderFactory=BorderFactory.createLine

		pnButtonLeft.setLayout(new FlowLayout());
		pnButtonLeft.setBorder(ttButtonL);
		// pnLeft.add(pnButtonLeft);
		pnMainLeft.add(pnButtonLeft, BorderLayout.SOUTH);

		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xoá");
		btnTimKiem = new JButton("Tìm kiếm");
		//
		btnThem.setFont(font1);
		btnSua.setFont(font1);
		btnXoa.setFont(font1);
		btnTimKiem.setFont(font1);

		pnButtonLeft.add(btnThem);
		pnButtonLeft.add(btnSua);
		pnButtonLeft.add(btnXoa);
		pnButtonLeft.add(btnTimKiem);

		JPanel pnButtonMain = new JPanel();
		pnButtonMain.setBackground(Color.DARK_GRAY);
		pnButtonMain.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnMain.add(pnButtonMain, BorderLayout.SOUTH);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(font1);
		// btnThoat.set

		pnButtonMain.add(btnThoat);
	}

	public void showWindow() {
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
