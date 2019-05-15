import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class UpdateTable extends JPanel{
	File acc;
	FileReader fRead;
	Scanner scan;
	UpdateUser us;
	Vector column;
	Vector row;
	
	static DefaultTableModel model_Acc =new DefaultTableModel();
	static JTable tbl_Acc=new JTable(model_Acc);
	
	public UpdateTable() {
		acc=new File("wallet.txt");
		try {
			setLayout(null);
			acc=new File("account.txt");
			fRead=new FileReader(acc);
			scan=new Scanner(fRead);
			column=new Vector();
			row=new Vector();
			model_Acc=new DefaultTableModel();
		
			column.add("Name");
			column.add("Username");
			column.add("Password");
			column.add("Date Created");
			column.add("Contact #");
			column.add("Address");
			column.add("E-mail");
			column.add("Age");
			column.add("Gender");
			model_Acc.setColumnIdentifiers(column);
			String name="",un="",pw="",date,cont,add,email,age,gender;
			
			while(scan.hasNext()) {
				row=new Vector();

				name=scan.next();
				un=scan.next();
				pw=scan.next();
				date=scan.next();
				cont=scan.next();
				add=scan.next();
				email=scan.next();
				age=scan.next();
				gender=scan.next();
				
				row.add(name);
				row.add(un);
				row.add(pw);
				row.add(date);
				row.add(cont);
				row.add(add);
				row.add(email);
				row.add(age);
				row.add(gender);
				model_Acc.addRow(row);
				
			}
			
			tbl_Acc=new JTable(model_Acc);
			setLayout(new BorderLayout());
			
			
			add(new JScrollPane(new JScrollPane(tbl_Acc)));
			
			scan.close();
			fRead.close();
			
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		    render.setHorizontalAlignment(JLabel.CENTER);
		    tbl_Acc.getColumnModel().getColumn(0).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(1).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(2).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(3).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(4).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(5).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(6).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(7).setCellRenderer(render); 
		    tbl_Acc.getColumnModel().getColumn(8).setCellRenderer(render); 
			
			
			setBounds(0,0, 758,369);
			setVisible(true);
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		
			us.txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			

			public void changedUpdate(DocumentEvent e) {
				
			}
			
			public void insertUpdate(DocumentEvent e){
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tbl_Acc.getModel())); 
			    sorter.setRowFilter(RowFilter.regexFilter(us.txtSearch.getText()));
			    tbl_Acc.setRowSorter(sorter);
			   
			    
			}
			
			public void removeUpdate(DocumentEvent e){
				TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tbl_Acc.getModel())); 
			    sorter.setRowFilter(RowFilter.regexFilter(us.txtSearch.getText()));

			    tbl_Acc.setRowSorter(sorter);
			}
		
	});}
		
		
		
	}

