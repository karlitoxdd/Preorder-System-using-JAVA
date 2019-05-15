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

public class ViewWalletRecords extends JFrame{
	File acc;
	FileReader fRead;
	Scanner scan;
	UpdateUser us;
	Vector column;
	Vector row;
	
	static DefaultTableModel model_Acc =new DefaultTableModel();
	static JTable tbl_Acc=new JTable(model_Acc);
	
	public ViewWalletRecords() {
		acc=new File("wallet.txt");
		try {
			getContentPane().setLayout(null);
			acc=new File("walletrecord.txt");
			fRead=new FileReader(acc);
			scan=new Scanner(fRead);
			column=new Vector();
			row=new Vector();
			model_Acc=new DefaultTableModel();
		
			column.add("Date");
			column.add("Customer Name");
			column.add("Amount");
			
			model_Acc.setColumnIdentifiers(column);
			String date="",customer="",amount="";
			
			while(scan.hasNext()) {
				row=new Vector();

				date=scan.next();
				customer=scan.next();
				amount=scan.next();
				
				row.add(date);
				row.add(customer);
				row.add(amount);
				
				model_Acc.addRow(row);
				
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
			setTitle("Wallet Transaction Records");
			setVisible(true);
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}}

}
