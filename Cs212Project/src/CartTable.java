import java.awt.BorderLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CartTable extends JPanel{
File acc;
FileReader fRead;
Scanner scan;

Vector column;
Vector row;
static JTable tbl_Cart;
static DefaultTableModel model_Cart =new DefaultTableModel();


	public CartTable() {
		acc=new File(MainMenu.user+".txt");
		try {
			setLayout(null);
			acc=new File(MainMenu.user+".txt");

			fRead=new FileReader(acc);
			scan=new Scanner(fRead);
			column=new Vector();
			row=new Vector();
			model_Cart=new DefaultTableModel();
		
			column.add("Games");
			column.add("Quantity");
			column.add("Price");
			column.add("Total");
			model_Cart.setColumnIdentifiers(column);
			int qty,price,total,alltotal=0,allprice=0,allqty=0;
			String game;
			
			while(scan.hasNext()) {
				row=new Vector();

				game=scan.next();
				qty=Integer.parseInt(scan.next());
				price=Integer.parseInt(scan.next());
				total=qty*price;
				row.add(game);row.add(qty);row.add(price);row.add(total);
				allqty=allqty+qty;
				allprice=allprice+price;
				alltotal=alltotal+total;
				model_Cart.addRow(row);
			}
			row=new Vector();
			row.add("TOTAL");row.add(allqty);row.add(allprice);row.add(alltotal);
			model_Cart.addRow(row);
			tbl_Cart=new JTable(model_Cart);
			setLayout(new BorderLayout());
			setBounds(0, 0, 496, 406);
			
			add(new JScrollPane(new JScrollPane(tbl_Cart)));
			
			scan.close();
			fRead.close();
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		    render.setHorizontalAlignment(JLabel.CENTER);
		   tbl_Cart.getColumnModel().getColumn(1).setCellRenderer(render); 
		   tbl_Cart.getColumnModel().getColumn(2).setCellRenderer(render); 
		   tbl_Cart.getColumnModel().getColumn(3).setCellRenderer(render); 
			
			setBounds(0,0, 496, 406);
			setVisible(true);
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		
}
	}
