package phanbagiang.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import phanbagiang.com.model.CDs;

public class TimKiemUI extends JDialog {
	JTextField txtTk;
	JButton btnTimKim;
	
	DefaultTableModel dtm=null;
	JTable tblTimKim=null;
	
	HashSet<CDs>dsCD=QuanLyCDUI.dsCD;
	
	public TimKiemUI(String title) {
		this.setTitle(title);
		addControls();
		addEvents();
		
	}
	private void addEvents() {
		btnTimKim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyTimKiem();
			}
		});
	}
	private void xuLyTimKiem() {
		String tk=txtTk.getText();
		if(tk.equals(""))
			return;
		else {
			xoaToanBoBang();
			for(CDs x :dsCD) {
				if(x.getTheLoai().equalsIgnoreCase(tk)||x.getLoai().equalsIgnoreCase(tk)) {
					Vector<Object>dsCDVEc=new Vector<Object>();
					dsCDVEc.add(x.getTheLoai());
					dsCDVEc.add(x.getLoai());
					dsCDVEc.add(x.getTieuDe());
					dsCDVEc.add(x.getGia());
					dsCDVEc.add(x.getMa());
					dsCDVEc.add(x.getNamXB());
					dtm.addRow(dsCDVEc);
				}
			}
		}
	}
	private void addControls() {
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel pnTK=new JPanel();
		pnTK.setLayout(new FlowLayout());
		
		TitledBorder ttTK=new TitledBorder(BorderFactory.createLineBorder(Color.BLUE,2),
				"Tìm kiếm theo Thể loại và Loại",TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,new Font("Arial", Font.BOLD, 14),Color.RED);
		pnTK.setBorder(ttTK);
		
		JLabel lbTim=new JLabel("Nhập nội dung:");
		txtTk=new JTextField(25);
		btnTimKim=new JButton("Tìm kiếm");
		pnTK.add(lbTim);
		pnTK.add(txtTk);
		pnTK.add(btnTimKim);
		con.add(pnTK,BorderLayout.NORTH);
		
		dtm=new DefaultTableModel();
		dtm.addColumn("Thể loại");
		dtm.addColumn("Loại");
		dtm.addColumn("Tiêu đề");
		dtm.addColumn("Giá");
		dtm.addColumn("Mã");
		dtm.addColumn("Năm XB");
		tblTimKim=new JTable(dtm);
		tblTimKim.setFont(new Font("Arial", Font.ROMAN_BASELINE,15));
		JPanel pnTim=new JPanel();
		pnTim.setLayout(new BorderLayout());
		JScrollPane scbang=new JScrollPane(tblTimKim,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTim.add(scbang,BorderLayout.CENTER);
		
		TitledBorder ttTB=new TitledBorder(BorderFactory.createLineBorder(Color.BLUE,2),
				"Kết quả tìm kiếm",TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,new Font("Arial", Font.BOLD, 14),Color.RED);
		
		pnTim.setBorder(ttTB);
		con.add(pnTim,BorderLayout.CENTER);
	}
	private void xoaToanBoBang() {
		int rowCount = dtm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dtm.removeRow(i);
		}
	}
	public void showWindoW() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
}
