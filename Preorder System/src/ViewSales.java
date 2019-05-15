import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSales extends JFrame{
	Vector column;
	Vector row;
	static JTable tbl_trans;
	static DefaultTableModel model_trans =new DefaultTableModel();
	File file;
	JButton btnBack;
	JLabel lblSelectAUser;
	JComboBox comboBox;
	JComboBox comboBoxcode;
	
	public ViewSales() {
	
		getContentPane().setLayout(null);
		
		lblSelectAUser = new JLabel("Select a User:");
		lblSelectAUser.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSelectAUser.setBounds(133, 33, 124, 28);
		getContentPane().add(lblSelectAUser);
		
		comboBox = new JComboBox();
		
		
		File acc=new File("wallet.txt");
		FileReader accRead;
		try {
			accRead = new FileReader(acc);
			Scanner accScan=new Scanner(accRead);
			String accuser,accbal;
			
			while(accScan.hasNext()) {
			accuser=accScan.next();
			accbal=accScan.next();
			
			comboBox.addItem(accuser);
			}
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		
		
					getContentPane().setLayout(null);
					column=new Vector();
					model_trans=new DefaultTableModel();
					column.add("Order Code");
					column.add("Game Name");
					column.add("Quantity");
					column.add("Price");
					column.add("Total");
					model_trans.setColumnIdentifiers(column);

					tbl_trans=new JTable(model_trans);
					
					getContentPane().add(new JScrollPane(new JScrollPane(tbl_trans))).setBounds(12, 84, 658, 456);
					
					DefaultTableCellRenderer render = new DefaultTableCellRenderer();
				    render.setHorizontalAlignment(JLabel.CENTER);
				   tbl_trans.getColumnModel().getColumn(1).setCellRenderer(render); 
				   tbl_trans.getColumnModel().getColumn(2).setCellRenderer(render); 
				   tbl_trans.getColumnModel().getColumn(3).setCellRenderer(render); 
				   
				   
				   
				   
					comboBox.setBounds(269, 31, 124, 30);
					getContentPane().add(comboBox);
					
					
					comboBox.setSelectedIndex(-1);
					
					btnBack = new JButton("Back");
					btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							new AdminWindow();
						}
					});
					btnBack.setBounds(12, 23, 109, 48);
					getContentPane().add(btnBack);
					
					JLabel lblSelectSalesCode = new JLabel("Sales Code:");
					lblSelectSalesCode.setFont(new Font("Arial Black", Font.PLAIN, 16));
					lblSelectSalesCode.setBounds(405, 33, 124, 28);
					getContentPane().add(lblSelectSalesCode);
					
					comboBoxcode = new JComboBox();
					comboBoxcode.setSelectedIndex(-1);
					comboBoxcode.setBounds(527, 31, 124, 30);
					getContentPane().add(comboBoxcode);
					
					comboBox.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								Object item=e.getItem();
								comboBoxcode.removeAllItems();
								File codes=new File("sales/sales.txt");
								try {
									FileReader codesReader=new FileReader(codes);
									Scanner codesScan=new Scanner(codesReader);
									String first,second,third;
									while (codesScan.hasNext()) {
										first=codesScan.next();
										second=codesScan.next();
										third=codesScan.next();
										comboBoxcode.addItem(first);
									}
								} catch (FileNotFoundException e1) {
									System.out.print(e1.getMessage());
								}
								
							}
						}
					});
					
					comboBoxcode.addItemListener(new ItemListener() {
						
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								Object item=e.getItem();
							file=new File("sales/sales_details.txt");
							try {
								getContentPane().setLayout(null);
								FileReader fRead=new FileReader(file);
								Scanner scan=new Scanner(fRead);
								column=new Vector();
								row=new Vector();
								
								DefaultTableModel model_trans=(DefaultTableModel) tbl_trans.getModel();
								model_trans.setRowCount(0);
							
								column.add("Order Code");
								column.add("Game Name");
								column.add("Quantity");
								column.add("Price");
								column.add("Total");
								model_trans.setColumnIdentifiers(column);
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
									
									
									if(co.equals(item)&&us.equals(comboBox.getSelectedItem())) {
									row.add(or);
									row.add(ga);
									row.add(nu);
									row.add(pr);
									row.add(to);
									model_trans.addRow(row);
									}
								}

								JTable tbl_trans=new JTable(model_trans);
								
								getContentPane().add(new JScrollPane(new JScrollPane(tbl_trans))).setBounds(12, 84, 658, 456);
							
								scan.close();
								fRead.close();
								DefaultTableCellRenderer render = new DefaultTableCellRenderer();
							    render.setHorizontalAlignment(JLabel.CENTER);
							   tbl_trans.getColumnModel().getColumn(0).setCellRenderer(render); 
							   tbl_trans.getColumnModel().getColumn(1).setCellRenderer(render); 
							   tbl_trans.getColumnModel().getColumn(2).setCellRenderer(render); 
							   tbl_trans.getColumnModel().getColumn(3).setCellRenderer(render); 
							   tbl_trans.getColumnModel().getColumn(4).setCellRenderer(render); 
							} catch (IOException e2) {
								System.out.print(e2.getMessage());
							}
							
							}
							
						}
					});
		setBounds(0,0,700,600);
		setVisible(true);
		setLocationRelativeTo(null);
				
	}
}

