import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewPurchases extends JFrame{
	File acc;
	FileReader fRead;
	Scanner scan;
	UpdateUser us;
	Vector column;
	Vector row;
	
	static DefaultTableModel model_Acc =new DefaultTableModel();
	static JTable tbl_Acc=new JTable(model_Acc);
	String code;
	
	public ViewPurchases(String date) {
		acc=new File("sales/sales.txt");
		try {
			FileReader accRead=new FileReader(acc);
			Scanner accScan=new Scanner(accRead);
			String q,w,e;
			while(accScan.hasNext()) {
				q=accScan.next();
				w=accScan.next();
				e=accScan.next();
				if(date.equals(w)) {
					code=q;
				}
			}
			
			File purch=new File("sales/sales_details.txt");
			getContentPane().setLayout(null);
			fRead=new FileReader(purch);
			scan=new Scanner(fRead);
			column=new Vector();
			row=new Vector();
			model_Acc=new DefaultTableModel();
		
			column.add("Order Code");
			column.add("Game Name");
			column.add("Quantity");
			column.add("Price");
			column.add("Total");
			
			model_Acc.setColumnIdentifiers(column);
			String co,or,us,ga,nu,pr,to;
			
			while(scan.hasNext()) {
				row=new Vector();

				co=scan.next();
				or=scan.next();
				us=scan.next();
				ga=scan.next();
				nu=scan.next();
				pr=scan.next();
				to=scan.next();
				
				if(co.equals(code)&&us.equals(MainMenu.user)) {
					row.add(or);
					row.add(ga);
					row.add(nu);
					row.add(pr);
					row.add(to);
					model_Acc.addRow(row);
					}
				
			}
			
			tbl_Acc=new JTable(model_Acc);
			getContentPane().setLayout(new BorderLayout());
			
			
			getContentPane().add(new JScrollPane(new JScrollPane(tbl_Acc)));
			
			scan.close();
			fRead.close();
			
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		    render.setHorizontalAlignment(JLabel.CENTER);
		    tbl_Acc.getColumnModel().getColumn(0).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(1).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(2).setCellRenderer(render); 

			
			
			setBounds(0,0, 611,497);
			setLocationRelativeTo(null);
			setTitle("Purchases Records");
			setVisible(true);
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}}

}
